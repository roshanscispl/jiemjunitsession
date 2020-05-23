package jiemjunit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Code1 {

	public int sum(int i, int j) {
		if(i < 0) {
			i = 0;
		}
		if(j < 0) {
			j = 0;
		}
		return i+j;
	}

//	public int sum(int...i) {
//		int sum = 0;
//		for(int j = 0 ; j < i.length ; j++) {
//			sum += i[j];
//		}
//		return sum;
//	}
	
	public int substract(int i, int j) {
		return i-j;
	}
	
	public int multiply(int i, int j) {
		return i*j;
	}
	
	public int square(int i) {
		return multiply(i, i);
	}
	
	public int devide(int i , int j) throws ArithmeticException{
		if(j == 0) {
			throw new ArithmeticException("j value is " + 0);
		}
		return i/j;
	}
	
	public Human setObject(String name , int age) {
		return new Human(name, age);
	}
	
	public List<Human> setObject(Map<String,Integer> map) {
		List<Human> humanObjects = new ArrayList<Human>();
		for(Entry<String,Integer> entry  : map.entrySet()) {
			humanObjects.add(new Human(entry.getKey(), entry.getValue()));
		}
		return humanObjects;
	}
	
}
