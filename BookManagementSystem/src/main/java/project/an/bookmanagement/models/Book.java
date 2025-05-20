package project.an.bookmanagement.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer idBook;
	
	@ManyToOne
    @JoinColumn(name = "catergory_id", nullable = false)
    private Catergory catergory;
	
	@Column(name = "book_image")
	private String bookImage;
	
	@Column(name = "book_name")
	private String bookName;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "last_modify")
	private Date lastModify;
	
	@Column(name = "description")
	private String description;

	public Book(Integer idBook, Catergory catergory, String bookImage, String bookName, Integer price, Integer quantity,
			Date lastModify, String description) {
		this.idBook = idBook;
		this.catergory = catergory;
		this.bookImage = bookImage;
		this.bookName = bookName;
		this.price = price;
		this.quantity = quantity;
		this.lastModify = lastModify;
		this.description = description;
	}

	public Book() {
	}

	public Integer getIdBook() {
		return idBook;
	}

	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
	}

	public Catergory getCatergory() {
		return catergory;
	}

	public void setCatergory(Catergory catergory) {
		this.catergory = catergory;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getLastModify() {
		return lastModify;
	}

	public void setLastModify(Date lastModify) {
		this.lastModify = lastModify;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
	
}
