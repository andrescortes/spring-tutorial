package co.edu.payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.payroll.domain.User;
import co.edu.payroll.service.UserService;

//restcontroller me expone las url como publicas 
@RestController
@RequestMapping("/users") // nivel jerarquia first
public class UserController {
	private UserService service;

	@Autowired
	public UserController(UserService service) {

		this.service = service;
	}

	// read only
	@GetMapping("/ages")
	public int avgAges() {
		System.out.println("ingrese datos:");
		return service.aveAges();
	}

	// crear ; put.. modificar .. path : modificacion parcial
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {

		return ResponseEntity.ok(service.createUser(user));
	}

	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {

		return ResponseEntity.ok(service.updateUser(user));
	}

	// solicitud de variable en el servidor /{...}@PathVariable
	@GetMapping("/{email}")
	public ResponseEntity<User> findUserByEmail(@PathVariable String email) {

		return ResponseEntity.ok(service.findUserByEmail(email));
	}

	// solicitud de variable en el servidor /?age=10 @RequestParam
	@GetMapping
	public ResponseEntity<User> findUserByAge(
			@RequestParam(value = "age", required = true, defaultValue = "18") int age) {

		return ResponseEntity.ok(service.findUserByAge(age));
	}
}
