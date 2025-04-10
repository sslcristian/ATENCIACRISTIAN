package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Book;

public class BookDAO implements CRUD_Operation<Book,Long> {
	
	private Connection connection;
	
	public BookDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void save(Book book) {
		String query = "INSERT INTO Book (Title, Author, ISBN, Year, Available) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        	

            pstmt.setString(1, book.getTitulo());
            pstmt.setString(2, book.getAutor());
            pstmt.setLong(3, book.getISBN());
            pstmt.setInt(4, book.getAño());
            pstmt.setBoolean(5, book.isDisponible());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public ArrayList<Book> fetch() {
	        ArrayList<Book> books = new ArrayList<>();
	        String query = "SELECT Title, Author, ISBN, Year, Available FROM Book";
	        
	        try (Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {
	            
	            while (rs.next()) {
	                String title = rs.getString("Title");
	                String author = rs.getString("Author");
	                long isbn = rs.getLong("ISBN");
	                int year = rs.getInt("Year");
	                boolean available = rs.getBoolean("Available");
	                
	                Book book = new Book(title, author, isbn, year, available);
	                books.add(book);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return books;
	    }
		
	


	@Override
	public void update(Book book) {
			String sql = "UPDATE Book SET title=?, author=? WHERE ISBN=?";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, book.getTitulo());
			stmt.setString(2, book.getAutor());
			stmt.setLong(3, book.getISBN());
			stmt.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();}
			
	}

	@Override
	public void delete(Long ISBN) {
	String sql = "DELETE FROM Book WHERE ISBN=?";
	try (PreparedStatement stmt = connection.prepareStatement(sql)) {
		stmt.setLong(1, ISBN);
		stmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	@Override
	public boolean authenticate(Long ISBN) {
	String sql = "SELECT ISBN FROM Book WHERE ISBN=?";
	try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	stmt.setLong(1, ISBN);
	ResultSet rs = stmt.executeQuery();
	if (rs.next()) {
	return rs.getLong("ISBN")==ISBN;
	}
	} catch (SQLException e) {
	e.printStackTrace();}
	return false;}



}
