package Controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.SPDAO;
import Model.SanPham;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class InsertSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SPDAO spDAO = new SPDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			insertSanPham(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void insertSanPham(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String MaSP = request.getParameter("MaSP");
		String TenSP=request.getParameter("TenSP");
		float DonGia=Float.parseFloat(request.getParameter("DonGia"));
		int TonKho=Integer.parseInt(request.getParameter("TonKho"));
		String HangSX=request.getParameter("HangSX");
		String CPU=request.getParameter("CPU");
		String RAM=request.getParameter("RAM");
		String OCung=request.getParameter("OCung");
		String ManHinh=request.getParameter("ManHinh");
		String HeDH=request.getParameter("HeDH");
		String Hinh = "images/"+request.getParameter("iptHinh");
		
		SanPham sanpham = new SanPham(MaSP,TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh);
		spDAO.insertSanPham(sanpham);
		response.sendRedirect("sanpham");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	
}
