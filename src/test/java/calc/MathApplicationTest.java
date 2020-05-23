package calc;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

	@RunWith(MockitoJUnitRunner.class)
	public class MathApplicationTest {
		
	   //@InjectMocks annotation is used to create and inject the mock object
	   //@InjectMocks 
		

	   //@Mock annotation is used to create the mock object to be injected
	   @Mock
	   CalculatorService calcService;

	   @Before
		public void setup() {
			MockitoAnnotations.initMocks(this);
		}
	   
	   @Test
	   public void testAdd(){
		   MathApplication mathApplication = new MathApplication();
		   mathApplication.setCalculatorService(calcService);
		   
		   
	      //add the behavior of calc service to add two numbers
	      when(calcService.add(10.0,20.0)).thenReturn(30.00);
			
	      //test the add functionality
	      Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
	   }

}