package com.example.demo.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.*;
import com.example.demo.models.entity.*;
import com.example.demo.repositories.WeatherRepository;
import com.example.demo.services.interfaces.WeatherServiceInterface;

@Service
public class WeatherService implements WeatherServiceInterface {

	@Autowired
	WeatherRepository rs;
	
	@Override
	public ResponseEntity<Status> saveWeather(Weather w) {
		// TODO Auto-generated method stub
		//check if this already exists
		Status s = new Status();

		try
		{
			if (rs.findBypkey(w.getId()).size() > 0)
			{
				s.setStatusCode("DUPLICATE");
				s.setStatusMessage("Duplicate - Record with this id exists");
				return new ResponseEntity<Status>(s,HttpStatus.UNAUTHORIZED);
			}
		}
		catch (Exception ex)
		{
			s.setStatusCode("ERROR");
			s.setStatusMessage("Errored out ::" + ex.getMessage());
			ex.printStackTrace();
			return new ResponseEntity<Status>(s,HttpStatus.NOT_ACCEPTABLE);
			
			
		}
		WeatherEntity wEntity = new WeatherEntity();
		wEntity.setId(w.getId());
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		dFormat.setTimeZone(TimeZone.getTimeZone("CST"));
		try
		{
			wEntity.setWeatherDate(dFormat.parse(w.getWeatherDate()));
		}
		catch (Exception ex)
		{
			s.setStatusCode("ERROR");
			s.setStatusMessage("Errored out ::" + ex.getMessage());
			ex.printStackTrace();
			return new ResponseEntity<Status>(s,HttpStatus.NOT_ACCEPTABLE);
				
		}
		LocationEntity  locEntity = new LocationEntity();
		locEntity.setLatitude(w.getLocation().getLatitude());
		locEntity.setLocationName(w.getLocation().getLocationName());
		locEntity.setLongitude(w.getLocation().getLongitude());
		locEntity.setWeather(wEntity);
		wEntity.setLocation(locEntity);
		List<TemperaturesEntity> tempEntityList = new ArrayList<TemperaturesEntity>();
		for (int i=0 ;i<w.getTemperatures().length;i++)
		{
			Float temp = w.getTemperatures()[i];
			TemperaturesEntity tempEntity = new TemperaturesEntity();
			
			tempEntity.setTemperature(temp);
			tempEntity.setWeather(wEntity);
			tempEntityList.add(tempEntity);
			
		}
		wEntity.setTemperatures(tempEntityList);
		rs.save(wEntity);
		s.setStatusCode("200");
		s.setStatusMessage("Successfully inserted");
		return new ResponseEntity<Status>(s,HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<List<Weather>> getWeatherbyDate(String input) {
		// TODO Auto-generated method stub
		Date d = 
		List<Weather> w = transformEntitytoWeather(rs.findBylatitude(latitude,Longitude));
		if (w==null || w.size() == 0)
			return new ResponseEntity<List<Weather>>(w,HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Weather>>(w,HttpStatus.OK);
		
		return null;
	}

	@Override
	public ResponseEntity<List<Weather>> getWeatherbyLoc(Float latitude, Float Longitude) {
		// TODO Auto-generated method stub
		List<Weather> w = transformEntitytoWeather(rs.findBylatitude(latitude,Longitude));
		if (w==null || w.size() == 0)
			return new ResponseEntity<List<Weather>>(w,HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Weather>>(w,HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<List<Weather>> getAll() {
		// TODO Auto-generated method stub
		List<WeatherEntity> wEntityList = rs.findAll();
		
		return new ResponseEntity<List<Weather>>(transformEntitytoWeather(wEntityList),HttpStatus.OK);
	}
	
	
	private List<Weather> transformEntitytoWeather(List<WeatherEntity> wEntityList)
	{
		List<Weather> wList = new ArrayList<Weather>();
		for (WeatherEntity wEntity : wEntityList)
		{
			Weather w = new Weather();

			w.setId(wEntity.getId());
			Location l = new Location();
			l.setLatitude(wEntity.getLocation().getLatitude());
			l.setLocationName(wEntity.getLocation().getLocationName());
			l.setLongitude(wEntity.getLocation().getLongitude());
			Float[] temperatures = new Float[wEntity.getTemperatures().size()];
			int i = 0;
			for(TemperaturesEntity tEntity:wEntity.getTemperatures())
			{
				temperatures[i] = tEntity.getTemperature();
				i++;
			}
			w.setTemperatures(temperatures);
			w.setLocation(l);
			w.setWeatherDate(wEntity.getWeatherDate());
			w.setId(wEntity.getId());
			wList.add(w);
		}
		return wList;
		
	}

}
