package jiemjunit;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CallBackMethodsExtension implements BeforeEachCallback, BeforeAllCallback,AfterEachCallback,AfterAllCallback{

	@Override
	public void afterAll(ExtensionContext context) throws Exception {
		System.out.println("afterAll");
	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		System.out.println("afterEach");
	}

	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		System.out.println("beforeAll");
	}

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		System.out.println("beforeEach");
	}

	
	
}
