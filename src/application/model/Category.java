package application.model;

public enum Category {

	GROCERIES("Groceries"),
	PREPARED_FOOD("Prepared food"),
	PRESCRIPTION_DRUG("Prescription drug"),
	NON_PRESCRIPTION_DRUG("Non prescription drug"),
	CLOTHING("Clothing");

	private  String label;
	Category(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
