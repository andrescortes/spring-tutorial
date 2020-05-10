package co.edu.payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.payroll.domain.User;
import co.edu.payroll.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public int aveAges() {

		return 0;

	}

	public User createUser(User user) {
		System.out.println("user creado " + user.getName());
		return repository.save(user);
	}

	public User updateUser(User user) {
		System.out.println("user actualizado " + user.getName());
		return user;
	}

	public User findUserByEmail(String email) {
		User user = new User();
		user.setAge(10);
		user.setEmail(email);
		user.setName("andres");
		System.out.println("user actualizado " + user.getEmail());
		return user;
	}

	public User findUserByAge(int age) {
		User user = new User();
		user.setAge(age);
		user.setEmail("andres.@");
		user.setName("andres");
		return user;
	}
}
