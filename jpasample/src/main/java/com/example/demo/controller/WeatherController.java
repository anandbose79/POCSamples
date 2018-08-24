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
import com.example.demo.models.Location;
import com.example.demo.models.Weather;
import com.example.demo.repositories.WeatherRepository;
import com.example.demo.services.interfaces.WeatherServiceInterface;

@RestController
public class WeatherController {
	@Autowired
	WeatherServiceInterface wInterface;
	@RequestMapping(value = "/querybyDate", method = RequestMethod.GET)
	public ResponseEntity<List<Weather>> getByDate(@RequestParam String inputDate)
	{
//		System.out.println("Here ::"+inputDate);
//        try
//        {
//    		Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
//
//        	List<Weather> w = rs.findBydate(dt);
//        	if (w == null)
//        	{
//        	
//        		return new ResponseEntity<List<Weather>>(w,HttpStatus.NOT_FOUND);
//        	}
//        	else
//        	{
//        		System.out.println(w.size());
//        		return new ResponseEntity<List<Weather>>(w,HttpStatus.OK);
//        	}
//        }
//        catch (Exception ex)
//        {
//        	List<Weather> w = new ArrayList<Weather>();
//        	w.add(new Weather());
//        	System.out.println("Exception::");ex.printStackTrace();
//        	return new ResponseEntity<List<Weather>>(w,HttpStatus.BAD_REQUEST);
//        }
        return null;
		
	}
	
	@RequestMapping(value = "/getByLat", method = RequestMethod.GET)
	public ResponseEntity<List<Weather>> getByLat(@RequestParam String inputLatitude,@RequestParam String inputLongitude)
	{

		return null;
	}
	
    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public   ResponseEntity<Status> save(@RequestBody  Weather w)
    {

      return 	wInterface.saveWeather(w);
    }
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Weather>> getData()
    {
  //  	return new ResponseEntity<List<Weather>>(rs.findAll(),HttpStatus.OK);
    	return wInterface.getAll();
    }


}
