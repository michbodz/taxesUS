package test;

import static org.junit.Assert.assertFalse;
import java.util.HashMap;
import org.junit.Test;
import application.model.Category;
import application.model.State;


//testowanie poprawnoœci danych w klasie State.
public class SetDateT {
	
	@Test
	public void testIsAlabama() {
		State state = new State("Alabama", null);
		assert(state.toString().equals("Alabama"));
	}
	
	@Test
	public void testIsNotAlabama() {
		State state = new State("Hawaii", null);
		assertFalse(state.toString().equals("Alabama"));	
	}

	@Test
	public void testIsAlabamaTaxes() {
		State state = new State("Alabama", setAlabamaTaxes());
		assert(state.getTaxes().equals(setAlabamaTaxes()));
	}
	
	@Test
	public void testIsNotAlabamaTaxes() {
		State state = new State("Alabama", setAlabamaTaxes());
		assertFalse(state.getTaxes().equals(null));
	}
	
	private HashMap setAlabamaTaxes() {
		HashMap hashMap = new HashMap<Category, Double>();
		hashMap.put(Category.GROCERIES, 4);
		hashMap.put(Category.PREPARED_FOOD, 5);
		hashMap.put(Category.CLOTHING, 6);
		hashMap.put(Category.NON_PRESCRIPTION_DRUG, 7);
		hashMap.put(Category.PRESCRIPTION_DRUG, 8);
		return hashMap;
	}
	
}
