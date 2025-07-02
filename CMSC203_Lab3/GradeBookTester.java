import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	
	private GradeBook book1;
	private GradeBook book2;
	
	@BeforeEach
	void setUp() throws Exception {
		book1=new GradeBook(5);
		book2=new GradeBook(5);
		
		book1.addScore(98.0);
		book1.addScore(57.34);
		
		book2.addScore(87.61);
		book2.addScore(95.50);
	}

	@AfterEach
	void tearDown() throws Exception {
		book1=null;
		book2=null;
	}

	@Test
	void testAddScore() {
		assertTrue(book1.toString().equals("98.0 57.34 "));
		assertEquals(2, book1.getScoreSize());
		assertEquals(2, book2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(book1.sum(), 155.34);
		assertEquals(book2.sum(), 183.11);
	}

	@Test
	void testMinimum() {
		assertEquals(book1.minimum(), 57.34);
		assertEquals(book2.minimum(), 87.61);
	}

	@Test
	void testFinalScore() {
		assertEquals(book1.finalScore(), 98.0);
		assertEquals(book2.finalScore(), 95.50);
	}

	@Test
	void testGetScoreSize() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
