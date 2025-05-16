package project.an.bookmanagement.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer idAuthor;
	
	@Column(name = "author_name", nullable = false)
	private String authorName;

	@Column(name = "bio", nullable = true)
	private String bio;

	public Author(Integer idAuthor, String authorName, String bio) {
		this.idAuthor = idAuthor;
		this.authorName = authorName;
		this.bio = bio;
	}

	public Author() {}

	public Integer getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Integer idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
}
