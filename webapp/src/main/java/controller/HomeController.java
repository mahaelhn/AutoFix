package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping("/index")
	public String home() {
		return "index";
	}
	 @GetMapping("/login2")
	  public String login(){
		  return "login2";
	  }
	
	
}


