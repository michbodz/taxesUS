package test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.model.Category;
import application.model.Product;
//Sprawdzenie filtrowania produktów pod wzglêdem kategorii
public class ProductFiltering {
	Category category;

	@Test
	public void test() {
		Product apple = new Product(Category.GROCERIES, "apple");
		assert(apple.getCategory().equals(category.GROCERIES));
	}

}
