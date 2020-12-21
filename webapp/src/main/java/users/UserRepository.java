package users;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>{
	public User findByUsername(String username);
	public User findByUsernameAndPassword(String Username, String Password);
}
