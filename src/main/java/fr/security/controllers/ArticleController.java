package fr.security.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.security.entities.Article;
import fr.security.services.IArticleService;

@Controller
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;

	@GetMapping("/article/{id}")
    public String home1(Model model, @PathVariable("id") Integer id) {
    	Article article = articleService.findArticleById(id);
    	model.addAttribute("article", article);
        return "/public/article";
    }
	
	
	
	
	
	
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String formArticle(Model model) {
		model.addAttribute("article", new Article());
		return "/admin/articleform";
	}
	
	@RequestMapping(value="/saveArticle", method=RequestMethod.POST)
	public String saveArticle(@Valid Article article, BindingResult bindingResult) throws IllegalStateException, IOException {
		if(bindingResult.hasErrors()) {
			return "/admin/articleform";
		}
		
		article.setDateCreate(LocalDate.now());
		
		articleService.createArticle(article);
		
		return "redirect:admin";
	}
	
	
	
	@RequestMapping(value="/editer")
	public String showFormEdit(Integer id, Model model) {
		Article article = articleService.findArticleById(id);
		model.addAttribute("article", article);
		return "/admin/editformarticle";
	}
	
	@RequestMapping(value="/updateArticle", method=RequestMethod.POST)
	public String updateArticle(@Valid Article article, BindingResult bindingResult) throws IllegalStateException, IOException {
		if(bindingResult.hasErrors()) {
			return "/admin/editformarticle";
		}

		articleService.updateArticle(article);
		
		return "redirect:admin";
	}
	
	@RequestMapping(value="/supprimer")
	public String supprimer(Integer id) {
		articleService.deleteArticleById(id);
		return "redirect:/admin";
	}
	
	
	
	
}
