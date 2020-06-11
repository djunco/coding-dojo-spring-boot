package com.assignment.spring.mapper;

import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.model.WeatherResponse;
import org.springframework.stereotype.Component;

/**
 * Weather Entity Mapper.
 *
 * @author Diego Fernando Junco
 * @since 2020-06-10
 */
@Component
public class WeatherEntityMapper {

  /**
   * Maps OpenWeather API response to WeatherEntity.
   *
   * @param response the OpenWeather API response.
   * @return WeatherEntity.
   */
  public WeatherEntity map(WeatherResponse response) {
    WeatherEntity entity = new WeatherEntity();
    entity.setCity(response.getName());
    entity.setCountry(response.getSys().getCountry());
    entity.setTemperature(response.getMain().getTemp());
    return entity;
  }
}
