package fr.security.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.security.entities.User;
import fr.security.services.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/user")
    public String user() {
        return "/user/user";
    }
	
	

	@RequestMapping(value="/create-user", method=RequestMethod.GET)
	public String formUser(Model model) {
		model.addAttribute("user", new User());
		return "/public/usercreateform";
	}
	
	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()) {
			return "/public/usercreateform";
		}
		
		user.setRole("NORMAL");
		
		userService.createUser(user);
		

		
		return "redirect:login";
	}
}
