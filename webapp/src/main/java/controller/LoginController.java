package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.User;

@Controller

public class LoginController {

  @GetMapping("/login")
  public String login(){
	  return "login2";
  }
  
  @PostMapping("/login")
  public String loginusers(RedirectAttributes redirAttrs, @RequestBody User user){
	  //...... logic of login 
	  // check the user exist in database 
	  //check if credentials are correct
	  // return user home or profil or redicrect to home page if success
	  // return signin (GET) with attribute (with error information)
	  
	  //call the service function that verifies the existance of a user in the data base and check if psw is correct
	  //if Service.verifylogin(user) 
	  //if success 
	  //return "redirect:/index";
	  
	  //else if error
	  redirAttrs.addFlashAttribute("message", "Error of success message");
	  redirAttrs.addFlashAttribute("message2", "Error of success message 2");
	  return "redirect:/login";
	  

  }
  
  
	@RequestMapping(value="/logout")
	  public String logout(){
		  return "login2";
	  }
}