package jiemjunit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@ExtendWith(PostTestExtension.class)
@ExtendWith(CallBackMethodsExtension.class)
@ExtendWith(EnvironmentDependent.class)
@Execution(ExecutionMode.CONCURRENT)
public class ExtendsWithAnnotationDemo {

	public ExtendsWithAnnotationDemo(){
		System.out.println("Constructor creating ");
	}

	public Code1 getInstance() {
		return new Code1();
	}

	@Test
	@Tag("prod")
	@DisplayName("should_mulitply_value_correctly display name")
	public void should_mulitply_value_correctly() {
		int i= 10;
		int j = 20;
		assertEquals(200,getInstance().multiply(i, j));
		try {
			System.out.println("Sleeping for 10 sec");
			Thread.sleep(10000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Tag("prod")
	@DisplayName("should_mulitply_value_correctly display name")
	public void should_mulitply_value_correctly1() {
		int i= 10;
		int j = 20;
		assertEquals(200,getInstance().multiply(i, j));
		try {
			System.out.println("Sleeping for 5 sec");
			Thread.sleep(5000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
