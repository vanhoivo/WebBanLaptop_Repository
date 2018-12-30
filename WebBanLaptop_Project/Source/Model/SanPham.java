package Model;

public class SanPham {

	protected String masp;
	protected String tensp;
	protected float dongia;
	protected int tonkho;
	protected String hangsx;
	protected String cpu;
	protected String ram;
	protected String ocung;
	protected String manhinh;
	protected String hedh;
	protected String hinh;
	
	public SanPham() {
		
	}
	
	public SanPham(String MaSP) {
		this.masp=MaSP;
	}
	
	public SanPham(String MaSP,String TenSP,float DonGia,int TonKho,String HangSX,String CPU,String RAM,String OCung,String ManHinh,String HeDH,String Hinh) {
		this(TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh);
		this.masp=MaSP;
	}
	public SanPham(String TenSP,float DonGia,int TonKho,String HangSX,String CPU,String RAM,String OCung,String ManHinh,String HeDH,String Hinh) {
		this.tensp=TenSP;
		this.dongia=DonGia;
		this.tonkho=TonKho;
		this.hangsx=HangSX;
		this.cpu=CPU;
		this.ram=RAM;
		this.ocung=OCung;
		this.manhinh=ManHinh;
		this.hedh=HeDH;
		this.hinh=Hinh;
	}
	
	public String getMasp() {
		return masp;
	}
	public void setMasp(String MaSP) {
		this.masp=MaSP;
	}
	
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String TenSP) {
		this.tensp=TenSP;
	}
	public float getDongia() {
		return dongia;
	}
	public void setDongia(float DonGia) {
		this.dongia=DonGia;
	}
	public int getTonkho() {
		return tonkho;
	}
	public void setTonkho(int TonKho) {
		this.tonkho=TonKho;
	}
	public String getHangsx() {
		return hangsx;
	}
	public void setHangsx(String HangSX) {
		this.hangsx=HangSX;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String CPU) {
		this.cpu=CPU;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String RAM) {
		this.ram=RAM;
	}
	public String getOcung() {
		return ocung;
	}
	public void setOcung(String OCung) {
		this.ocung=OCung;
	}
	public String getManhinh() {
		return manhinh;
	}
	public void setManhinh(String ManHinh) {
		this.manhinh=ManHinh;
	}
	public String getHedh() {
		return hedh;
	}
	public void setHedh(String HeDH) {
		this.hedh=HeDH;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	
}
