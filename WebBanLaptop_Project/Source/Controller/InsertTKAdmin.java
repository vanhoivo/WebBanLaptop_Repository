package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.TaiKhoan;
import DAO.LoginDAO;

/**
 * Servlet implementation class InsertTKAdmin
 */
@WebServlet("/InsertTKAdmin")
public class InsertTKAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO lgDAO = new LoginDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTKAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			insertTaiKhoan(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
private  void insertTaiKhoan (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		boolean admin = true;		
		String TenDangNhap = request.getParameter("iptTenND");
		String MatKhau = request.getParameter("iptMatKhau");
			TaiKhoan tk = new TaiKhoan(TenDangNhap,MatKhau,admin);
			lgDAO.insertTaiKhoanKhach(tk);			
			response.sendRedirect("nguoidung");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
