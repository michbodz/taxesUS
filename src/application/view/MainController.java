package application.view;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

import application.model.Category;
import application.model.Product;
import application.model.State;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class MainController implements Initializable {

	@FXML
	private ComboBox <Category> categories;
	@FXML
	private ComboBox<Product> products;
	@FXML
	private ComboBox<State> country;

	private List<Product> productsList = createProduct();
	
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
	}
	
	private List<State> createState(){
		HashMap hashMap = new HashMap<Category, Double>();
		hashMap.put(Category.GROCERIES, 4);
		hashMap.put(Category.PREPARED_FOOD, 5);
		hashMap.put(Category.CLOTHING, 6);
		hashMap.put(Category.NON_PRESCRIPTION_DRUG, 7);
		hashMap.put(Category.PRESCRIPTION_DRUG, 8);
		return new ArrayList<State>(Arrays.asList(new State("Alabama", hashMap)));
	}

	private List<Product> createProduct(){
		return new ArrayList<>(Arrays.asList(new Product(Category.GROCERIES, "apple"),new Product(Category.CLOTHING, "dressle")));
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
		 Category  c =  categories.getSelectionModel().getSelectedItem();
		 products.setDisable(false);
		 country.setDisable(false);
		 System.out.println("Wybrano kategorie. " + c);
		 products.getItems().clear();
		 products.getItems().addAll(findProduct(c));

	 }
	 @FXML
	 private void onProductSelected(ActionEvent event) {
		 //System.out.println("Wybrano produkt.");
	 }
	 @FXML
	 private void onCountrySelected(ActionEvent event) {
		 //System.out.println("Wybrano stan.");

	 }

}