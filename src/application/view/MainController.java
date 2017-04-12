package application.view;

import application.model.Category;
import application.model.Product;
import application.model.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;

public class MainController implements Initializable {

	@FXML
	private ComboBox <Category> categories;
	@FXML
	private ComboBox<Product> products;
	@FXML
	private ComboBox<State> country;
	@FXML

	private Label bruttoLabel;
	@FXML
	private Label taxLabel;
	@FXML

	private TextField nettoPrice;

	private List<Product> productsList = createProduct();
	private State currentState;
	private Category currentCategory;
	private int currentTax;
	
//	ObservableList<String> categoryList = FXCollections.observableArrayList(
//		        Category.GROCERIES.getLabel(),
//		        Category.PREPARED_FOOD.getLabel(),
//		        Category.PRESCRIPTION_DRUG.getLabel(),
//		        Category.NON_PRESCRIPTION_DRUG.getLabel(),
//		        Category.CLOTHING.getLabel());

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
//		categories.setItems(categoryList);

		this.categories.getItems().setAll(Category.values());

		products.setDisable(true);
		products.getItems().addAll(createProduct());

		country.getItems().addAll(createState());
		country.setDisable(true);
		
		nettoPrice.textProperty().addListener((observable, oldValue, newValue) -> {
			if(nettoPrice.getText().length() > 0) {
				calculateBruttoPrice();
			}
		});
	}
	
	private void calculateBruttoPrice() {
		double netto = Double.parseDouble(nettoPrice.getText());
		taxLabel.setText(currentTax + "% podatku");
		bruttoLabel.setText(netto+(netto*currentTax/100) +" zl");
	}
	
	private List<State> createState(){
		State alabama, hawaii, mississippi, texas, oklahoma;
		HashMap hashMap = new HashMap<Category, Double>();
		hashMap.put(Category.GROCERIES, 4);
		hashMap.put(Category.PREPARED_FOOD, 5);
		hashMap.put(Category.CLOTHING, 6);
		hashMap.put(Category.NON_PRESCRIPTION_DRUG, 7);
		hashMap.put(Category.PRESCRIPTION_DRUG, 8);
		alabama = new State("Alabama", hashMap);
		
		HashMap hashMap2 = new HashMap<Category, Double>();
		hashMap2.put(Category.GROCERIES, 5);
		hashMap2.put(Category.PREPARED_FOOD, 5);
		hashMap2.put(Category.CLOTHING, 5);
		hashMap2.put(Category.NON_PRESCRIPTION_DRUG, 5);
		hashMap2.put(Category.PRESCRIPTION_DRUG, 5);
		hawaii = new State("Hawaii", hashMap2);
		
		HashMap hashMap3 = new HashMap<Category, Double>();
		hashMap3.put(Category.GROCERIES, 7);
		hashMap3.put(Category.PREPARED_FOOD, 7);
		hashMap3.put(Category.CLOTHING, 7);
		hashMap3.put(Category.NON_PRESCRIPTION_DRUG, 7);
		hashMap3.put(Category.PRESCRIPTION_DRUG, 7);
		mississippi = new State("Mississippi", hashMap3);	
		
		HashMap hashMap4 = new HashMap<Category, Double>();
		hashMap4.put(Category.GROCERIES, 6);
		hashMap4.put(Category.PREPARED_FOOD, 8);
		hashMap4.put(Category.CLOTHING, 6);
		hashMap4.put(Category.NON_PRESCRIPTION_DRUG, 8);
		hashMap4.put(Category.PRESCRIPTION_DRUG, 6);
		texas = new State("Texas", hashMap4);	
		
		HashMap hashMap5 = new HashMap<Category, Double>();
		hashMap5.put(Category.GROCERIES, 4);
		hashMap5.put(Category.PREPARED_FOOD, 11);
		hashMap5.put(Category.CLOTHING, 4);
		hashMap5.put(Category.NON_PRESCRIPTION_DRUG, 11);
		hashMap5.put(Category.PRESCRIPTION_DRUG, 4);
		oklahoma = new State("Oklahoma", hashMap5);	
		
		
		
		return new ArrayList<State>(Arrays.asList(alabama, hawaii, mississippi, texas, oklahoma));
	}

	private List<Product> createProduct(){
		return new ArrayList<>(Arrays.asList(new Product(Category.GROCERIES, "Apple", 5),
				new Product(Category.GROCERIES, "Pear", 4),
				new Product(Category.GROCERIES, "Banana", 3),
				new Product(Category.GROCERIES, "Pineapple", 7),
				new Product(Category.GROCERIES, "Apple", 8),
				new Product(Category.GROCERIES, "Celery", 5),
				new Product(Category.GROCERIES, "Corn", 6),
				new Product(Category.PREPARED_FOOD, "Spaghetti", 12),
				new Product(Category.PREPARED_FOOD, "Chicken soup", 10),
				new Product(Category.PREPARED_FOOD, "Pancakes", 9),
				new Product(Category.PREPARED_FOOD, "Cheeseburger", 7),
				new Product(Category.PREPARED_FOOD, "Rice with chicken", 12),
				new Product(Category.PREPARED_FOOD, "Pizza", 15),
				new Product(Category.PREPARED_FOOD, "Hot-dog", 9),
				new Product(Category.PREPARED_FOOD, "Dumplings", 7),
				new Product(Category.CLOTHING, "T-shirt", 5),
				new Product(Category.CLOTHING, "Jacket", 20),
				new Product(Category.CLOTHING, "Dress", 45),
				new Product(Category.CLOTHING, "Jumper", 30),
				new Product(Category.CLOTHING, "Shoes", 5),
				new Product(Category.CLOTHING, "Trousers", 29),
				new Product(Category.CLOTHING, "Coat", 48),
				new Product(Category.CLOTHING, "High heels", 300),
				new Product(Category.NON_PRESCRIPTION_DRUG, "Aspirin", 7),
				new Product(Category.NON_PRESCRIPTION_DRUG, "Antidol 15", 9),
				new Product(Category.NON_PRESCRIPTION_DRUG, "Cholinex", 5),
				new Product(Category.NON_PRESCRIPTION_DRUG, "Verdin", 4),
				new Product(Category.NON_PRESCRIPTION_DRUG, "APAP", 6),
				new Product(Category.NON_PRESCRIPTION_DRUG, "APAP Noc", 8),
				new Product(Category.NON_PRESCRIPTION_DRUG, "APAP Dzien", 9),
				new Product(Category.NON_PRESCRIPTION_DRUG, "Vitamin C", 10),
				new Product(Category.PRESCRIPTION_DRUG, "Adrenaline",8),
				new Product(Category.PRESCRIPTION_DRUG, "Diazepam",5),
				new Product(Category.PRESCRIPTION_DRUG, "Insulin",4),
				new Product(Category.PRESCRIPTION_DRUG, "Adderall",8),
				new Product(Category.PRESCRIPTION_DRUG, "Xanax",15),
				new Product(Category.PRESCRIPTION_DRUG, "Doxycycline",4),
				new Product(Category.PRESCRIPTION_DRUG, "Lexapro",26)));
	}

	private List<Product> findProduct(Category category){
		List <Product> products = new ArrayList<>();
		for(Product p: productsList){
			if(p.getCategory().equals(category)){
				products.add(p);
			}
		}
		return products;
	}
	
	
	
	 @FXML
	 private void onCategorySelected(ActionEvent event) {
		 currentCategory =  categories.getSelectionModel().getSelectedItem();
		 products.setDisable(false);
		 country.setDisable(false);
		 System.out.println("Wybrano kategorie. " + currentCategory);
		 products.getItems().clear();
		 products.getItems().addAll(findProduct(currentCategory));
		 
		 if(currentState != null) {
			 currentTax = (int)currentState.getTaxes().get(currentCategory);
			 taxLabel.setText(currentTax + "% podatku");
		 }
	 }
	 @FXML
	 private void onProductSelected(ActionEvent event) {
		 //System.out.println("Wybrano produkt.");
		 nettoPrice.setText(Float.toString(products.getValue().getPrice()));
	 }
	 @FXML
	 private void onCountrySelected(ActionEvent event) {
		 currentState = country.getSelectionModel().getSelectedItem();
		 
		 currentTax = (int)currentState.getTaxes().get(currentCategory);
		 taxLabel.setText(currentTax + "% podatku");
		 if(nettoPrice.getText().length() > 0) {
			 calculateBruttoPrice();
		 }
	 }

}