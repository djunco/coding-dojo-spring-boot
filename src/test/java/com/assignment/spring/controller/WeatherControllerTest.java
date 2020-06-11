package com.assignment.spring.controller;

import com.assignment.spring.model.Main;
import com.assignment.spring.model.Sys;
import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.client.OpenWeatherClient;
import feign.FeignException;
import feign.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.HashMap;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Weather Controller WebMVC test to test /weather endpoints.
 *
 * @author Diego Fernando Junco
 * @since 2020-06-10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherControllerTest {

  @Autowired private MockMvc mockMvc;
  @MockBean private OpenWeatherClient openWeatherClient;
  private static final String AMSTERDAM = "amsterdam";
  private static final String WEATHER = "/weather";

  /**
   * Invokes /weather endpoint to search weather for a valid city an expects a HTTP 200 Ok response.
   *
   * @throws Exception Any possible exception
   */
  @Test
  public void getWeatherInfoFromValidCity() throws Exception {
    Sys sys = new Sys();
    sys.setCountry("NL");
    Main main = new Main();
    main.setTemp(289.82);
    WeatherResponse weatherResponse = new WeatherResponse();
    weatherResponse.setName(AMSTERDAM);
    weatherResponse.setSys(sys);
    weatherResponse.setMain(main);

    when(openWeatherClient.weather(AMSTERDAM, "tbd")).thenReturn(weatherResponse);
    mockMvc
        .perform(
            MockMvcRequestBuilders.get(WEATHER)
                .param("city", AMSTERDAM)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  /**
   * Invokes /weather endpoint with an invalid api key an expects a HTTP 401 Unauthorized response.
   *
   * @throws Exception Any possible exception
   */
  @Test
  public void getUnauthorizedResponseFromInvalidApiKey() throws Exception {
    when(openWeatherClient.weather(AMSTERDAM, "tbd"))
        .thenThrow(
            new FeignException.Unauthorized(
                "status 401 reading OpenWeatherClient#weather(String,String)",
                Request.create(Request.HttpMethod.GET, "", new HashMap<>(), null),
                null));
    mockMvc
        .perform(
            MockMvcRequestBuilders.get(WEATHER)
                .param("city", AMSTERDAM)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnauthorized());
  }

  /**
   * Invokes /weather endpoint to search weather for an invalid city an expects a HTTP 404 Not found
   * response.
   *
   * @throws Exception Any possible exception
   */
  @Test
  public void getWeatherInfoFromInvalidCity() throws Exception {
    when(openWeatherClient.weather("aaa", "tbd"))
        .thenThrow(
            new FeignException.NotFound(
                "status 404 reading OpenWeatherClient#weather(String,String)",
                Request.create(Request.HttpMethod.GET, "", new HashMap<>(), null),
                null));
    mockMvc
        .perform(
            MockMvcRequestBuilders.get(WEATHER)
                .param("city", "aaa")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }
}
