import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 * take as input a Queue of HtmlTags 
 * and return a Stack of HtmlTags that verifies the correctness of the tag structure, 
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		Stack<HtmlTag> stack = new Stack<>();
		for(HtmlTag tag: tags) {
			if (tag.isOpenTag()) {
				stack.push(tag);
			}else if (tag.isSelfClosing()) {
				continue;
			}else if (!tag.isOpenTag()) {
				if (stack.isEmpty()) {
					return null;
				}else if (tag.matches(stack.peek())) {
					stack.pop();
				}else {
					break;
				}
			}
		}
		return stack;
	}
}


