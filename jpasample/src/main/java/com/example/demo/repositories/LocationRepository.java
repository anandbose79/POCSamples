package com.example.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.entity.WeatherEntity;

@Repository

public interface LocationRepository extends JpaRepository <WeatherEntity, Long> {

    List<WeatherEntity> findAll();
//    @Query("select w from weather w where w.weather_date = ?1")
    @Query("select w from weather w where w.weatherDate = ?1")
    public List<WeatherEntity> findBydate(Date dt);
    
}
