package Controller;

import java.awt.Image;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.NhanVien;
import DAO.NVDAO;

/**
 * Servlet implementation class InsertNV
 */
@WebServlet("/InsertNV")
public class InsertNV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NVDAO nvDAO=new NVDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			insertNhanVien(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void insertNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		String MaNV = request.getParameter("iptMaNV");
		String TenNV=request.getParameter("iptTenNV");
		boolean GioiTinh=Boolean.getBoolean(request.getParameter("iptGioiTinh"));
		Date NgayNV= Date.valueOf(request.getParameter("iptNgayNVadd"));
		String DiaChi=request.getParameter("iptDiaChi");
		String SoDT=request.getParameter("iptSoDT");
		Image Hinh =null;
		float LuongCB=Float.parseFloat(request.getParameter("iptLuongCB"));
		float PhuCap=Float.parseFloat(request.getParameter("iptPhuCap"));
		float LuongCT = 0;
		
		NhanVien nhanvien = new NhanVien(MaNV,TenNV,GioiTinh,NgayNV,DiaChi,SoDT,Hinh,LuongCB,PhuCap,LuongCT);
		nvDAO.insertNhanVien(nhanvien);
		response.sendRedirect("nhanvien");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
