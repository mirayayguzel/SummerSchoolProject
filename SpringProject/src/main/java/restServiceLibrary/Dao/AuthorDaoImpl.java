package restServiceLibrary.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import restServiceLibrary.service.Author;

@Repository
public class AuthorDaoImpl implements AuthorDao {
	@Autowired
	private DataSource dataSource;

	public Author getAuthor(int id) {
		String query = "select * from author where authorID=?";
		Connection conn = null;
		System.out.println("getauthor");
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			Author author = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				author = new Author();

				author.setAuthorID(rs.getInt("AuthorID"));
				author.setFullName(rs.getString("fullName"));

			}
			rs.close();
			ps.close();
			return author;
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}

		}
	}

	public void addAuthor(Author author) {
		String query = "insert into user(userid,fullname) values(?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, author.getAuthorID());
			ps.setString(2, author.getFullName());

			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void deleteAuthor(int id) {
		System.out.println("author deleted");

	}

}
