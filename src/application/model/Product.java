package application.model;

/**
 * User: Klaudia
 * Date: 15.03.2017
 * Time: 22:17
 */
public class Product {
    Category category;
    String name;

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Product(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
