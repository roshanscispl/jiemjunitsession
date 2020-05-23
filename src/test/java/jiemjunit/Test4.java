package jiemjunit;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class Test4 implements TestInstancePostProcessor{

	@Override
	public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
		String txt = context.getDisplayName();
		System.out.println("Extend class : "+txt);
	}

}
