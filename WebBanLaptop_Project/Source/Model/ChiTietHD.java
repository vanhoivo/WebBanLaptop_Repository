package Model;

import java.sql.SQLException;

import DAO.SPDAO;
import Model.SanPham;

public class ChiTietHD {
	public String mahd;
	public String masp;
	public int soluong;
	public int thanhtien;

	
	public ChiTietHD(String MaHD,String MaSP,int SoLuong,int ThanhTien) {
		this(MaSP,SoLuong,ThanhTien);
		this.mahd=MaHD;
	}
	public ChiTietHD(String MaSP,int SoLuong,int ThanhTien) {
		masp=MaSP;
		soluong=SoLuong;
		thanhtien=ThanhTien;
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}
	public String layTenSP(String MaSP)
	{
		SPDAO spDAO = new SPDAO();
		SanPham sp = null;
		try {
			sp = spDAO.getSanPham(MaSP);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sp.getTensp();
	}
	
}
