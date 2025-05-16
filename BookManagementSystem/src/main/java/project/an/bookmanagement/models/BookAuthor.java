package project.an.bookmanagement.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_author")
public class BookAuthor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book_author")
    private Integer idBookAuthor;
	
	@ManyToOne
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;
	
	@ManyToOne
    @JoinColumn(name = "id_author", nullable = false)
    private Author author;
	
	@Column(name = "is_main_author")
	private boolean isMainAuthor;

	public BookAuthor(Integer idBookAuthor, Book book, Author author, boolean isMainAuthor) {
		this.idBookAuthor = idBookAuthor;
		this.book = book;
		this.author = author;
		this.isMainAuthor = isMainAuthor;
	}

	public BookAuthor() {
	}

	public Integer getIdBookAuthor() {
		return idBookAuthor;
	}

	public void setIdBookAuthor(Integer idBookAuthor) {
		this.idBookAuthor = idBookAuthor;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public boolean isMainAuthor() {
		return isMainAuthor;
	}

	public void setMainAuthor(boolean isMainAuthor) {
		this.isMainAuthor = isMainAuthor;
	}
	
	
}
