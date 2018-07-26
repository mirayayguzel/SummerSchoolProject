package restServiceLibrary.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import restServiceLibrary.service.Book;
import restServiceLibrary.service.User;
@Repository("bookDao")
public class BookDaoImpl  implements BookDao{
	@Autowired
	private DataSource dataSource;
	public Book getBook(String title) {
		String query="select * from book where title=?";
		Connection conn=null;
		System.out.println("getbook");
		Book book=new Book();
		book.setAuthorID(0);
		book.setAvailable(false);
		book.setBookID(0);
		book.setPrice(0);
		book.setPublishername(null);
		book.setTitle(null);
		try{
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, title);
			
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				book.setBookID(rs.getInt("BookID"));
				book.setAvailable(rs.getBoolean("Available"));
				book.setPublishername(rs.getString("PublisherName"));
				book.setAuthorID(rs.getInt("AuthorID"));
				book.setTitle(rs.getString("Title"));
				book.setPrice(rs.getInt("Price"));
				
				
			}
			rs.close();
			ps.close();
			return book;
		}catch(SQLException e){
			throw new RuntimeException();
		}
		finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
					
					
				}
			}
			
		}
	}

	public void addBook(Book book) {
		String query="insert into book (bookid,available,publishername,authorid,title,price) values(?,?,?,?,?,?)";
		Connection conn=null;
		
		
		try{
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, book.getBookID());
			ps.setBoolean(2, book.isAvailable());
			ps.setString(3, book.getPublishername());
			ps.setInt(4, book.getAuthorID());
			ps.setString(5, book.getTitle());
			ps.setInt(6, book.getPrice());
			ps.executeUpdate();

			ps.close();
		}catch(SQLException e){
			throw new RuntimeException(e);	
			
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
				}
			}
		}
		
	}

	public void deleteBook(int id) {
		System.out.println("delete");
		String query="delete from book where bookID=?";
		Connection conn=null;
		try{
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			throw new RuntimeException(e);	
			
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
				}
			}
		}
		
	}
		
	

	
}
