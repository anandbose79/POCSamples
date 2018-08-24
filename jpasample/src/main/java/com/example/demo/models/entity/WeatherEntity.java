package com.example.demo.models.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Id;


@Entity(name = "weather")
@Table(name = "weather")
public class WeatherEntity {
@Id
private Long id;

 public Long getId() {
	return id;
}
@Temporal(TemporalType.DATE)
 private Date weatherDate;
 @OneToOne(cascade=CascadeType.ALL,orphanRemoval = true)
@JoinColumn(name = "location_id")
 private LocationEntity location;
 
 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
 @JoinColumn(name = "temperatures_id")
 private List<TemperaturesEntity> temperatures;

public void setId(Long id) {
	this.id = id;
}
public Date getWeatherDate() {
	return weatherDate;
}
public void setWeatherDate(Date weatherDate) {
	this.weatherDate = weatherDate;
}
public LocationEntity getLocation() {
	return location;
}
public void setLocation(LocationEntity location) {
	this.location = location;
}
public List<TemperaturesEntity> getTemperatures() {
	return temperatures;
}
public void setTemperatures(List<TemperaturesEntity> temperatures) {
	this.temperatures = temperatures;
}
public WeatherEntity()
{
	
}
public WeatherEntity(long id, Date weatherDate, LocationEntity location, List<TemperaturesEntity> temperatures) {
	super();
	this.id = id;
	this.weatherDate = weatherDate;
	this.location = location;
	this.temperatures = temperatures;
}
@Override
public String toString() {
	return "Weather [id=" + id + ", weatherDate=" + weatherDate + ", location=" + location + ", temperatures="
			+ temperatures + ", getId()=" + getId() + ", getWeatherDate()=" + getWeatherDate() + ", getLocation()="
			+ getLocation() + ", getTemperatures()=" + getTemperatures() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}



}
