package Model;

public class TaiKhoan {
	public String tendangnhap;
	public String matkhau;
	public boolean admin;
	
	public TaiKhoan() {
		
	}
	
	public TaiKhoan(String tendangnhap,String matkhau, boolean admin) {
		this.tendangnhap=tendangnhap;
		this.matkhau=matkhau;
		this.admin=admin;
	}
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String TenDangNhap) {
		tendangnhap=TenDangNhap;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String MatKhau) {
		matkhau=MatKhau;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
