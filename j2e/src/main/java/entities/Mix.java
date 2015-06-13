package entities;

public enum Mix {

	Mixed("MIXED", 20.0), Topped("TOPPED", 20.0);

	private String name;
	private double price;

	Mix(String name, double price) {
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
