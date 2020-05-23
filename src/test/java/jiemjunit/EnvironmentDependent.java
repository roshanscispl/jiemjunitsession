package jiemjunit;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class EnvironmentDependent implements ExecutionCondition{

	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {

		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/execution.properties")));
			if(prop.getProperty("env").equals("prod")) {
				return ConditionEvaluationResult.enabled("because test is running in prod");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ConditionEvaluationResult.disabled("because env is not prod");
	}

}
