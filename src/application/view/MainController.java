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
				
				double netto = Double.parseDouble(nettoPrice.getText());
				taxLabel.setText(currentTax + "% podatku");
				bruttoLabel.setText(netto+(netto*currentTax/100) +" z?");
				
			}
		});
	}
	
	private List<State> createState(){
		State alabama;
		HashMap hashMap = new HashMap<Category, Double>();
		hashMap.put(Category.GROCERIES, 4);
		hashMap.put(Category.PREPARED_FOOD, 5);
		hashMap.put(Category.CLOTHING, 6);
		hashMap.put(Category.NON_PRESCRIPTION_DRUG, 7);
		hashMap.put(Category.PRESCRIPTION_DRUG, 8);
		alabama = new State("Alabama", hashMap);
		
		return new ArrayList<State>(Arrays.asList(alabama));
	}

	private List<Product> createProduct(){
		return new ArrayList<>(Arrays.asList(new Product(Category.GROCERIES, "apple", 5),
				new Product(Category.GROCERIES, "pear", 4),
				new Product(Category.GROCERIES, "banana", 3),
				new Product(Category.GROCERIES, "pineapple", 7),
				new Product(Category.PREPARED_FOOD, "spaghetti", 12),
				new Product(Category.PREPARED_FOOD, "chicken soup", 10),
				new Product(Category.PREPARED_FOOD, "pancakes", 9),
				new Product(Category.PREPARED_FOOD, "cheeseburger", 7),
				new Product(Category.CLOTHING, "T-shirt", 5),
				new Product(Category.CLOTHING, "jacket", 20),
				new Product(Category.CLOTHING, "dress", 45),
				new Product(Category.CLOTHING, "jumper", 30),
				new Product(Category.NON_PRESCRIPTION_DRUG, "Aspirin", 7),
				new Product(Category.NON_PRESCRIPTION_DRUG, "Antidol 15", 9),
				new Product(Category.NON_PRESCRIPTION_DRUG, "Cholinex", 5),
				new Product(Category.NON_PRESCRIPTION_DRUG, "Verdin", 4),
				new Product(Category.PRESCRIPTION_DRUG, "ADRENALINE",8),
				new Product(Category.PRESCRIPTION_DRUG, "DIAZEPAM",5),
				new Product(Category.PRESCRIPTION_DRUG, "INSULIN",4),
				new Product(Category.PRESCRIPTION_DRUG, "OSELTAMIVIR",6)));
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
	 }

}