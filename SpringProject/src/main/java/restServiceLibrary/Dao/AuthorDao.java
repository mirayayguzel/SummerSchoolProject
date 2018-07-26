package restServiceLibrary.Dao;

import restServiceLibrary.service.Author;

public interface AuthorDao {
	public Author getAuthor(int id);
	public void addAuthor(Author author);
	public void deleteAuthor(int id);
}
