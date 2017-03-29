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
		return new ArrayList<>(Arrays.asList(new Product(Category.GROCERIES, "apple", 5),new Product(Category.CLOTHING, "dressle", 20)));
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
		 
		 calculateBruttoPrice();
	 }

}