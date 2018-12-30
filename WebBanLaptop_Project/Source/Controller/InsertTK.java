package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoginDAO;
import Model.TaiKhoan;
import DAO.KHDAO;
import Model.KhachHang;
/**
 * Servlet implementation class InsertTK
 */
@WebServlet("/InsertTK")
public class InsertTK extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDAO lgDAO = new LoginDAO();   
    private KHDAO khDAO = new KHDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTK() {
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
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		boolean admin = false;		
		String TenDangNhap = request.getParameter("TenDangNhap");
		String MatKhau = request.getParameter("MatKhau");
		String LapLaiMatKhau = request.getParameter("LapLaiMatKhau");
		String MaKH = null;
		String TenKH = request.getParameter("TenKH");
		String DiaChi = request.getParameter("DiaChi");
		String SoDT = request.getParameter("SoDT");
		String Email = request.getParameter("Email");
		if (MatKhau.equals(LapLaiMatKhau))
		{
			TaiKhoan tk = new TaiKhoan(TenDangNhap,MatKhau,admin);
			lgDAO.insertTaiKhoanKhach(tk);			
			KhachHang kh = new KhachHang(MaKH,TenKH,DiaChi,SoDT,Email,TenDangNhap);
			khDAO.insertKhachHang(kh);

			response.sendRedirect("SignIn.jsp");
		}	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
