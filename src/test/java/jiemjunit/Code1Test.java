package jiemjunit;

import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;



@Execution(ExecutionMode.CONCURRENT)
@TestMethodOrder(Alphanumeric.class)
class Code1Test extends BaseTest{

	private Code1Test() {
		//System.out.println("i am the constructor of Code1Test");
	}
	
	@Nested
	class Check_Positive_Cases {
		Code1 code= null;
		public Code1 getInstance() {
			return code;
		}
		
		@BeforeEach
		public void setup() {
			code= new Code1();
		}

		@AfterEach
		public void teardown() {
			code = null;
		}

		@ParameterizedTest(name="first Value {0} and second value {1} and expected {2}")
		@CsvFileSource(resources = "/Code1_sum_method_test.csv",numLinesToSkip = 1)
		void sum_should_return_correct_values(int value1, int value2, int expected) {


			//when
			int sum = getInstance().sum(value1,value2);

			// then
			assertEquals(expected, sum);

		}
		
		@ParameterizedTest
		@ValueSource(ints = {10,20,30,40})
		void square_should_return_correct_values(int i) {
			int actual = getInstance().square(i);
			assertEquals(i*i, actual);
		}
	}

	@Nested
	class Check_Exception_Cases{
		Code1 code= null;
		public Code1 getInstance() {
			if(code == null) {
				code= new Code1();
			}
			return code;
		}
		@BeforeEach
		public void setup() {
			getInstance();
		}

		@AfterEach
		public void teardown() {
			code = null;
		}

		@Test
		@Tag("performence")
		void devide_should_throw_exception() {
			// given 
			int i = 10;
			int j = 0;

			Executable exec = () -> code.devide(i, j);
			assertThrows(ArithmeticException.class, exec);
		}

		@RepeatedTest(10)
		@Tag("performence")
		void setObject_should_set_name_and_age() {
			Human human = code.setObject("Test1", 20);

			assertAll(
					() -> assertEquals("Test1", human.getName()),
					() -> assertEquals(20, human.getAge())
					);
		}

		@Test
		@Tag("performence")
		void setObject_should_not_increase_performace_time() {

			Map<String, Integer> t1 = new HashMap<String, Integer>();
			for(int i = 1; i < 1000000 ;i++) {
				t1.put("Test1", i);
			}
			assertTimeout(Duration.ofMillis(1), ()->code.setObject(t1));
		}
	}

	@Nested
	class Check_Assumption_Cases{
		Code1 code= null;
		public Code1 getInstance() {
			return code;
		}
		@BeforeEach
		public void setup() {
			code= new Code1();
		}

		@AfterEach
		public void teardown() {
			code = null;
		}
		// this case is applicable for uat env
		@Test
		@DisplayName("sum testcase")
		@DisabledOnOs({OS.LINUX,OS.MAC})
		//@DisabledOnJre(JRE.JAVA_8)
		@Tag("uat")
		@Tag("prod")
	 void sum_should_return_correct_values_assumption() {
			//precondition
//			assumeFalse(env.equals("uat"));

			
			//when
			int sum = getInstance().sum(10,20);

			// then
			assertEquals(30, sum);
		}
	}



}
