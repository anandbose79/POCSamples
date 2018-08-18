package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Status;
import com.example.demo.models.Weather;
import com.example.demo.repositories.WeatherRepository;

@RestController
public class WeatherController {
	@Autowired
	WeatherRepository rs;
	
	@RequestMapping(value = "/querybyDate", method = RequestMethod.GET)
	public ResponseEntity<List<Weather>> getByDate(@RequestParam String inputDate)
	{
		System.out.println("Here ::"+inputDate);
        try
        {
    		Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);

        	List<Weather> w = rs.findBydate(dt);
        	if (w == null)
        	{
        	
        		return new ResponseEntity<List<Weather>>(w,HttpStatus.NOT_FOUND);
        	}
        	else
        	{
        		System.out.println(w.size());
        		return new ResponseEntity<List<Weather>>(w,HttpStatus.OK);
        	}
        }
        catch (Exception ex)
        {
        	List<Weather> w = new ArrayList<Weather>();
        	w.add(new Weather());
        	System.out.println("Exception::");ex.printStackTrace();
        	return new ResponseEntity<List<Weather>>(w,HttpStatus.BAD_REQUEST);
        }
		
	}
	
	@RequestMapping(value = "/getByLat", method = RequestMethod.GET)
	public ResponseEntity<List<Weather>> getByLat(@RequestParam String inputLatitude)
	{
		System.out.println("Here ::"+inputLatitude);
        try
        {
    		//Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
        	
        	Float ft = Float.valueOf(inputLatitude);
        	
        	List<Weather> w = rs.findBylatitude(ft);
        	if (w == null)
        	{
        	
        		return new ResponseEntity<List<Weather>>(w,HttpStatus.NOT_FOUND);
        	}
        	else
        	{
        		System.out.println(w.size());
        		return new ResponseEntity<List<Weather>>(w,HttpStatus.OK);
        	}
        }
        catch (Exception ex)
        {
        	List<Weather> w = new ArrayList<Weather>();
        	w.add(new Weather());
        	System.out.println("Exception::");ex.printStackTrace();
        	return new ResponseEntity<List<Weather>>(w,HttpStatus.BAD_REQUEST);
        }
		
	}
	
    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public   ResponseEntity<Status> save(@RequestBody  Weather w)
    {

    	System.out.println(w.toString());
    	System.out.println(w.getWeatherDate());
    	Status s = new Status();
    	try
    	{
    		//Location l = w.getLocation();
    		
    		if (rs.findBypkey(w.getId()).size()>0)  return new ResponseEntity<Status>(s, HttpStatus.CONFLICT);
    		rs.save(w);
    		s.setStatusCode("200");
    		s.setStatusMessage("successfull");
    		return new ResponseEntity<Status>(s, HttpStatus.OK);

    		
    	}
    	catch (Exception ex)
    	{
    		ex.printStackTrace();
    		s.setStatusCode("400");
    		s.setStatusMessage("Error");
    		//return new ResponseEntity<Status>(s, HttpStatus.BAD_REQUEST);
    		return new ResponseEntity<Status>(s, HttpStatus.BAD_REQUEST);
    	}
    }
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Weather>> getData()
    {
    	return new ResponseEntity<List<Weather>>(rs.findAll(),HttpStatus.OK);
    }


}
