package application.model;

import java.util.HashMap;

/**
 * User: Klaudia
 * Date: 15.03.2017
 * Time: 22:15
 */
public class State {
    String name;
    HashMap taxes =  new HashMap<Category, Double>();


    public State(String name, HashMap taxes) {
        this.name = name;
        this.taxes = taxes;
    }

    @Override
    public String toString() {
        return name;
    }
}
