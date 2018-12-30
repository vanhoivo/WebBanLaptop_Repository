package Model;

import java.util.ArrayList;
import java.util.List;

public class GioHang {
	private int id;
	private KhachHang kh;
	List <Item> listSanPham = new ArrayList<>();
	private int tongtien;
	private int status;	
	
	public GioHang() {
		status=0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public KhachHang getKh() {
		return kh;
	}
	public void setKh(KhachHang kh) {
		this.kh = kh;
	}
	public List<Item> getListSanPham() {
		return listSanPham;
	}
	public void setListSanPham(List<Item> listSanPham) {
		this.listSanPham = listSanPham;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien() {
		int TongTien=0;
		for(Item item:listSanPham)
		{
			TongTien+=item.getDongia()*item.getSoluong();
		}
		this.tongtien = TongTien;
	}
}
