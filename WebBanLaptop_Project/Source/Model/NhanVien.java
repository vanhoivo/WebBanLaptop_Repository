package Model;

import java.awt.Image;
import java.sql.Date;

public class NhanVien {
	protected String manv;
	protected String tennv;
	protected boolean gioitinh;
	protected Date ngaynv;
	protected String diachi;
	protected String sodienthoai;
	protected Image hinhanh;
	protected float luongcb;
	protected float phucap;
	protected float luongct;
	
	public NhanVien() {
		
	}
	public NhanVien(String MaNV) {
		this.manv=MaNV;
	}
	
	public NhanVien(String MaNV, String TenNV,boolean GioiTinh,Date NgayNV,String DiaChi, String SoDienThoai,Image HinhAnh,float LuongCB,float PhuCap,float LuongCT) {
		this(TenNV,GioiTinh,NgayNV,DiaChi,SoDienThoai,HinhAnh,LuongCB,PhuCap,LuongCT);
		manv=MaNV;
		
	}
	public NhanVien(String TenNV,boolean GioiTinh, Date NgayNV,String DiaChi,String SoDienThoai,Image HinhAnh,float LuongCB,float PhuCap,float LuongCT) {
		tennv=TenNV;
		gioitinh=GioiTinh;
		ngaynv=NgayNV;
		diachi=DiaChi;
		sodienthoai=SoDienThoai;
		hinhanh=HinhAnh;
		luongcb=LuongCB;
		phucap=PhuCap;
		luongct=LuongCT;
	}
	
	public String getManv() {
		return manv;
	}
	public void setManv(String MaNV) {
		manv=MaNV;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String TenNV) {
		tennv=TenNV;
	}
	public boolean getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean GioiTinh) {
		gioitinh=GioiTinh;
	}
	public Date getNgaynv() {
		return ngaynv;
	}
	public void setNgaynv(Date NgayNV) {
		ngaynv=NgayNV;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String DiaChi) {
		diachi=DiaChi;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String SoDienThoai) {
		sodienthoai=SoDienThoai;
	}
	public Image getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(Image HinhAnh) {
		hinhanh=HinhAnh;
	}
	public float getLuongcb() {
		return luongcb;
	}
	public void setLuongcb(float LuongCB) {
		luongcb=LuongCB;
	}
	public float getPhucap() {
		return phucap;
	}
	public void setPhucap(float PhuCap) {
		phucap=PhuCap;
	}
	public float getLuongct() {
		return luongct;
	}
	public void setLuongct(float LuongCT) {
		luongct=LuongCT;
	}
	
}
