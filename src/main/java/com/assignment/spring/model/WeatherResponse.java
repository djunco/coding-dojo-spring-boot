package com.assignment.spring.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coord",
    "weather",
    "base",
    "main",
    "visibility",
    "wind",
    "clouds",
    "dt",
    "sys",
    "id",
    "name",
    "cod"
})
@Getter
@Setter
public class WeatherResponse {

  @JsonProperty("coord")
  private Coord coord;

  @JsonProperty("weather")
  private List<Weather> weather = null;

  @JsonProperty("base")
  private String base;

  @JsonProperty("main")
  private Main main;

  @JsonProperty("visibility")
  private Integer visibility;

  @JsonProperty("wind")
  private Wind wind;

  @JsonProperty("clouds")
  private Clouds clouds;

  @JsonProperty("dt")
  private Integer dt;

  @JsonProperty("sys")
  private Sys sys;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("cod")
  private Integer cod;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<>();

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}
