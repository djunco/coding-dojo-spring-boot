package com.assignment.spring.client;

import com.assignment.spring.api.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "OpenWeather", url = "${openweather.base.url}")
public interface OpenWeatherClient {
  @RequestMapping(method = RequestMethod.GET)
  WeatherResponse weather(@RequestParam("q") String city, @RequestParam("APPID") String appid);
}
