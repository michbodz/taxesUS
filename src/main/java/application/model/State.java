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
	DoubleProperty currentTax;
	HashMap taxes =  new HashMap<Category, Double>();


    public State(String name, HashMap taxes) {
        this.name = new SimpleStringProperty(name);
        this.currentTax = new SimpleDoubleProperty();
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
    
    public double getCurrentTax() {
        return currentTax.get();
    }
    
    public void setCurrentTax(double currentTax) {
		this.currentTax.set(currentTax);
    }
    
    public DoubleProperty currentTaxProperty() {
		return currentTax;
	}
    
}
