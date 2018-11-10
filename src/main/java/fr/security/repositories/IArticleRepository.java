package fr.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.security.entities.Article;

@Service
public interface IArticleRepository extends JpaRepository<Article, Integer>{

	public  Article findArticleById(Integer id);
	
}
