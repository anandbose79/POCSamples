package com.example.demo.models;

public class Location {

	private Long id;
	private String locationName;
	private Float latitude;
	private Float longitude;
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
				+ longitude + "]";
	}
	public Location(Long id, String locationName, Float latitude, Float longitude) {
		super();
		this.id = id;
		this.locationName = locationName;
		this.latitude = latitude;
		this.longitude = longitude;
	}  

    public Location()
    {
    	
    }
}
