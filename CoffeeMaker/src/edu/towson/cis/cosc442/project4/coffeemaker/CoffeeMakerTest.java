package edu.towson.cis.cosc442.project4.coffeemaker;

import junit.framework.TestCase;

/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();

		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(3);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		
	}

	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}
	
	public void testAddRecipe2() {
		cm.addRecipe(r1);
		cm.addRecipe(r1);
		cm.addRecipe(r1);
		cm.addRecipe(r1);
		assertFalse(cm.addRecipe(r1));
	}

	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}

	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	public void testaddInvetory1() {
		assertTrue(cm.addInventory(1, 1, 1, 1));
	}
	
	public void testaddInvetory2() {
		assertTrue(cm.addInventory(0, 0, 0, 0));
	}
	
	
	public void testCheckInventory() {
		cm.addInventory(1, 1, 1, 1);
		assertEquals(16, cm.checkInventory().getCoffee());
		assertEquals(16, cm.checkInventory().getMilk());
		assertEquals(16, cm.checkInventory().getSugar());
		assertEquals(16, cm.checkInventory().getChocolate());
	}
	
	public void testPurchaseBeverage1() {
		cm.addRecipe(r1);
		assertEquals(1, cm.makeCoffee(r1, 51));
	}
	
	public void testPurchaseBeverage2() {
		cm.addRecipe(r1);
		assertEquals(0, cm.makeCoffee(r1, 50));
		assertEquals(12, cm.checkInventory().getCoffee());
		assertEquals(14, cm.checkInventory().getMilk());
		assertEquals(14, cm.checkInventory().getSugar());
		assertEquals(15, cm.checkInventory().getChocolate());
	}
	
	public void testGetRecipeForName() {
		cm.addRecipe(r1);
		assertEquals(r1, cm.getRecipeForName("Coffee"));
	}
	
	
	
	
	
}