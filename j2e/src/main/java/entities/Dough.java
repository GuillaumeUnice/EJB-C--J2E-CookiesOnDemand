package entities;

public enum Dough {

	Plain("PLAIN", 20.0), Chocolate("CHOCOLATE", 20.0), PeanutButter(
			"PEANUT_BUTTER", 20.0), Oatmeal("OATMEAL", 20.0);

	private String name;
	private double price;

	Dough(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
