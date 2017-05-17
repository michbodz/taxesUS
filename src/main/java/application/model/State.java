package application.model;

import java.util.HashMap;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * User: Klaudia
 * Date: 15.03.2017
 * Time: 22:15
 */
public class State {
	StringProperty name;
	IntegerProperty currentTax;
	DoubleProperty currentPrice;
	HashMap taxes =  new HashMap<Category, Double>();


    public State(String name, HashMap taxes) {
        this.name = new SimpleStringProperty(name);
        this.currentTax = new SimpleIntegerProperty();
        this.currentPrice = new SimpleDoubleProperty();
        this.taxes = taxes;
    }

    @Override
    public String toString() {
        return name.get();
    }

	public HashMap getTaxes() {
		return taxes;
	}

	public String getName() {
        return name.get();
    }

    public void setName(String firstName) {
        this.name.set(firstName);
    }

    public StringProperty nameProperty() {
        return name;
    }
    
    public int getCurrentTax() {
        return currentTax.get();
    }
    
    public void setCurrentTax(int currentTax) {
		this.currentTax.set(currentTax);
    }
    
    public IntegerProperty currentTaxProperty() {
		return currentTax;
	}
    
    public double getCurrentPrice() {
        return currentPrice.get();
    }
    
    public void setCurrentPrice(double currentPrice) {
		this.currentPrice.set(currentPrice);
    }
    
    public DoubleProperty currentPriceProperty() {
		return currentPrice;
	}
    
}
