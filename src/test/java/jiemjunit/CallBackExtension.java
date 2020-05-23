package jiemjunit;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CallBackExtension implements BeforeEachCallback{

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		System.out.println("extension before each");
	}

}
