package restServiceLibrary.Dao;

import restServiceLibrary.service.User;

public interface UserDao {
	public User getUser(int id);
	public void saveUser(User user);
	public User updateUser(int id,User user);
	public void deleteUSer(int id);
}
