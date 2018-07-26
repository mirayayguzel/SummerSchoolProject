package restServiceLibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restServiceLibrary.Dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.saveUser(user);

	}

	public User updateUser(int id, User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(id, user);
	}

	public void deleteUSer(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUSer(id);
	}

}
