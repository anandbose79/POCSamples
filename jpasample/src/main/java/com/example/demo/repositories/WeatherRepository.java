package com.example.demo.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Weather;

@Repository

public interface WeatherRepository extends JpaRepository <Weather, Long> {

    List<Weather> findAll();
//    @Query("select w from weather w where w.weather_date = ?1")
    @Query("select w from weather w where w.weatherDate = ?1")
    public List<Weather> findBydate(Date dt);
    @Query("select w from weather w where w.id = ?1")
	public List<Weather> findBypkey(Long id);
    @Query("select w from weather w join w.location l where l.latitude = ?1")
	public List<Weather> findBylatitude(Float latitude);
    @Query("select w from weather w join w.temperatures t where t.temperature > 100 ")
    public List<Weather> findBytemp(Float temperature)
;}
