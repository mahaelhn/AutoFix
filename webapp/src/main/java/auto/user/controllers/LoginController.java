package auto.user.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping(value="/login2")
  public String login(){
	  return "login2";
  }
	@RequestMapping(value="/logout")
	  public String logout(){
		  return "login2";
	  }
}