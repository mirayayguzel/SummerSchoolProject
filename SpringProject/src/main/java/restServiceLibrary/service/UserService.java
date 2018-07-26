package restServiceLibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
 
public interface UserService {
	public User getUser(int id);
	public void saveUser(User user);
	public User updateUser(int id,User user);
	public void deleteUSer(int id);

}
