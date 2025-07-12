import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
	private Plot plot;
	private Plot overlappingPlot;
	private Plot nonOverlappingPlot;
	private Plot innerPlot;
	private Plot outerPlot;

	@BeforeEach
	void setUp() throws Exception {
		plot = new Plot(7, 11, 20, 25);  

		overlappingPlot = new Plot(10, 15, 10, 10); 

		nonOverlappingPlot = new Plot(100, 100, 5, 5); 

		innerPlot = new Plot(10, 12, 5, 5);

		outerPlot = new Plot(0, 0, 100, 100);
	}

	@AfterEach
	void tearDown() throws Exception {
		plot = null;
		overlappingPlot = null;
		nonOverlappingPlot = null;
		innerPlot = null;
		outerPlot = null;
	}

	@Test
	void testGetX() {
		assertEquals(7, plot.getX());
	}

	@Test
	void testGetY() {
		assertEquals(11, plot.getY());
	}

	@Test
	void testGetDepth() {
		assertEquals(20, plot.getDepth());
	}

	@Test
	void testGetWidth() {
		assertEquals(25, plot.getWidth());
	}

	@Test
	void testSetXcoord() {
		plot.setXcoord(8);
		assertEquals(8, plot.getX());
	}

	@Test
	void testSetYcoord() {
		plot.setYcoord(12);
		assertEquals(12, plot.getY());
	}

	@Test
	void testSetWidth() {
		plot.setWidth(26);
		assertEquals(26, plot.getWidth());
	}

	@Test
	void testSetDepth() {
		plot.setDepth(21);
		assertEquals(21, plot.getDepth());
	}

	@Test
	void testOverlaps() {
		assertTrue(plot.overlaps(overlappingPlot));
		assertFalse(plot.overlaps(nonOverlappingPlot));
	}

	@Test
	void testEncompasses() {
		assertTrue(plot.encompasses(innerPlot));
		assertFalse(plot.encompasses(outerPlot));
	}

	@Test
	void testToString() {
		assertEquals("7,11,20,25", plot.toString());
	}
}
