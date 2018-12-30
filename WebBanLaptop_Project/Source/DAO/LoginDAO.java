package DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.ConnectionDB;
import Model.TaiKhoan;

public class LoginDAO {
	String jdbcURL="jdbc:sqlserver://localhost:1433;instance=MSSQLSERVER;databaseName=QuanLiBanLaptop1";
	String jdbcUsername="PhatLee";
	String jdbcPassword="123";
	public ConnectionDB conn = new ConnectionDB(jdbcURL,jdbcUsername,jdbcPassword);
	
	public LoginDAO() {
		
    }
	

	public List<TaiKhoan> listAllTaiKhoan() throws SQLException{
		List<TaiKhoan> listTaiKhoan = new ArrayList<>();
		
		String sql="Select * from TaiKhoan";
		
		conn.connect();
		
		Statement statement = conn.jdbcConnection.createStatement();
		ResultSet resultset = statement.executeQuery(sql);
		
		while (resultset.next()) {
			String TenDangNhap = resultset.getString("TenDangNhap");
			String MatKhau = resultset.getString("MatKhau");
			boolean Admin = resultset.getBoolean("Admin");
			
			TaiKhoan taikhoan = new TaiKhoan(TenDangNhap,MatKhau,Admin);
			listTaiKhoan.add(taikhoan);
		}
		
		resultset.close();
		statement.close();
		conn.disconnect();
		
		return listTaiKhoan;
	}
	
	public void insertTaiKhoanKhach(TaiKhoan taikhoan) throws SQLException {
		String sql="Insert into TaiKhoan (TenDangNhap,MatKhau,Admin) values (?,?,?)";
		conn.connect();
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, taikhoan.getTendangnhap());
		statement.setString(2, taikhoan.getMatkhau());
		statement.setBoolean(3, taikhoan.isAdmin());
		
		statement.executeUpdate();
		
		statement.close();
		conn.disconnect();
		
			
	}	
	
	public void deleteTaiKhoan (String TenDangNhap) throws SQLException{
		String sql = "Delete from TaiKhoan where TenDangNhap=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, TenDangNhap);
		
		statement.execute();
		
		statement.close();
		conn.disconnect();				
	}
	
	public void DoiMatKhau(String TenDangNhap,String MatKhau) throws SQLException{
		String sql = "Update TaiKhoan set MatKhau=? where TenDangNhap=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, MatKhau);
		statement.setString(2, TenDangNhap);
		
		statement.executeUpdate();
		statement.close();
		conn.disconnect();
		
	}
	
	public boolean DangNhapTaiKhoanKhach (String TenDangNhap,String MatKhau) throws SQLException{
		TaiKhoan taikhoan=null;
		String sql = "Select * from TaiKhoan where TenDangNhap=? and MatKhau=? and Admin=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, TenDangNhap);
		statement.setString(2, MatKhau);
		statement.setBoolean(3, false);
		
		ResultSet resultset = statement.executeQuery();
		
		if (resultset.next())
		{		
			resultset.close();
			statement.close();
			return true;	
		}
		
		resultset.close();
		statement.close();
		return false;
	}
	
	public boolean DangNhapTaiKhoanAdmin (String TenDangNhap,String MatKhau) throws SQLException{
		
		String sql="Select * from TaiKhoan where TenDangNhap=? and MatKhau=? and Admin=?";
		
		conn.connect();
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, TenDangNhap);
		statement.setString(2, MatKhau);
		statement.setBoolean(3, true);
		
		ResultSet resultset = statement.executeQuery();
		
		if (resultset.next())
		{
			resultset.close();
			statement.close();
			return true;
		}
			
		resultset.close();
		statement.close();
		return false;
		
	}
}

