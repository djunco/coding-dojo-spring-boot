package com.assignment.spring.service;

import com.assignment.spring.api.WeatherResponse;
import com.assignment.spring.client.OpenWeatherClient;
import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Weather Service implementation.
 *
 * @author Diego Fernando Junco
 * @since 2020-06-09
 */
@Service
public class WeatherServiceImpl implements WeatherService {

  private WeatherRepository weatherRepository;
  private OpenWeatherClient openWeatherClient;

  @Value("${openweather.apikey}")
  private String apiKey;

  @Autowired
  public WeatherServiceImpl(
      OpenWeatherClient openWeatherClient, WeatherRepository weatherRepository) {
    this.openWeatherClient = openWeatherClient;
    this.weatherRepository = weatherRepository;
  }

  @Override
  public WeatherEntity weather(String city) {
    WeatherResponse response = openWeatherClient.weather(city, apiKey);
    return mapper(response);
  }

  /**
   * Maps OpenWeather API response to WeatherEntity and persist it to the db.
   *
   * @param response the OpenWeather API response.
   * @return WeatherEntity persisted.
   */
  private WeatherEntity mapper(WeatherResponse response) {
    WeatherEntity entity = new WeatherEntity();
    entity.setCity(response.getName());
    entity.setCountry(response.getSys().getCountry());
    entity.setTemperature(response.getMain().getTemp());

    return weatherRepository.save(entity);
  }
}
