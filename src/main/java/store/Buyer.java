package store;

public class Buyer {
	private String name;
	private double amount;
	
	public String getName() {
		System.out.println("i am get name method");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		System.out.println("i am get amount method");
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
