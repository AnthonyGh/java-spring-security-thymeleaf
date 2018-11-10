package fr.security.services;

import java.util.List;
import org.springframework.stereotype.Service;

import fr.security.entities.Article;

@Service
public interface IArticleService{

	public void createArticle(Article article);
	
	public void updateArticle(Article article);
	
	public void deleteArticleById(Integer id);
	
	public List<Article> findAllArticles();

	public Article findArticleById(Integer id);

}
