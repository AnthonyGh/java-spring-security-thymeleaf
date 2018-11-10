package fr.security.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.security.entities.User;
import fr.security.repositories.IUserRepository;

@Service
public class ServiceUser implements IUserService{

	@Autowired
	private IUserRepository dao;
	
	@Override
	public void createUser(User user) {
			dao.save(user);
	}

	@Override
	public void updateUser(User user) {
		if(user.getId() != null) {
			dao.save(user);
		}
	}

	@Override
	public void deleteUserById(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<>(dao.findAll());
		return users;
	}

	@Override
	public User findUserById(Integer id) {
		return dao.findUserById(id);
	}



}
