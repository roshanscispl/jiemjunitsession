package store;
import static org.fest.reflect.core.Reflection.method;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class StoreCollectionTest{

	@InjectMocks
	StoreCollection store = new StoreCollection();

	@Mock
	ItemCollectionDao dao = new ItemCollectionDao();
	
	@Mock
	Buyer buyer = new Buyer();
	
	@Mock
	Item item = new Item();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(StoreCollectionTest.class);
	}
	

	@Test
	public void should_return_False_when_buyer_has_0_amount() {
		
		Buyer buyer = mock(Buyer.class);
		//doReturn("test").when(buyer).getName();
		
		
		when(buyer.getAmount()).thenReturn(0.0);
//		when(item.getPrice()).thenReturn(200.00);
		boolean actualReturn = store.canBuyerBuyThisItem(buyer, item);
		assertFalse(actualReturn);
		verify(buyer,times(1)).getAmount();
		
		reset(buyer);
		
	}
//

//	@Test
//	public void bue_item_check() {
//		
//		Buyer buyer = mock(Buyer.class);
//		Item item = mock(Item.class);
//		ItemCollectionDao dao = mock(ItemCollectionDao.class);
//		
//		when(buyer.getAmount()).thenReturn(300.00);
//		when(item.getPrice()).thenReturn(200.00);
//	
//		boolean bol = method("buyItem").withReturnType(Boolean.class).
//				withParameterTypes(Buyer.class, Item.class).in(store).
//		invoke(buyer,item);
//		
//		assertTrue(bol);
//		verify(buyer,times(2)).getAmount();
//		
//		System.out.println(buyer.getAmount());
//		reset(buyer); // mock object - now actual object is there
//		
////		spy()
//		//buyer.setAmount(500.00);
//		System.out.println(buyer.getAmount());
//	}
	
	
	
	
//
//	
//	@Test
//	public void bue_item_check_again() {
		
	//	when(buyer.getAmount()).thenReturn(300.00);
	//	when(item.getPrice()).thenReturn(200.00);
//		boolean actualReturn = store.canBuyerBuyThisItem(buyer, item);
//		boolean bol = method("buyItem").withReturnType(Boolean.class).
//				withParameterTypes(Buyer.class, Item.class).in(store).
//		invoke(buyer,item);
//		spy(buyer);
//		System.out.println(" -> " + buyer.getAmount());
//		assertFalse(bol);
		
		
//		spy(buyer);
		
//		reset(buyer);
//		buyer = new Buyer();
//		buyer.setAmount(300.00);
//		spy(item);
//		spy(item);
//		
////		doReturn(300.00).when(buyer).getAmount();
//		doReturn(200.00).when(item).getPrice();
//		
//		boolean bol = method("buyItem").withReturnType(Boolean.class).
//				withParameterTypes(Buyer.class, Item.class).in(store).
//				invoke(buyer,item);
//		
//		System.out.println(" spy -> " + buyer.getAmount());
//		assertFalse(bol);
//		
		
//		verify(buyer,times(1)).getAmount();
		
		
//	}
//
//
//	@Test
//	public void bue_item_check1() {
//		
//		List<String> ls = spy(ArrayList.class);
//		ls.add("one");
//		verify(ls,times(1)).add("one");
//		assertEquals(1, ls.size());
//		
//		
//	}
//	
//	@Test
//	public void should_return_True_when_buyer_has_400_amount() {
//		
//		when(buyer.getAmount()).thenReturn(400.0);
//		when(item.getPrice()).thenReturn(200.00);
//		boolean actualReturn = store.canBuyerBuyThisItem(buyer, item);
//		assertTrue(actualReturn);
//		verify(buyer,atMost(2)).getAmount();
//	
//	}
//	
////	@Test
////	public void should_return_False_when_buyer_has_less_amount_then_item_price() {
////		
////		when(buyer.getAmount()).thenReturn(200.00);
////		when(item.getPrice()).thenReturn(200.00);
////		boolean actualReturn = store.canBuyerBuyThisItem(buyer, item);
////		assertFalse(actualReturn);
////		
////	
////	}
//	
////	@Test
////	public void should_create_shortcut() {
////		String shortcutPath = "C:\\Users\\Vaibhav\\Desktop\\Training\\Junit\\shortcut.txt";
////		when(dao.getShortCutPath()).thenReturn(shortcutPath);
////		store.createDesktopShortCut();
////		assertTrue(new File(shortcutPath).exists());
////	}
//	
//	
//	
//	
//	
//	
////	@Test
//	public void test() {
//		//dao = new ItemCollectionDao();
////		ItemCollectionDao dao = mock(ItemCollectionDao.class);
////		StoreCollection store = new StoreCollection();
////		store.setDao(dao);
////		store.setDao(dao);
////		store.setDao(dao);
//		
////		Item item = new Item();
////		item.setName("test");
////		
////		when(dao.getPrice(item.getName())).thenReturn(12.0);
////		assertEquals(store.getValuePrice(item), 12.0);
//		
//		//verify(dao, times(2)).getPrice(item.getName());
//		
//		
//	}

}
