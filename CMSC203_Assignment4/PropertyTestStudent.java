import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	private Property property;

	@BeforeEach
	void setUp() throws Exception {
		property = new Property("Mansion", "Bethesda", 4000.0, "Madison Harris", 1, 2, 3, 4);
	}

	@AfterEach
	void tearDown() throws Exception {
		property = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Mansion", property.getPropertyName());
	}

	@Test
	void testGetCity() {
		assertEquals("Bethesda", property.getCity());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(4000.0, property.getRentAmount());
	}

	@Test
	void testGetOwner() {
		assertEquals("Madison Harris", property.getOwner());
	}

	@Test
	void testGetPlot() {
		Plot p = property.getPlot();
		assertEquals(1, p.getX());
		assertEquals(2, p.getY());
		assertEquals(3, p.getDepth());
		assertEquals(4, p.getWidth());
	}

	@Test
	void testSetName() {
		property.setName("Mega Mansion");
		assertEquals("Mega Mansion", property.getPropertyName());
	}

	@Test
	void testSetCity() {
		property.setCity("NYC");
		assertEquals("NYC", property.getCity());
	}

	@Test
	void testSetAmount() {
		property.setAmount(90000.45);
		assertEquals(90000.45, property.getRentAmount());
	}

	@Test
	void testSetOwner() {
		property.setOwner("Jane Doe");
		assertEquals("Jane Doe", property.getOwner());
	}

	@Test
	void testSetPlot() {
		Plot newPlot = new Plot(10,20,30,40);
		property.setPlot(newPlot);
		Plot p = property.getPlot();
		assertEquals(10, p.getX());
		assertEquals(20, p.getY());
		assertEquals(30, p.getDepth());
		assertEquals(40, p.getWidth());
	}

	@Test
	void testToString() {
		assertEquals("Mansion,Bethesda,Madison Harris,4000.0", property.toString());
	}
}
