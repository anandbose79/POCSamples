package com.example.demo.models;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name = "location")
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue
	private Long id;
	private String locationName;
	private Float latitude;
	private Float longitude;  
//	@OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private Weather weather;
	
	public Location(Long id, String locationName, Float latitude, Float longitude, Weather weather) {
		super();
		this.id = id;
		this.locationName = locationName;
		this.latitude = latitude;
		this.longitude = longitude;
	//	this.weather = weather;
	}
//	public Weather getWeather() {
//		return weather;
//	}
//	public void setWeather(Weather weather) {
//		this.weather = weather;
//	}
	public Location() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", locationName=" + locationName + ", latitude=" + latitude + ", longitude="
				+ longitude +  ", " + ", getId()=" + getId()
				+ ", getLocationName()=" + getLocationName() + ", getLatitude()=" + getLatitude() + ", getLongitude()="
				+ getLongitude() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}



}
