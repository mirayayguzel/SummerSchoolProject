package restServiceLibrary.Dao;

import restServiceLibrary.service.Book;
import restServiceLibrary.service.User;

public interface BookDao {
	public Book getBook(String title);
	public void addBook(Book book);
	public void deleteBook(int id);
}
