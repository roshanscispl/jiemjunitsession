package store;

public interface ItemCollectionDaoI {
	public Item getItem(String itemName);
	public double getPrice(String item);
}
