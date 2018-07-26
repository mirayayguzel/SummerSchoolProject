package restServiceLibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restServiceLibrary.Dao.AuthorDao;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorDao authorDao;

	public Author getAuthor(int id) {
		// TODO Auto-generated method stub
		return authorDao.getAuthor(id);
	}

	public void addAuthor(Author author) {
		// TODO Auto-generated method stub
		authorDao.addAuthor(author);
		
	}

	public void deleteAuthor(int id) {
		// TODO Auto-generated method stub
		authorDao.deleteAuthor(id);
		
	}
	
}
