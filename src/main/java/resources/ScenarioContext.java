package resources;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

	private final Map<String, Object> scenarioContext = new HashMap<>();
	
	public void setContext(String key, Object value) {
		scenarioContext.put(key, value);
    }
	
	public Object getContext(String key) {
        return scenarioContext.get(key);
    }	
}
