import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

	private ManagementCompany managementCo, invalidManagementCo;
	private Property prop1, prop2;

	@BeforeEach
	void setUp() throws Exception {
		managementCo = new ManagementCompany("Exit Right Reality", "12345678", 13);
		invalidManagementCo = new ManagementCompany("LOL", "12345678", 200);
		
		prop1 = new Property("Watershed", "Los Angeles", 9999.99, "Yo Gabba Gabba", 1, 1, 1, 1);
		prop2 = new Property("Villages at Wellington", "Burtonsville", 2500.0, "Meredith Grey", 5, 5, 1, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		managementCo = null;
		prop1 = prop2 = null;
	}

	@Test
	void testGetName() {
		assertEquals("Exit Right Reality", managementCo.getName());
	}

	@Test
	void testGetTaxID() {
		assertEquals("12345678", managementCo.getTaxID());
	}

	@Test
	void testGetPercent() {
		assertEquals(13, managementCo.getPercent());
	}

	@Test
	void testGetNumberOfProperties() {
		managementCo.addProperty(prop1);
		managementCo.addProperty(prop2);
		assertEquals(2, managementCo.getNumberOfProperties());
	}

	@Test
	void testGetProperties() {
		managementCo.addProperty(prop1);
		managementCo.addProperty(prop2);
		assertEquals("Watershed", managementCo.getProperties()[0].getPropertyName());
	}

	@Test
	void testGetPlot() {
		assertEquals(0, managementCo.getPlot().getX());
		assertEquals(0, managementCo.getPlot().getY());
		assertEquals(10, managementCo.getPlot().getWidth());
		assertEquals(10, managementCo.getPlot().getDepth());
	}

	@Test
	void testSetName() {
		managementCo.setName("New MGMT");
		assertEquals("New MGMT", managementCo.getName());
	}

	@Test
	void testSetTaxID() {
		managementCo.setTaxID("87654321");
		assertEquals("87654321", managementCo.getTaxID());
	}

	@Test
	void testSetPercent() {
		managementCo.setPercent(90);
		assertEquals(90, managementCo.getPercent());
	}

	@Test
	void testSetProperties() {
		Property[] props = new Property[ManagementCompany.MAX_PROPERTY];
		props[0] = prop1;
		props[1]=prop2;
		managementCo.setProperties(props);
		assertEquals("Villages at Wellington", managementCo.getProperties()[1].getPropertyName());
	}

	@Test
	void testSetPlot() {
		Plot newPlot = new Plot(5, 10, 15, 20);
		managementCo.setPlot(newPlot);
		assertEquals(5, managementCo.getPlot().getX());
		assertEquals(10, managementCo.getPlot().getY());
		assertEquals(15, managementCo.getPlot().getDepth());
		assertEquals(20, managementCo.getPlot().getWidth());
	}

	@Test
	void testAddPropertyProperty() {
		assertEquals(0, managementCo.addProperty(prop1));
		assertEquals(1, managementCo.addProperty(prop2));
	}

	@Test
	void testAddPropertyStringStringDoubleStringIntIntIntInt() {
		int index = managementCo.addProperty("Montgomery College", "Rockville", 7410852.2, "Montgomery Owner", 9, 5, 1, 1);
		assertEquals(0, index);
	}

	@Test
	void testGetTotalRent() {
		managementCo.addProperty(prop1);
		managementCo.addProperty(prop2);
		assertEquals(9999.99 + 2500.0, managementCo.getTotalRent(), 0.01);
	}

	@Test
	void testGetHighestRentProperty() {
		managementCo.addProperty(prop1);
		managementCo.addProperty(prop2);
		assertEquals("Watershed", managementCo.getHighestRentProperty().getPropertyName());
	}

	@Test
	void testRemoveLastProperty() {
		managementCo.addProperty(prop1);
		managementCo.addProperty(prop2);
		managementCo.removeLastProperty();
		assertEquals(1, managementCo.getNumberOfProperties());
	}

	@Test
	void testIsPropertiesFull() {
		// Fill to max
		for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
			managementCo.addProperty("PROP" + i, "City", 50.0, "Doe", i, i, 1, 1);
		}
		assertTrue(managementCo.isPropertiesFull());
	}

	@Test
	void testGetPropertiesCount() {
		managementCo.addProperty(prop1);
		managementCo.addProperty(prop2);
		assertEquals(2, managementCo.getPropertiesCount());
	}

	@Test
	void testIsManagementFeeValid() {
		assertTrue(managementCo.isManagementFeeValid());
		assertFalse(invalidManagementCo.isManagementFeeValid());
	}

	@Test
	void testToString() {
		managementCo.addProperty(prop1);
		assertTrue(managementCo.toString().contains("Watershed"));
		assertTrue(managementCo.toString().contains("total management Fee"));
	}
}
