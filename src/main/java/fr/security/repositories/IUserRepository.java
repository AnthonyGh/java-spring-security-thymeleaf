package fr.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.security.entities.User;


@Service
public interface IUserRepository extends JpaRepository<User, Integer>{

	public  User findUserById(Integer id);
	
}
