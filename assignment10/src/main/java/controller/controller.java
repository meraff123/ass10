package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coderscampus.ass10.model.DayResponse;

import Service.DayMeals;
import Service.WeekMeals;
import model.WeekResponse;

public class controller {
	@Autowired
	private WeekMeals weekMeals;
	@Autowired
	private DayMeals dayMeals;
	
	@GetMapping("/mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(
			@RequestParam(value = "timeFrame", defaultValue = "week", required = false) String timeFrame,
			@RequestParam(value = "targetCalories", required = false) Double targetCalories,
			@RequestParam(value = "diet", required = false) String diet,
			@RequestParam(value = "exclude", required = false) String exclude) {
		ResponseEntity<WeekResponse> printMeals = weekMeals.generateMeals(timeFrame, targetCalories, diet, exclude);
		return printMeals;
	}

	@GetMapping("/mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(@RequestParam(value = "timeFrame", defaultValue = "day") String timeFrame,
			@RequestParam(value = "targetCalories", required = false) Double targetCalories,
			@RequestParam(value = "diet", required = false) String diet,
			@RequestParam(value = "exclude", required = false) String exclude) {
		ResponseEntity<DayResponse> printMeals = dayMeals.generateMeals(timeFrame, targetCalories, diet, exclude);
		return printMeals;
	}
}
		
