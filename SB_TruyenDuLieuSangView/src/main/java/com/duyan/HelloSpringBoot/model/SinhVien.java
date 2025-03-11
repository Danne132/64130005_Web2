package com.duyan.HelloSpringBoot.model;

public class SinhVien {
	String mssv, hoTen, gioiTinh;
	int namSinh;
	
	public SinhVien(String mssv, String hoTen, String gioiTinh, int namSinh){
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.namSinh = namSinh;
	}
}
