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


public class HDDAO {
	private String jdbcURL="jdbc:sqlserver://localhost:1433;instance=MSSQLSERVER;databaseName=QuanLiBanLaptop1";
	private String jdbcUsername="PhatLee";
	private String jdbcPassword="123";
	ConnectionDB conn= new ConnectionDB(jdbcURL,jdbcUsername,jdbcPassword);
	
	public HDDAO() {
		
	}
	
	public  List<HoaDon> listAllHoaDon() throws SQLException{
		List<HoaDon> listHoaDon = new ArrayList<>();
		
		String sql="Select * from HoaDon";
		
		conn.connect();
		
		Statement statement= conn.jdbcConnection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next()) {
			String MaHD= result.getString("MaHD");
			String MaKH=result.getString("MaKH");
			Date NgayLapHD=result.getDate("NgayLapHD");
			Date NgayNhanHang=result.getDate("NgayNhanHang");
			float TongTien=result.getFloat("TongTien");
			
			HoaDon hd=new HoaDon(MaHD,MaKH,NgayLapHD,NgayNhanHang,TongTien);		
			listHoaDon.add(hd);		
		}
		
	
	result.close();
	statement.close();
	conn.disconnect();
	return listHoaDon;
		
	}
	
	public void insertHoaDon(HoaDon hoadon) throws SQLException {
		String sql="Insert into HoaDon (MaKH,NgayLapHD,NgayNhanHang,TongTien) values (?,?,?,?)";
		conn.connect();
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, hoadon.getMakh());
		statement.setDate(2, hoadon.getNgaylaphd());
		statement.setDate(3, hoadon.getNgaynhanhang());
		statement.setInt(4, 0);
		statement.executeUpdate();
		
		statement.close();
		conn.disconnect();
		
			
	}	
	
	public void deleteHoaDon (String MaHD) throws SQLException{
		String sql = "Delete from HoaDon where MaHD=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, MaHD);
		
		statement.execute();
		
		statement.close();
		conn.disconnect();				
	}
	
	public void updateHoaDon(HoaDon hd) throws SQLException{
		String sql = "update HoaDon set MaKH=?,NgayLapHD=?,NgayNhanHang=? where MaHD=?";
		conn.connect();
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, hd.getMakh());
		statement.setDate(2, hd.getNgaylaphd());
		statement.setDate(3, hd.getNgaynhanhang());
		statement.setString(4, hd.getMahd());
		
		statement.executeUpdate();
		
		statement.close();
		conn.disconnect();
	}
	
	public HoaDon getHoaDon() throws SQLException{
		HoaDon hd = null;
		String sql = "select Top(1) * from HoaDon ORDER BY MaHD DESC;";
		conn.connect();
		PreparedStatement statement= conn.jdbcConnection.prepareStatement(sql);
	
		ResultSet result = statement.executeQuery();
		
		while(result.next()) 
		{
			String MaHD = result.getString("MaHD");
			String MaKH=result.getString("MaKH");
			Date NgayLapHD=result.getDate("NgayLapHD");
			Date NgayNhanHang=result.getDate("NgayNhanHang");
			float TongTien=result.getFloat("TongTien");
			
			hd=new HoaDon(MaHD,MaKH,NgayLapHD,NgayNhanHang,TongTien);
		}
		return hd;
	}
	
	public HoaDon getHoaDonTheoTK(String MaKH) throws SQLException{
		HoaDon hd = null;
		String sql = "select * from HoaDon where MaKH=?";
		conn.connect();
		PreparedStatement statement= conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1,MaKH);
		
		ResultSet result = statement.executeQuery();
		
		while(result.next()) 
		{
			Date NgayLapHD=result.getDate("NgayLapHD");
			Date NgayNhanHang=result.getDate("NgayNhanHang");
			float TongTien=result.getFloat("TongTien");
			String MaHD = result.getString("MaHD");
			
			hd=new HoaDon(MaHD,MaKH,NgayLapHD,NgayNhanHang,TongTien);
		}
		return hd;
	}
}
