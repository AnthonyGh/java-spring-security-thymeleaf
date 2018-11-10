package fr.security.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.security.entities.Article;
import fr.security.repositories.IArticleRepository;

@Service
public class ServiceArticle implements IArticleService{

	@Autowired
	private IArticleRepository dao;
	
	@Override
	public void createArticle(Article article) {
			dao.save(article);
	}

	@Override
	public void updateArticle(Article article) {
		if(article.getId() != null) {
			dao.save(article);
		}
	}

	@Override
	public void deleteArticleById(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Article> findAllArticles() {
		List<Article> articles = new ArrayList<>(dao.findAll());
		return articles;
	}

	@Override
	public Article findArticleById(Integer id) {
		return dao.findArticleById(id);
	}

}
