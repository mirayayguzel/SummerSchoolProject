package restServiceLibrary.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import restServiceLibrary.service.User;
import restServiceLibrary.service.UserService;

@Controller
@ResponseBody
@RequestMapping("/users")
public class UserRestController {
	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getUsers() {
		return Arrays.asList(new User());
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}

	@PostMapping
	public void saveUser(@RequestBody User user) {
		System.out.println("ok");
		userService.saveUser(user);
		System.out.println("ok");	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User user) {

		return user;
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUSer(id);
	}

}
