package jiemjunit;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class PostTestExtension implements TestInstancePostProcessor{

	@Override
	public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
		String t1 = context.getDisplayName();
		System.out.println("Display name is " + t1);
	}

	
}
