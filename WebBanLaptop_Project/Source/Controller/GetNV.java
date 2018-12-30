package Controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NVDAO;
import Model.NhanVien;

/**
 * Servlet implementation class GetNV
 */
@WebServlet("/GetNV")
public class GetNV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NVDAO nvDAO = new NVDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			getNhanVien(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void getNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException{
		String MaNV = request.getParameter("manv");
		List<NhanVien> listNhanVien = nvDAO.listAllNhanVien();
		request.setAttribute("listNhanVien", listNhanVien);
		NhanVien nhanvien = nvDAO.getNhanVien(MaNV);
		request.setAttribute("nhanvien", nhanvien);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin_NV.jsp");
		dispatcher.forward(request, response);;	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
