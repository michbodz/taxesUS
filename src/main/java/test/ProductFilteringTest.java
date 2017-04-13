package test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.model.Category;
import application.model.Product;

//Sprawdzenie filtrowania produktów pod wzglêdem kategorii
public class ProductFilteringTest {
	Category category;

	@Test
	public void testGROCERIES() {
		Product apple = new Product(Category.GROCERIES, "apple", 1);
		assert(apple.getCategory().equals(category.GROCERIES));
	}
	
	@Test
	public void testNotGROCERIES() {
		Product apple = new Product(Category.GROCERIES, "apple", 1);
		assertFalse(apple.getCategory().equals(category.CLOTHING));
	}

}