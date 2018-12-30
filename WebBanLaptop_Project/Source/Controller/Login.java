package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import Model.TaiKhoan;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO lgDAO = new LoginDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Login(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String TenDangNhap=request.getParameter("TenDangNhap");
		String MatKhau=request.getParameter("MatKhau");
		Boolean Login = false;
		if(lgDAO.DangNhapTaiKhoanKhach(TenDangNhap, MatKhau))
		{
			Login = true;
			HttpSession session = (HttpSession) request.getSession();
			session.setAttribute("TenDangNhap", TenDangNhap);
			request.setAttribute("TenDangNhap", TenDangNhap);
			request.setAttribute("login", Login);
			session.setAttribute("login", Login);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index");
			dispatcher.forward(request, response);
		}
		else if(lgDAO.DangNhapTaiKhoanAdmin(TenDangNhap, MatKhau))
		{		
			HttpSession session = (HttpSession) request.getSession();
			session.setAttribute("TenDangNhap", TenDangNhap);
			request.setAttribute("TenDangNhap", TenDangNhap);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/nhanvien");
			dispatcher.forward(request, response);
		}
		else
		{
			String thongbao = "Tên đăng nhập hoặc mật khẩu bị sai, mời bạn nhập lại!!!";
			request.setAttribute("thongbao", thongbao);
			RequestDispatcher dispatcher = request.getRequestDispatcher("SignIn.jsp");
			dispatcher.forward(request, response);
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
