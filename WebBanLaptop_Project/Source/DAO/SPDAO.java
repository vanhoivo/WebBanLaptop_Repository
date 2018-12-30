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
import Model.SanPham;

public class SPDAO {
	String jdbcURL="jdbc:sqlserver://localhost:1433;instance=MSSQLSERVER;databaseName=QuanLiBanLaptop1";
	String jdbcUsername="PhatLee";
	String jdbcPassword="123";
	public ConnectionDB conn = new ConnectionDB(jdbcURL,jdbcUsername,jdbcPassword);
	
	public SPDAO() {
		
    }
	

	public List<SanPham> listAllSanPham() throws SQLException{
		List<SanPham> listSanPham = new ArrayList<>();
		
		String sql="Select * from SanPham";
		
		conn.connect();
		
		Statement statement = conn.jdbcConnection.createStatement();
		ResultSet resultset = statement.executeQuery(sql);
		
		while (resultset.next()) {
			String MaSP=resultset.getString("MaSP");
			String TenSP=resultset.getString("TenSP");
			float DonGia=resultset.getFloat("DonGia");
			int TonKho=resultset.getInt("TonKho");
			String HangSX=resultset.getString("HangSX");
			String CPU=resultset.getString("CPU");
			String RAM=resultset.getString("RAM");
			String OCung=resultset.getString("OCung");
			String ManHinh=resultset.getString("ManHinh");
			String HeDH=resultset.getString("HeDH");
			String Hinh=resultset.getString("Hinh");
			
			SanPham sp= new SanPham(MaSP,TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh);
			listSanPham.add(sp);
		}
		
		resultset.close();
		statement.close();
		conn.disconnect();
		
		return listSanPham;
	}
	
	public List<SanPham> listSanPham() throws SQLException{
		List<SanPham> listSanPham = new ArrayList<>();
		
		String sql="select Top(6) * from SanPham order by TonKho asc";
		
		conn.connect();
		
		Statement statement = conn.jdbcConnection.createStatement();
		ResultSet resultset = statement.executeQuery(sql);
		
		while (resultset.next()) {
			String MaSP=resultset.getString("MaSP");
			String TenSP=resultset.getString("TenSP");
			float DonGia=resultset.getFloat("DonGia");
			int TonKho=resultset.getInt("TonKho");
			String HangSX=resultset.getString("HangSX");
			String CPU=resultset.getString("CPU");
			String RAM=resultset.getString("RAM");
			String OCung=resultset.getString("OCung");
			String ManHinh=resultset.getString("ManHinh");
			String HeDH=resultset.getString("HeDH");
			String Hinh=resultset.getString("Hinh");
			
			
			SanPham sp= new SanPham(MaSP,TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh);
			listSanPham.add(sp);
		}
		
		resultset.close();
		statement.close();
		conn.disconnect();
		
		return listSanPham;
	}
	
	public List<SanPham> listSanPhamTheoTen(String TenHangSX) throws SQLException{
		List<SanPham> listSanPham = new ArrayList<>();
		
		String sql="select * from SanPham where HangSX=?";
		
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, TenHangSX);
		ResultSet resultset = statement.executeQuery();
		
		while (resultset.next()) {
			String MaSP=resultset.getString("MaSP");
			String TenSP=resultset.getString("TenSP");
			float DonGia=resultset.getFloat("DonGia");
			int TonKho=resultset.getInt("TonKho");
			String HangSX=resultset.getString("HangSX");
			String CPU=resultset.getString("CPU");
			String RAM=resultset.getString("RAM");
			String OCung=resultset.getString("OCung");
			String ManHinh=resultset.getString("ManHinh");
			String HeDH=resultset.getString("HeDH");
			String Hinh=resultset.getString("Hinh");
			
			SanPham sp= new SanPham(MaSP,TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh);
			listSanPham.add(sp);
		}
		resultset.close();
		statement.close();
		conn.disconnect();
		
		return listSanPham;
	}
		public List<SanPham> listSanPhamTheoHangSX(String TenHangSX) throws SQLException{
			List<SanPham> listSanPham = new ArrayList<>();
			
			String sql="select Top (3) * from SanPham where HangSX=?";
			
			conn.connect();
			
			PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
			statement.setString(1, TenHangSX);
			ResultSet resultset = statement.executeQuery();
			
			while (resultset.next()) {
				String MaSP=resultset.getString("MaSP");
				String TenSP=resultset.getString("TenSP");
				float DonGia=resultset.getFloat("DonGia");
				int TonKho=resultset.getInt("TonKho");
				String HangSX=resultset.getString("HangSX");
				String CPU=resultset.getString("CPU");
				String RAM=resultset.getString("RAM");
				String OCung=resultset.getString("OCung");
				String ManHinh=resultset.getString("ManHinh");
				String HeDH=resultset.getString("HeDH");
				String Hinh=resultset.getString("Hinh");
				
				SanPham sp= new SanPham(MaSP,TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh);
				listSanPham.add(sp);
			}
		
		resultset.close();
		statement.close();
		conn.disconnect();
		
		return listSanPham;
	}
	
	public List<SanPham> listSanPhamTheoGia(float DonGia) throws SQLException{
		List<SanPham> listSanPham = new ArrayList<>();
		
		String sql="select * from SanPham where DonGia<=?";
		
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setFloat(1, DonGia);
		ResultSet resultset = statement.executeQuery();
		
		while (resultset.next()) {
			String MaSP=resultset.getString("MaSP");
			String TenSP=resultset.getString("TenSP");
			int TonKho=resultset.getInt("TonKho");
			String HangSX=resultset.getString("HangSX");
			String CPU=resultset.getString("CPU");
			String RAM=resultset.getString("RAM");
			String OCung=resultset.getString("OCung");
			String ManHinh=resultset.getString("ManHinh");
			String HeDH=resultset.getString("HeDH");
			String Hinh=resultset.getString("Hinh");
			
			SanPham sp= new SanPham(MaSP,TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh);
			listSanPham.add(sp);
		}
		
		resultset.close();
		statement.close();
		conn.disconnect();
		
		return listSanPham;
	}
	
	public List<SanPham> listSanPhamTheoCPU(String CPU) throws SQLException{
		List<SanPham> listSanPham = new ArrayList<>();
		
		String sql="select * from SanPham where CPU=?";
		
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, CPU);
		ResultSet resultset = statement.executeQuery();
		
		while (resultset.next()) {
			String MaSP=resultset.getString("MaSP");
			String TenSP=resultset.getString("TenSP");
			float DonGia=resultset.getFloat("DonGia");
			int TonKho=resultset.getInt("TonKho");
			String HangSX=resultset.getString("HangSX");
			String RAM=resultset.getString("RAM");
			String OCung=resultset.getString("OCung");
			String ManHinh=resultset.getString("ManHinh");
			String HeDH=resultset.getString("HeDH");
			String Hinh=resultset.getString("Hinh");
			
			SanPham sp= new SanPham(MaSP,TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh);
			listSanPham.add(sp);
		}
		
		resultset.close();
		statement.close();
		conn.disconnect();
		
		return listSanPham;
	}
	
	public List<SanPham> listSanPhamTheoRAM(String RAM) throws SQLException{
		List<SanPham> listSanPham = new ArrayList<>();
		
		String sql="select Top (3) * from SanPham where RAM=?";
		
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, RAM);
		ResultSet resultset = statement.executeQuery();
		
		while (resultset.next()) {
			String MaSP=resultset.getString("MaSP");
			String TenSP=resultset.getString("TenSP");
			float DonGia=resultset.getFloat("DonGia");
			int TonKho=resultset.getInt("TonKho");
			String HangSX=resultset.getString("HangSX");
			String CPU=resultset.getString("CPU");
			String OCung=resultset.getString("OCung");
			String ManHinh=resultset.getString("ManHinh");
			String HeDH=resultset.getString("HeDH");
			String Hinh=resultset.getString("Hinh");
			
			SanPham sp= new SanPham(MaSP,TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh);
			listSanPham.add(sp);
		}
		
		resultset.close();
		statement.close();
		conn.disconnect();
		
		return listSanPham;
	}
	
	public List<SanPham> listSanPhamTheoOCung(String OCung) throws SQLException{
		List<SanPham> listSanPham = new ArrayList<>();
		
		String sql="select * from SanPham where OCung=?";
		
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, OCung);
		ResultSet resultset = statement.executeQuery();
		
		while (resultset.next()) {
			String MaSP=resultset.getString("MaSP");
			String TenSP=resultset.getString("TenSP");
			float DonGia=resultset.getFloat("DonGia");
			int TonKho=resultset.getInt("TonKho");
			String HangSX=resultset.getString("HangSX");
			String CPU=resultset.getString("CPU");
			String RAM=resultset.getString("RAM");
			String ManHinh=resultset.getString("ManHinh");
			String HeDH=resultset.getString("HeDH");
			String Hinh=resultset.getString("Hinh");
			
			SanPham sp= new SanPham(MaSP,TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh);
			listSanPham.add(sp);
		}
		
		resultset.close();
		statement.close();
		conn.disconnect();
		
		return listSanPham;
	}
	
	public void insertSanPham(SanPham sanpham) throws SQLException {
		String sql="Insert into sanpham (MaSP,TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh) values (?,?,?,?,?,?,?,?,?,?,?)";
		conn.connect();
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		
		statement.setNString(1,sanpham.getMasp());
		statement.setNString(2, sanpham.getTensp());
		statement.setFloat(3, sanpham.getDongia());
		statement.setInt(4, sanpham.getTonkho());
		statement.setNString(5, sanpham.getHangsx());
		statement.setNString(6, sanpham.getCpu());
		statement.setNString(7, sanpham.getRam());
		statement.setNString(8, sanpham.getOcung());
		statement.setNString(9, sanpham.getManhinh());
		statement.setNString(10, sanpham.getHedh());
		statement.setString(11, sanpham.getHinh());
		
		statement.executeUpdate();
		
		statement.close();
		conn.disconnect();
		
			
	}	
	
	public void deleteSanPham (SanPham sanpham) throws SQLException{
		String sql = "Delete from SanPham where MaSP=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, sanpham.getMasp());
		
		statement.execute();
		
		statement.close();
		conn.disconnect();				
	}
	
	public void updateSanPham(SanPham sanpham) throws SQLException{
		String sql = "update SanPham set TenSP=?,DonGia=?,TonKho=?,HangSX=?,CPU=?,RAM=?,OCung=?,ManHinh=?,HeDH=?, Hinh=? where MaSP=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setNString(1, sanpham.getTensp());
		statement.setFloat(2, sanpham.getDongia());
		statement.setInt(3, sanpham.getTonkho());
		statement.setNString(4, sanpham.getHangsx());
		statement.setNString(5, sanpham.getCpu());
		statement.setNString(6, sanpham.getRam());
		statement.setNString(7, sanpham.getOcung());
		statement.setNString(8, sanpham.getManhinh());
		statement.setNString(9, sanpham.getHedh());
		statement.setNString(10, sanpham.getHinh());
		statement.setNString(11, sanpham.getMasp());
		
		statement.executeUpdate();
		statement.close();
		conn.disconnect();
		
	}
	
	public SanPham getSanPham (String MaSP) throws SQLException{
		SanPham sanpham =null;
		String sql = "Select * from sanpham where MaSP=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, MaSP);
		
		ResultSet resultset = statement.executeQuery();
		
		if (resultset.next())
		{
			String TenSP=resultset.getString("TenSP");
			Float DonGia=resultset.getFloat("DonGia");
			int TonKho=resultset.getInt("TonKho");
			String HangSX=resultset.getString("HangSX");
			String CPU=resultset.getString("CPU");
			String RAM=resultset.getString("RAM");
			String OCung=resultset.getString("OCung");
			String ManHinh=resultset.getString("ManHinh");
			String HeDH=resultset.getString("HeDH");
			String Hinh=resultset.getString("Hinh");
			
			sanpham=new SanPham (MaSP,TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh);			
		}
		
		resultset.close();
		statement.close();
		return sanpham;
	}
	public SanPham getSanPhamTheoTen (String TenSP) throws SQLException{
		SanPham sanpham =null;
		String sql = "Select * from sanpham where TenSP=?";
		conn.connect();
		
		PreparedStatement statement = conn.jdbcConnection.prepareStatement(sql);
		statement.setString(1, TenSP);
		
		ResultSet resultset = statement.executeQuery();
		
		if (resultset.next())
		{
			String MaSP=resultset.getString("MaSP");
			Float DonGia=resultset.getFloat("DonGia");
			int TonKho=resultset.getInt("TonKho");
			String HangSX=resultset.getString("HangSX");
			String CPU=resultset.getString("CPU");
			String RAM=resultset.getString("RAM");
			String OCung=resultset.getString("OCung");
			String ManHinh=resultset.getString("ManHinh");
			String HeDH=resultset.getString("HeDH");
			String Hinh=resultset.getString("Hinh");
			
			sanpham=new SanPham (MaSP,TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh);			
		}
		
		resultset.close();
		statement.close();
		return sanpham;
	}
	
}
