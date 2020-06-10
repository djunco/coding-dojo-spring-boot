package com.assignment.spring.constant;

/**
 * Resource Mapping constant class.
 *
 * @author Diego Fernando Junco
 * @since 2020-06-10
 */
public final class ResourceMapping {
  private ResourceMapping() {
    throw new IllegalStateException("Utility class");
  }

  // Endpoints
  public static final String WEATHER = "/weather";
}
