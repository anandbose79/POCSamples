package com.example.demo.models;


import java.util.Arrays;
import java.util.Date;

public class Weather {

private Long id;

 private String weatherDate;
 private Location location;
 private Float[] temperatures;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getWeatherDate() {
	return weatherDate;
}
public void setWeatherDate(String weatherDate) {
	this.weatherDate = weatherDate;
}
public Location getLocation() {
	return location;
}
public void setLocation(Location location) {
	this.location = location;
}
public Float[] getTemperatures() {
	return temperatures;
}
public void setTemperatures(Float[] temperatures) {
	this.temperatures = temperatures;
}
@Override
public String toString() {
	return "Weather [id=" + id + ", weatherDate=" + weatherDate + ", location=" + location + ", temperatures="
			+ Arrays.toString(temperatures) + "]";
}
public Weather(Long id, String weatherDate, Location location, Float[] temperatures) {
	super();
	this.id = id;
	this.weatherDate = weatherDate;
	this.location = location;
	this.temperatures = temperatures;
}
public Weather()
{
	
}

}


