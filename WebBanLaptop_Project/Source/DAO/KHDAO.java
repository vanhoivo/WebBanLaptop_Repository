package DAO;

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
import Model.KhachHang;
import Model.SanPham;


public class KHDAO {
	private String jdbcURL="jdbc:sqlserver://localhost:1433;instance=MSSQLSERVER;databaseName=QuanLiBanLaptop1";
	private String jdbcUsername="PhatLee";
	private String jdbcPassword="123";
	public ConnectionDB conn = new ConnectionDB(jdbcURL,jdbcUsername,jdbcPassword);
	
	public KHDAO() {
		
    }
	
	public List<KhachHang> listAllKhachHang() throws SQLException{
		List<KhachHang> listKhachHang = new ArrayList<>();
		
		String sql="Select * from KhachHang";
		
		conn.connect();
		
		Statement statement = conn.jdbcConnection.createStatement();
		ResultSet resultset = statement.executeQuery(sql);
		
		while (resultset.next()) {
			String MaKH=resultset.getString("MaKH");
			String TenKH=resultset.getString("TenKH");
			String DiaChi=resultset.getString("DiaChi");
			String SoDT=resultset.getString("SoDT");
			String Email=resultset.getString("Email");
			String TenDangNhap = resultset.getString("TenDangNhap");

			
			KhachHang kh = new KhachHang(MaKH,TenKH,DiaChi,SoDT,Email,TenDangNhap);
			listKhachHang.add(kh);
		}
		
		resultset.close();
		statement.close();
		conn.disconnect();
		
		return listKhachHang;
	}
	
	public void insertKhachHang(KhachHang khachhang) throws SQLException {
		String sql="Insert into KhachHang (TenKH,DiaChi,SoDT,Email,TenDangNhap) values (N?,?,?,?,?)";
		conn.connect();
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		

		statement.setString(1, khachhang.getTenkh());
		statement.setString(2, khachhang.getDiachi());
		statement.setString(3, khachhang.getSodienthoai());
		statement.setString(4, khachhang.getEmail());
		statement.setString(5, khachhang.getTendangnhap());
		 
		statement.executeUpdate();
		
		statement.close();	
		conn.disconnect();
				
	}	
	
	public void deleteKhachHang (String MaKH) throws SQLException{
		String sql = "Delete from KhachHang where MaKH=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, MaKH);
		
		statement.execute();
		
		statement.close();
		conn.disconnect();				
	}
	
	public void updateKhachHang(KhachHang kh) throws SQLException{
		String sql = "update KhachHang set TenKH=?,DiaChi=?,SoDT=?,Email=? where MaKH=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setNString(1, kh.getTenkh());
		statement.setNString(2, kh.getDiachi());
		statement.setString(3, kh.getSodienthoai());
		statement.setString(4, kh.getEmail());
		statement.setString(5, kh.getMakh());
		
		
		statement.executeUpdate();
		statement.close();
		conn.disconnect();
		
	}
	
	public KhachHang getKhachHang (String MaKH) throws SQLException{
		KhachHang kh = null;
		String sql = "Select * from KhachHang where MaKH=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, MaKH);
		
		ResultSet resultset = statement.executeQuery();
		
		if (resultset.next())
		{
			String TenKH = resultset.getString("TenKH");
			String DiaChi = resultset.getString("DiaChi");
			String SoDT = resultset.getString("SoDT");
			String Email = resultset.getString("Email");
			String TenDangNhap = resultset.getString("TenDangNhap");
			
			kh = new KhachHang(MaKH,TenKH,DiaChi,SoDT,Email,TenDangNhap);		
		}
		
		resultset.close();
		statement.close();
		return kh;
	}
	
	public KhachHang getKhachHangTheoTK (String TenDangNhap) throws SQLException{
		KhachHang kh = null;
		String sql = "Select * from KhachHang where TenDangNhap=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, TenDangNhap);
		
		ResultSet resultset = statement.executeQuery();
		
		if (resultset.next())
		{
			String TenKH = resultset.getString("TenKH");
			String DiaChi = resultset.getString("DiaChi");
			String SoDT = resultset.getString("SoDT");
			String Email = resultset.getString("Email");
			String MaKH = resultset.getString("MaKH");
			
			kh = new KhachHang(MaKH,TenKH,DiaChi,SoDT,Email,TenDangNhap);		
		}
		
		resultset.close();
		statement.close();
		return kh;
	}
}

