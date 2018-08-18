package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "temperatures")
@Table(name = "temperatures")
public class Temperatures {
	@Id
	@GeneratedValue()
	private Long id;

	private Float temperature;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "weather_id")
//    private Weather weather;
//    
//    public Weather getWeather() {
//		return weather;
//	}
//	public void setWeather(Weather weather) {
//		this.weather = weather;
//	}
	public Temperatures()
    {
    	
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getTemperature() {
		return temperature;
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public Temperatures(Long id, Float temperature, Weather weather) {
		super();
		this.id = id;
		this.temperature = temperature;
		//this.weather = weather;
	}
	@Override
	public String toString() {
		return "Temperatures [id=" + id + ", temperature=" + temperature + ", getId()=" + getId()
				+ ", getTemperature()=" + getTemperature() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


}
