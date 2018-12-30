package Model;

import java.sql.Date;

public class HoaDon {
	private String mahd;
	private String makh;
	private Date ngaylaphd;
	private Date ngaynhanhang;
	private float tongtien;
	
	public HoaDon() {
		
	}
	public HoaDon(String MaHD,String MaKH,Date NgayLapHD,Date NgayNhanHang,float TongTien) {
		this(MaKH,NgayLapHD,NgayNhanHang,TongTien);
		mahd=MaHD;
	}
	public HoaDon(String MaKH,Date NgayLapHD,Date NgayNhanHang,float TongTien) {
		makh=MaKH;
		ngaylaphd=NgayLapHD;
		ngaynhanhang=NgayNhanHang;
		tongtien=TongTien;
	}
	
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String MaHD) {
		mahd=MaHD;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String MaKH) {
		makh=MaKH;
	}
	public Date getNgaylaphd() {
		return ngaylaphd;
	}
	public void setNgaylaphd(Date NgayLapHD) {
		ngaylaphd=NgayLapHD;
	}
	public Date getNgaynhanhang() {
		return ngaynhanhang;
	}
	public void setNgaynhanhang(Date NgayNhanHang) {
		ngaynhanhang=NgayNhanHang;
	}
	public float getTongtien() {
		return tongtien;
	}
	public void setTongtien(float TongTien) {
		tongtien=TongTien;
	}
}
