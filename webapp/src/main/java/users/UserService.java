package users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private User user = new User(1,"name_user","lastname_user","admin");
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService() {
	}
	
	public User getUser()
	{
		return user;
	}
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public void addUser(User user){
		
		userRepository.save(user);
	}
	
	public boolean verifylogin(User user)
	{
		//get user infos and check if exist in database
		//User found = UserRepository.findByUsernameAndPassword(user.getUsername);
		//if found != null user in found on the database
		return true;
		//else return false
	}

}


