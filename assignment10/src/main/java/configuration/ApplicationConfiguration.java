package configuration;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationConfiguration {
@Value("${spoonacular.baseurl}")
private String baseUrl;
@Value("${spoonacular.mealplan}")
private String mealPlan;
@Value("${spoonacular.apikey}")
private String apiKey;


public final String getBaseUrl() {
	return baseUrl;
}
public final String getMealPlan() {
	return mealPlan;
}
public final String getApiKey() {
	return apiKey;
}

}