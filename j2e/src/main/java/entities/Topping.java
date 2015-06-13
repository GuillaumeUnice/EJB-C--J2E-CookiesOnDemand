package entities;

import java.io.Serializable;

public enum Topping implements Serializable{
	WhiteChocolate("WHITE_CHOCOLATE", 7.0), MilkChocolate("MILK_CHOCOLATE",
			5.0), MMS("MMS", 15), ReeseButtercup("REESE_BUTTERCUP", 20.0);

	private String name;
	private double price;

	Topping(String name, double price) {
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
