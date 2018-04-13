package w2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquarelotronTest {
	Squarelotron sq0, sq1, sq2, sq3, sq4, sq5, sq6, sq7, sq8;

	@BeforeEach
	void setUp() throws Exception {
		sq0 = new Squarelotron(3);
		sq1 = new Squarelotron(4);
		sq2 = new Squarelotron(5);
	}

	@Test
	void testSquarelotron() {
		assertEquals(4, sq1.size);
		assertEquals(6, sq1.squarelotron[1][1]);
		assertEquals(5, sq2.size);
		int[][] check2 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		assertArrayEquals(check2[0],sq2.squarelotron[0]);
		assertArrayEquals(check2[1],sq2.squarelotron[1]);
		assertArrayEquals(check2[2],sq2.squarelotron[2]);
		assertArrayEquals(check2[3],sq2.squarelotron[3]);
		assertArrayEquals(check2[4],sq2.squarelotron[4]);
	}

	@Test
	void testUpsideDownFlip() {
		sq3 = sq1.upsideDownFlip(2);
		int[] array1 = {1,2,3,4};
		assertEquals(10, sq3.squarelotron[1][1]);
		assertEquals(11, sq3.squarelotron[1][2]);
		assertEquals(6, sq3.squarelotron[2][1]);
		assertEquals(7, sq3.squarelotron[2][2]);
		assertArrayEquals(array1, sq1.squarelotron[0]);
		sq7 = sq0.upsideDownFlip(1);
		int[] array5 = {7, 8, 9};
		assertArrayEquals(array5, sq7.squarelotron[0]);
		assertEquals(4, sq7.squarelotron[1][0]);
		sq0.rotateRight(1);
		sq8 = sq0.upsideDownFlip(1);
		int[] array6 = {9, 6, 3}; // after rotate sq0
		assertArrayEquals(array6, sq8.squarelotron[0]);		
		
	}
		

	@Test
	void testMainDiagonalFlip() {
		sq4 = sq2.mainDiagonalFlip(1);
		int[] array2 = {1,2,3,4,5};
		assertEquals(6, sq4.squarelotron[0][1]);
		assertEquals(4, sq4.squarelotron[3][0]);
		assertEquals(23, sq4.squarelotron[2][4]);
		assertEquals(8, sq4.squarelotron[1][2]);
		assertArrayEquals(array2, sq2.squarelotron[0]);		
	}

	@Test
	void testRotateRight() {
		sq1.rotateRight(1);
		int[] array3 = {13, 9, 5, 1};
		assertArrayEquals(array3, sq1.squarelotron[0]);
		sq2.rotateRight(-2);
		int[] array4 = {25, 24, 23, 22, 21};
		assertArrayEquals(array4, sq2.squarelotron[0]);
	}

}
