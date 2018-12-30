package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.KhachHang;
import DAO.KHDAO;

/**
 * Servlet implementation class InsertKH
 */
@WebServlet("/InsertKH")
public class InsertKH extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KHDAO khDAO = new KHDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertKH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			insertKhachHang(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void insertKhachHang(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String MaKH = null;
		String TenKH = request.getParameter("TenKH");
		String DiaChi = request.getParameter("DiaChi");
		String SoDT = request.getParameter("SoDT");
		String Email = request.getParameter("Email");
		String TenDangNhap = request.getParameter("TenDangNhap");
		
		KhachHang khachhang = new KhachHang(MaKH,TenKH,DiaChi,SoDT,Email,TenDangNhap);
		
		khDAO.insertKhachHang(khachhang);
		response.sendRedirect("khachhang");
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
