package application.model;

/**
 * User: Klaudia
 * Date: 15.03.2017
 * Time: 22:17
 */
public class Product {
    Category category;
    String name;
    float price;

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
    
    public float getPrice(){
    	return price;
    }

    public Product(Category category, String name, float d) {
        this.category = category;
        this.name = name;
        this.price = d;
    }

    @Override
    public String toString() {
        return name;
    }
}
