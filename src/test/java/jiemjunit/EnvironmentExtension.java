package jiemjunit;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class EnvironmentExtension  implements ExecutionCondition{

	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
		return ConditionEvaluationResult.enabled("Test enable on QA env");
	}
	
}
