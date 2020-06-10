package com.assignment.spring.controller;

import com.assignment.spring.constant.ResourceMapping;
import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.service.WeatherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller that provides /weather endpoints.
 *
 * @author Diego Fernando Junco
 * @since 2020-06-09
 */
@RestController
public class WeatherController {

  private WeatherService weatherService;

  @Autowired
  public WeatherController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  /**
   * Returns and stores weather information based on the city provided as a parameter.
   *
   * @param city the city name to query.
   * @return WeatherEntity containing weather data
   */
  @GetMapping(ResourceMapping.WEATHER)
  @ApiOperation("Returns and stores weather information based on the city provided as a parameter")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 401, message = "Unauthorized")
      })
  public ResponseEntity<WeatherEntity> weather(@RequestParam("city") String city) {
    return new ResponseEntity<>(weatherService.weather(city), HttpStatus.OK);
  }
}
