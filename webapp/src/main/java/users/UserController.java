package users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/user")
	public String getUserForm(Model model)
	{
		model.addAttribute("user",userservice.getUser());
		return "login2";
	}
	
	@PostMapping("/users")
	public String getAllUsers(@RequestBody User user,Model model)
	{
		model.addAttribute("user",userservice.getAllUsers());
		userservice.addUser(user);
		return "login2";
	}

}