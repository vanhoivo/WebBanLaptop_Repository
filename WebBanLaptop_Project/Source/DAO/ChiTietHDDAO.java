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
import java.sql.Date;

import Model.ConnectionDB;
import Model.HoaDon;
import Model.ChiTietHD;

public class ChiTietHDDAO {
	private String jdbcURL="jdbc:sqlserver://localhost:1433;instance=MSSQLSERVER;databaseName=QuanLiBanLaptop1";
	private String jdbcUsername="PhatLee";
	private String jdbcPassword="123";
	ConnectionDB conn= new ConnectionDB(jdbcURL,jdbcUsername,jdbcPassword);
	
	public ChiTietHDDAO() {
		
	}
	
	public List<ChiTietHD> listAllChiTietHD() throws SQLException{
		List<ChiTietHD> listChiTietHD = new ArrayList<>();
		String sql = "select * from ChiTietHoaDon";
		conn.connect();
		
		Statement statement = conn.jdbcConnection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next())
		{
			String MaHD = result.getString("MaHD");
			String MaSP = result.getString("MaSP");
			int SoLuong = result.getInt("SoLuong");
			int ThanhTien = result.getInt("ThanhTien");
			
			ChiTietHD cthd = new ChiTietHD(MaHD,MaSP,SoLuong,ThanhTien);
			listChiTietHD.add(cthd);
		}
		
		result.close();
		statement.close();
		conn.disconnect();
		return listChiTietHD;
	}
	
	public void insertChiTietHoaDon(ChiTietHD cthd) throws SQLException {
		String sql="Insert into ChiTietHoaDon (MaHD,MaSP,SoLuong,ThanhTien) values (?,?,?,?)";
		conn.connect();
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, cthd.getMahd());
		statement.setString(2, cthd.getMasp());
		statement.setInt(3, cthd.getSoluong());
		statement.setInt(4, cthd.getThanhtien());

		statement.execute();
		
		statement.close();
		conn.disconnect();
		
			
	}	
	
	public void deleteChiTietHoaDon (String MaHD,String MaSP ) throws SQLException{
		String sql = "Delete from ChiTietHoaDon where MaHD=? and MaSP=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, MaHD);
		statement.setString(2, MaSP);
		
		statement.execute();
		
		statement.close();
		conn.disconnect();				
	}
	
	public void updateChiTietHoaDon(ChiTietHD cthd) throws SQLException{
		String sql = "update ChiTietHoaDon set SoLuong=? where MaHD=?,MaSP=?";
		conn.connect();
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		

		statement.setInt(1, cthd.getSoluong());
		statement.setString(2, cthd.getMahd());
		statement.setString(3, cthd.getMasp());
		
		statement.executeUpdate();
		
		statement.close();
		conn.disconnect();
	}
	
	public ChiTietHD getChiTietHoaDon(String MaHD) throws SQLException{
		ChiTietHD cthd = null;
		String sql = "select * from ChiTietHoaDon where MaHD=?";
		conn.connect();
		PreparedStatement statement= conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, MaHD);
		
		ResultSet result = statement.executeQuery();
		
		while(result.next()) 
		{
			String MaSP = result.getString("MaSP");
			int SoLuong = result.getInt("SoLuong");
			int ThanhTien = result.getInt("ThanhTien");
			
			cthd = new ChiTietHD(MaHD,MaSP,SoLuong,ThanhTien);
		}
		return cthd;
	}
	
	public List<ChiTietHD> listChiTietHDTheoHD(String MaHD) throws SQLException{
		List<ChiTietHD> listChiTietHD = new ArrayList<>();
		String sql = "select * from ChiTietHoaDon where MaHD=?";
		conn.connect();
		
		PreparedStatement statement= conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, MaHD);
		
		ResultSet result = statement.executeQuery();
		
		while(result.next())
		{
			String MaSP = result.getString("MaSP");
			int SoLuong = result.getInt("SoLuong");
			int ThanhTien = result.getInt("ThanhTien");
			
			ChiTietHD cthd = new ChiTietHD(MaHD,MaSP,SoLuong,ThanhTien);
			listChiTietHD.add(cthd);
		}
		
		result.close();
		statement.close();
		conn.disconnect();
		return listChiTietHD;
	}

}
