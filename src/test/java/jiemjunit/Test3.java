package jiemjunit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.function.Executable;


@ExtendWith(CallBackExtension.class)
@ExtendWith(Test4.class)
@ExtendWith(EnvironmentExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class Test3 {
	
//	public Code1 getInstance() {
//		if(code == null) {
		Code1 code = new Code1();
	
//		}
//		return code;
//	}
//	@BeforeEach
//	public void setup() {
////		getInstance();
//	}

//	@AfterEach
//	public void teardown() {
//		code = null;
//	}

	@Test
	@Tag("performence")
	@Order(2)
	void devide_should_throw_exception() {
		// given 
		int i = 10;
		int j = 0;

		Executable exec = () -> code.devide(i, j);
		assertThrows(ArithmeticException.class, exec);
	}

	@Test
	@Tag("performence")
	@Order(1)
	void setObject_should_set_name_and_age(TestInfo testinfo) {
		System.out.println(testinfo.getDisplayName());
		System.out.println(testinfo.getTestMethod().get().getName());
		System.out.println(testinfo.getTestClass());
		Human human = code.setObject("Test1", 20);

		assertAll(
				() -> assertEquals("Test1", human.getName()),
				() -> assertEquals(20, human.getAge())
				);
	}

	@TestFactory
	public Collection<DynamicTest> factory() {
		List<DynamicTest> tests = new ArrayList<DynamicTest>();
		for(int i = 0 ; i < 20 ;i++) {
			int r1 = (int)(Math.random()*100);
			int r2 = (int)(Math.random()*100);
			tests.add(DynamicTest.dynamicTest("Add "+r1+" + " + r2, ()->assertEquals(r1+r2, code.sum(r2, r1))));
		}
		return tests;
	}
	
	
}
