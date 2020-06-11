package com.assignment.spring.service;

import com.assignment.spring.client.OpenWeatherClient;
import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.mapper.WeatherEntityMapper;
import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Weather Service implementation.
 *
 * @author Diego Fernando Junco
 * @since 2020-06-09
 */
@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

  private final WeatherRepository weatherRepository;
  private final OpenWeatherClient openWeatherClient;
  private final WeatherEntityMapper weatherEntityMapper;

  @Value("${openweather.apikey}")
  private String apiKey;

  @Override
  public WeatherEntity weather(String city) {
    WeatherResponse response = openWeatherClient.weather(city, apiKey);
    return weatherRepository.save(weatherEntityMapper.map(response));
  }
}
