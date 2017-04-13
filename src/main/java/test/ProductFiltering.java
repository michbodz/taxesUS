package test;

import static org.junit.Assert.*;


import application.model.Category;
import application.model.Product;
import org.junit.Test;
//Sprawdzenie filtrowania produkt�w pod wzgl�dem kategorii


public class ProductFiltering {
    Category category;

    @Test
    public void testGROCERIES() {
        Product apple = new Product(Category.GROCERIES, "apple", 1);
        assert (apple.getCategory().equals(category.GROCERIES));
    }

    @Test
    public void testNotGROCERIES() {
        Product apple = new Product(Category.GROCERIES, "apple", 1);
        assertFalse(apple.getCategory().equals(category.CLOTHING));
    }

}
