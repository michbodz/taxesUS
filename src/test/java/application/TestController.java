package application;

import static org.junit.Assert.fail;

import org.junit.Test;

import application.view.MainController;

public class TestController {
	@Test
	public void testNumericInt() {
		MainController tc = new MainController();
		if(!tc.isNumeric("5")) {
			fail("To jest liczba");
		}	
	}
	
	@Test
	public void testNumericDouble() {
		MainController tc = new MainController();
		if(!tc.isNumeric("5.00")) {
			fail("To jest liczba");
		}	
	}

	

	
	@Test
	public void testNumericString() {
		MainController tc = new MainController();
		if(tc.isNumeric("test")) {
			fail("To jest napis");
		}	
	}
	
	@Test
	public void testNumericString1() {
		MainController tc = new MainController();
		if(tc.isNumeric("5487test")) {
			fail("To jest napis");
		}	
	}
	
	@Test
	public void testNumericBigInt() {
		MainController tc = new MainController();
		if(!tc.isNumeric("19446744073709551615")) {
			fail("To jest liczba");
		}	
	}
	
	@Test
	public void testNumericZero() {
		MainController tc = new MainController();
		if(!tc.isNumeric("0")) {
			fail("To jest liczba");
		}	
	}
	
	
}
