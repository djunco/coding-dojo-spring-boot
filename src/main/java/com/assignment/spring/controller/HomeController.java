package com.assignment.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home redirection to swagger controller documentation.
 *
 * @author Diego Fernando Junco
 * @since 2020-06-10
 */
@Controller
public class HomeController {
  @GetMapping(value = "/")
  public String index() {
    return "redirect:swagger-ui.html";
  }
}
