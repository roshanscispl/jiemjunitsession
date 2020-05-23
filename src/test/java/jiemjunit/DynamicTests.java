package jiemjunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

public class DynamicTests {
	
	public Code1 getInstance() {
		return new Code1();
	}
	
	@BeforeEach
	public void setup() {
		System.out.println("setup");
	}
	
	@TestFactory
	public Collection<DynamicTest> should_test_dynamic_input() {
		List<DynamicTest> tests = new ArrayList<DynamicTest>(); 
		
		for(int i = 0; i < 10 ;i++) {
			int value1 = (int)(Math.random()*1000);
			int value2 = (int)(Math.random()*1000);
			
			int actual = getInstance().sum(value1, value2); // coming from the method
			
			DynamicTest test = DynamicTest.dynamicTest
					("Sum of "+value1 + " and " +value2, () -> assertEquals((value1+value2), actual));
			tests.add(test);
		}
		
		return tests;
		
	}
	
	
}
