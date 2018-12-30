package DAO;

import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.ConnectionDB;
import Model.NhanVien;


public class NVDAO {
	private String jdbcURL="jdbc:sqlserver://localhost:1433;instance=MSSQLSERVER;databaseName=QuanLiBanLaptop1";
	private String jdbcUsername="PhatLee";
	private String jdbcPassword="123";
	public ConnectionDB conn = new ConnectionDB(jdbcURL,jdbcUsername,jdbcPassword);
	
	public NVDAO() {
		
    }
	
	public List<NhanVien> listAllNhanVien() throws SQLException{
		List<NhanVien> listNhanVien = new ArrayList<>();
		
		String sql="Select * from NhanVien";
		
		conn.connect();
		
		Statement statement = conn.jdbcConnection.createStatement();
		ResultSet resultset = statement.executeQuery(sql);
		
		while (resultset.next()) {
			String MaNV=resultset.getString("MaNV");
			String TenNV=resultset.getString("TenNV");
			boolean GioiTinh=resultset.getBoolean("GioiTinh");
			Date NgayNV=resultset.getDate("NgayNV");
			String DiaChi=resultset.getString("DiaChi");
			String SoDienThoai=resultset.getString("SoDT");
			Image Hinh=null;
			float LuongCB=resultset.getFloat("LuongCB");
			float PhuCap=resultset.getFloat("PhuCap");
			float LuongCT=resultset.getFloat("LuongCT");
			
			NhanVien nv = new NhanVien(MaNV,TenNV,GioiTinh,NgayNV,DiaChi,SoDienThoai,Hinh,LuongCB,PhuCap,LuongCT);
			listNhanVien.add(nv);
		}
		
		resultset.close();
		statement.close();
		conn.disconnect();
		
		return listNhanVien;
	}

	public void insertNhanVien(NhanVien nhanvien) throws SQLException {
		String sql="Insert into NhanVien (MaNV,TenNV,GioiTinh,NgayNV,DiaChi,SoDT,Hinh,LuongCB,PhuCap,LuongCT) values (?,?,?,?,?,?,?,?,?,?)";
		conn.connect();
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		
		statement.setNString(1,nhanvien.getManv());
		statement.setNString(2, nhanvien.getTennv());
		statement.setBoolean(3, nhanvien.getGioitinh());
		statement.setDate(4, nhanvien.getNgaynv());
		statement.setNString(5, nhanvien.getDiachi());
		statement.setString(6, nhanvien.getSodienthoai());
		statement.setNull(7, 0);
		statement.setFloat(8, nhanvien.getLuongcb());
		statement.setFloat(9, nhanvien.getPhucap());
		statement.setFloat(10, nhanvien.getLuongct());
		
		statement.executeUpdate();
		
		statement.close();
		conn.disconnect();
		
			
	}	
	
	public void deleteNhanVien (String MaNV) throws SQLException{
		String sql = "Delete from NhanVien where MaNV=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, MaNV);
		
		statement.execute();
		
		statement.close();
		conn.disconnect();				
	}
	
	public void updateNhanVien(NhanVien nhanvien) throws SQLException{
		String sql = "Update Nhanvien set TenNV=?,GioiTinh=?,NgayNV=?,DiaChi=?,SoDT=?,Hinh=?,LuongCB=?,PhuCap=?,LuongCT=? where MaNV=?";
		conn.connect();
		PreparedStatement statement= conn.jdbcConnection.prepareStatement(sql);
		
		statement.setNString(1, nhanvien.getTennv());
		statement.setBoolean(2, nhanvien.getGioitinh());
		statement.setDate(3, nhanvien.getNgaynv());
		statement.setNString(4, nhanvien.getDiachi());
		statement.setNString(5, nhanvien.getSodienthoai());
		statement.setNull(6, 0);
		statement.setFloat(7, nhanvien.getLuongcb());		
		statement.setFloat(8, nhanvien.getPhucap());
		statement.setFloat(9,nhanvien.getLuongct());
		statement.setNString(10, nhanvien.getManv());
		
		statement.executeUpdate();
		statement.close();
		conn.disconnect();
	}
	
	public NhanVien getNhanVien(String MaNV) throws SQLException{
		NhanVien nhanvien =null;
		String sql ="Select * from NhanVien where MaNV=?";
		
		conn.connect();
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, MaNV);
		
		ResultSet resultset = statement.executeQuery();
		
		if (resultset.next())
		{
			String TenNV = resultset.getString("TenNV");
			Boolean GioiTinh = resultset.getBoolean("GioiTinh");
			Date NgayNV = resultset.getDate("NgayNV");
			String DiaChi = resultset.getString("DiaChi");
			String SoDT = resultset.getString("SoDT");
			Image Hinh = null;
			Float LuongCB = resultset.getFloat("LuongCB");
			Float PhuCap = resultset.getFloat("PhuCap");
			Float LuongCT = resultset.getFloat("LuongCT");
			
			nhanvien = new NhanVien (MaNV,TenNV,GioiTinh,NgayNV,DiaChi,SoDT,Hinh,LuongCB,PhuCap,LuongCT);
		}
		
		resultset.close();
		statement.close();
		conn.disconnect();
		
		return nhanvien;
	}
	
}
