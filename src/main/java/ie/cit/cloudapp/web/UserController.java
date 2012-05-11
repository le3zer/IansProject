package ie.cit.cloudapp.web;

import java.util.List;

import ie.cit.cloudapp.User;
import ie.cit.cloudapp.JdbcUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("users")
@Controller
public class UserController {
	
	@Autowired
	private JdbcUserRepository repo;
		
	@RequestMapping(method = RequestMethod.GET)
	public void listTodos(Model model){
		model.addAttribute("users", repo.getAll());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void createUser(Model model, @RequestParam String firstName, @RequestParam String surname, @RequestParam String email) {
		User user = new User();
		user.setFirstName(firstName);
		user.setSurname(surname);
		user.setEmail(email);
		repo.save(user);
		model.addAttribute("users",repo.getAll());
		
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void updateUser(Model model, @RequestParam int userId){
		User user = repo.getAll().get(userId - 1);
		user.setDone(!user.isDone());
		model.addAttribute("user", repo.getAll());
	}


}
