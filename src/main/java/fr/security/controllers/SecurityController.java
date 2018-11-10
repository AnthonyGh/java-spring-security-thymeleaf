package fr.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.security.entities.Article;
import fr.security.services.IArticleService;

@Controller
public class SecurityController {

	@Autowired
	private IArticleService articleService;
	
    @GetMapping("/")
    public String home(Model model) {
    	List<Article> articles = articleService.findAllArticles();
    	model.addAttribute("articles", articles);
        return "/public/home";
    }

    @GetMapping("/accueil")
    public String accueil() {
        return "/public/home";
    }

   

    

    @GetMapping("/about")
    public String about() {
        return "/public/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}
