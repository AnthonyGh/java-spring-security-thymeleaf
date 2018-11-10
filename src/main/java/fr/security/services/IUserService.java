package fr.security.services;

import java.util.List;
import org.springframework.stereotype.Service;

import fr.security.entities.User;

@Service
public interface IUserService{

	public void createUser(User article);
	
	public void updateUser(User article);
	
	public void deleteUserById(Integer id);
	
	public List<User> findAllUsers();

	public User findUserById(Integer id);

}
