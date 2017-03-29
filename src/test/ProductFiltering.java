package test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.model.Category;
import application.model.Product;
//Sprawdzenie filtrowania produkt�w pod wzgl�dem kategorii
public class ProductFiltering {
	Category category;

	@Test
	public void test() {
		Product apple = new Product(Category.GROCERIES, "apple");
		assert(apple.getCategory().equals(category.GROCERIES));
	}

}
