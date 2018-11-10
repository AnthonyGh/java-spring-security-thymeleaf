package fr.security;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.security.entities.Article;
import fr.security.entities.User;
import fr.security.services.IArticleService;
import fr.security.services.IUserService;

@SpringBootApplication
public class SpringBootWebApplication implements CommandLineRunner{

	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private IUserService userService;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

//		Article article1 = new Article();
//		Article article2 = new Article();
//		
//		article1.setTitle("Chapitre 1");
//		article1.setDescription("Description complète du chapitre 1");
//		article1.setContent("<p>Contenu complet du chapitre 1 sur plusieurs paragraphe.</p><p>En html de préférence</p>");
//		article1.setDateCreate(LocalDate.now());
//		
//		article2.setTitle("Chapitre 2");
//		article2.setDescription("Description complète du chapitre 2");
//		article2.setContent("<p>Contenu complet du chapitre 2 sur plusieurs paragraphe.</p><p>En html de préférence</p>");
//		article2.setDateCreate(LocalDate.now());
//		
//		articleService.createArticle(article1);
//		articleService.createArticle(article2);
		
		
//		User user1 = new User();
//		User user2 = new User();
//		User user3 = new User();
//		
//		user1.setName("anthony");
//		user1.setPassword("anthony");
//		user1.setRole("ADMIN");
//		
//		user2.setName("thibaut");
//		user2.setPassword("thibaut");
//		user2.setRole("NORMAL");
//		
//		user3.setName("jean");
//		user3.setPassword("jean");
//		user3.setRole("PREMIUM");
//		
//		userService.createUser(user1);
//		userService.createUser(user2);
//		userService.createUser(user3);
		
	}

}
