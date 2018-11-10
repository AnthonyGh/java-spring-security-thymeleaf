package fr.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import fr.security.entities.Article;
import fr.security.services.IArticleService;

@Controller
public class AdminController {
	
	@Autowired
	private IArticleService articleService;
	
	@GetMapping("/admin")
	 public String admin(Model model) {
		
		List<Article> articles = articleService.findAllArticles();
    	model.addAttribute("articles", articles);
    	
		 return "/admin/admin";
	 }
	
	
	
	
	
}
