package com.example.demo.services.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.models.Status;
import com.example.demo.models.Weather;


public interface WeatherServiceInterface {
	
	public ResponseEntity<Status> saveWeather(Weather w);
	public ResponseEntity<List<Weather>> getWeatherbyDate(String input);
	public ResponseEntity<List<Weather>> getWeatherbyLoc(Float latitude,Float Longitude);
	public ResponseEntity<List<Weather>> getAll();
	

}
