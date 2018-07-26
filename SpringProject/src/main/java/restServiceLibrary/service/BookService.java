package restServiceLibrary.service;

public interface BookService {
	public Book getBook(String title);
	public void addBook(Book book);
	public void deleteBook(int id);
}
