package restServiceLibrary.service;

import org.springframework.stereotype.Service;


public interface AuthorService {
	public Author getAuthor(int id);
	public void addAuthor(Author author);
	public void deleteAuthor(int id);
}
