package com.assignment.spring.controller;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Home Controller Tests.
 *
 * @author Diego Fernando Junco
 * @since 2020-06-20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeControllerTest {

  @Autowired private HomeController controller;

  @Test
  public void loadSwaggerTest() {
    String response = controller.index();
    String expectedResponse = "redirect:swagger-ui.html";
    assertEquals(expectedResponse, response);
  }
}
