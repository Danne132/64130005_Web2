package project.an.bookmanagement.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Catergory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer idCategory;
	
	@Column(name = "category_name")
	private String categoryName;

	public Catergory(Integer idCategory, String categoryName) {
		this.idCategory = idCategory;
		this.categoryName = categoryName;
	}
	

	public Catergory() {
		super();
	}



	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
