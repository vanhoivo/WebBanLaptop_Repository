package Controller;

import java.awt.Image;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NVDAO;
import Model.NhanVien;

/**
 * Servlet implementation class UpdateNV
 */
@WebServlet("/UpdateNV")
public class UpdateNV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NVDAO nvDAO = new NVDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			updateNhanVien(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void updateNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String MaNV = request.getParameter("MaNVEdit");
		String TenNV=request.getParameter("TenNVEdit");
		Boolean GioiTinh = Boolean.parseBoolean(request.getParameter("GioiTinhEdit")) ;
		Date NgayNV = Date.valueOf(request.getParameter("NgayNVEdit"));
		String DiaChi = request.getParameter("DiaChiEdit");
		String SoDT = request.getParameter("SoDTEdit");
		Float LuongCB = Float.parseFloat(request.getParameter("LuongCBEdit"));
		Float PhuCap = Float.parseFloat(request.getParameter("PhuCapEdit"));
		Float LuongCT= (float) 0;
		Image Hinh = null;
		
		NhanVien nhanvien = new NhanVien(MaNV,TenNV,GioiTinh,NgayNV,DiaChi,SoDT,Hinh,LuongCB,PhuCap,LuongCT);
		nvDAO.updateNhanVien(nhanvien);
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
