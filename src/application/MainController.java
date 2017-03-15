package application;

import java.net.URL;
import java.util.ResourceBundle;

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

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		System.out.println("initialize(). jest git.");
	}
	
	
	 @FXML
	 private void onCategorySelected(ActionEvent event) {
		 System.out.println("Wybrano kategorie.");
	 }
	 @FXML
	 private void onProductSelected(ActionEvent event) {
		 System.out.println("Wybrano produkt.");
	 }
	 @FXML
	 private void onCountrySelected(ActionEvent event) {
		 System.out.println("Wybrano stan.");
	 }

}