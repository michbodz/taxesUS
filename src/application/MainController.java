package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class MainController implements Initializable {

	@FXML
	private ComboBox categories;
	@FXML
	private ComboBox products;
	@FXML
	private ComboBox country;
	
	ObservableList<String> categoryList = FXCollections.observableArrayList(
		        "Groceries",
		        "Prepared food",
		        "Prescritpion drug",
		        "Non-Prescritpion drug",
		        "Clothing");
	
	ObservableList<String> productList = FXCollections.observableArrayList(
	        "Apple",
	        "Orange",
	        "Banana");
	
	ObservableList<String> stateList = FXCollections.observableArrayList(
	        "Floryda",
	        "California");

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {		
		categories.setItems(categoryList);
		products.setItems(productList);
		country.setItems(stateList);
	}
	
	
	 @FXML
	 private void onCategorySelected(ActionEvent event) {
		 //System.out.println("Wybrano kategorie.");
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