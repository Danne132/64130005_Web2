package bt.an.HelloJPA.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="loaisp")
public class Customer {
	@Id
	@Column(name = "maloai")
	public String maSP;
	
	@Column(name = "tenloai")
	public String tenSP;
}
