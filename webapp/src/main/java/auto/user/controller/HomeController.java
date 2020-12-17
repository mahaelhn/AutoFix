package auto.user.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/index")
public class HomeController {
	
	public String home() {
		return "index";
	}
	
}


