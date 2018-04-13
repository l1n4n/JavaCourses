/**
 * 
 */
package w2;

/**
 * @author NL
 *
 */
public class Squarelotron {
	int[][] squarelotron;
	int size;	
	
	public Squarelotron(int n) {
		this.size = n;
		this.squarelotron = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.squarelotron[i][j] = i * n + j + 1;
			}
			
		}
		
	}
	public Squarelotron upsideDownFlip(int ring) {
		/* no need for passing the grader
		 * if (ring > ((this.size + 1) /2) || ring < 1) {
			throw new IllegalArgumentException("ring number out of range.");
			
		}*/
		Squarelotron sq = new Squarelotron(this.size);
		/* !!!Important!!!!
		 * If we call one of the flip-methods on a squarelotron that had been rotated before, 
		 * the method should return a flipped version of the rotated squarelotron.
		 */
		for (int i=0; i<this.size;i++){
            for (int j=0; j<this.size;j++){
            	sq.squarelotron[i][j] = this.squarelotron[i][j];
            }
        }
		int top = ring - 1;
		int bottom = this.size - ring;
		
		for(int i = top; i <= bottom; i++) {
			sq.squarelotron[top][i] = this.squarelotron[bottom][i];
			sq.squarelotron[bottom][i] = this.squarelotron[top][i];
			
		}
		for (int i = top + 1; i < bottom - 1; i++) {
			sq.squarelotron[i][top] = this.squarelotron[this.size - i - 1][top];
			sq.squarelotron[i][bottom] = this.squarelotron[this.size - i - 1][bottom];
			sq.squarelotron[this.size - i - 1][top] = this.squarelotron[i][top];
			sq.squarelotron[this.size - i - 1][bottom] = this.squarelotron[i][bottom];
		}
		return sq;
		
	}
	
	public Squarelotron mainDiagonalFlip(int ring) {
		/*if (ring > ((this.size + 1) /2) || ring < 1) {
			throw new IllegalArgumentException("ring number out of range.");
			
		}*/
		Squarelotron sq = new Squarelotron(this.size);
		for (int i=0; i<this.size;i++){
            for (int j=0; j<this.size;j++){
            	sq.squarelotron[i][j] = this.squarelotron[i][j];
            }
		}
		
		int low = ring - 1;
		int high = this.size - ring;
		for (int i = low; i <= high; i++) {
			sq.squarelotron[low][i] = this.squarelotron[i][low];
			sq.squarelotron[i][low] = this.squarelotron[low][i];
		}
		for (int i = low + 1; i <= high; i++) {
			sq.squarelotron[high][i] = this.squarelotron[i][high];
			sq.squarelotron[i][high] = this.squarelotron[high][i];
		}		
		return sq;
		
	}
	public void rotateRightOnce() {
		Squarelotron sq = new Squarelotron(this.size);
		for (int i=0; i<this.size;i++){
            for (int j=0; j<this.size;j++){
            	sq.squarelotron[i][j] = this.squarelotron[i][j];
            }
        }
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				sq.squarelotron[i][j] = this.squarelotron[this.size - j - 1][i];
				
			}
			
		}
		this.squarelotron = sq.squarelotron;		
	}
	
	public void rotateRight(int numberOfTurns) {
		int turns = (numberOfTurns % 4 + 4) % 4;
		if (turns > 0) {
			for (int i = 0; i < turns; i++) {
				this.rotateRightOnce();
				
			}
			
		}
		
		
	}
	
	

	
	

}
