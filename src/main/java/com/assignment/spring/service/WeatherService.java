package com.assignment.spring.service;

import com.assignment.spring.entity.WeatherEntity;

/**
 * Weather Service interface.
 *
 * @author Diego Fernando Junco
 * @since 2020-06-09
 */
public interface WeatherService {

  /**
   * Returns and stores weather information based on the city provided as a parameter.
   *
   * @param city the city name to query.
   * @return WeatherEntity containing weather data
   */
  WeatherEntity weather(String city);
}
