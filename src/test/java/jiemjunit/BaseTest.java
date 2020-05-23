package jiemjunit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

 class BaseTest {
	
	public static String uat_dev = "uat,dev";
	public static String uat_prod = "uat,prod";
	
	public static String env = "dev";
	
	@BeforeAll
	public static void setup1() {
		System.out.println("before all setup project");
	}
	
	@BeforeAll
	public static void setup2() {
		System.out.println("before all setup project1");
	}
	
	@AfterAll
	public static void teadownAll() {
		System.out.println("after all setup project");
	}
}
