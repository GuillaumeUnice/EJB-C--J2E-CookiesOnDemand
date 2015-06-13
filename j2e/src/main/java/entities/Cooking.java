package entities;

public enum Cooking {

	Crunchy("CRUNCHY", 20.0), Chewy("CHEWY", 20.0);

	private String name;
	private double price;

	Cooking(String name, double price) {
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
