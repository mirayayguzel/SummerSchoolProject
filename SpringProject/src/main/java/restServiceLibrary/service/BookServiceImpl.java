package restServiceLibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restServiceLibrary.Dao.BookDao;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	public Book getBook(String title) {
		// TODO Auto-generated method stub
		return bookDao.getBook(title);
	}

	public void addBook(Book book) {
		bookDao.addBook(book);

	}

	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		bookDao.deleteBook(id);
	}

}
