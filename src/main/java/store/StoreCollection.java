package store;

import java.io.File;

public class StoreCollection {
	
	private ItemCollectionDao dao;
	 
//	public void setDao(ItemCollectionDao dao) {
//		this.dao = dao;
//	}

	public Item getItem(String itemName) {
		Item itm = dao.getItem(itemName);
		return itm;
	}
	
	public double getValuePrice(Item item) {
		double price = dao.getPrice(item.getName());
		return price;
	}
	
	public boolean canBuyerBuyThisItem(Buyer buyer, Item item) {
		
		System.out.println("Name : " + buyer.getName());
		double db = buyer.getAmount();
		if(db > 0 && db >= item.getPrice()) {
			return true;
		}
		return false;
		
	}
	
	private boolean buyItem(Buyer buyer, Item item) {
		if(canBuyerBuyThisItem(buyer, item)) {
			buyer.setAmount(buyer.getAmount()-item.getPrice());
			return true;
		}
		return false;
	}
	
	public void modifyItem(Item item) {
		item.setPrice(10);
	}
	
	
	public void createDesktopShortCut() {
		// logic
		String path = dao.getShortCutPath();
		// creating shortcut
		try {
			new File(path).createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
