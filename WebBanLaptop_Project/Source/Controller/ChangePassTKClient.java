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
 * Servlet implementation class ChangePassTKClient
 */
@WebServlet("/ChangePassTKClient")
public class ChangePassTKClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO lgDAO = new LoginDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassTKClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			changepassTK(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void changepassTK(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException{
		HttpSession session = (HttpSession) request.getSession();
		String TenDangNhap = (String) session.getAttribute("TenDangNhap");
		String MatKhauCu = request.getParameter("MatKhauCu");
		String MatKhauMoi = request.getParameter("MatKhauMoi");
		String LapLaiMatKhauMoi = request.getParameter("LapLaiMatKhauMoi");
		String thongbao = "Sai mật khẩu, mời nhập lại";
		String color = "red";
		if (lgDAO.DangNhapTaiKhoanKhach(TenDangNhap, MatKhauCu))
		{
			if (MatKhauMoi.equals(LapLaiMatKhauMoi))
			{
				lgDAO.DoiMatKhau(TenDangNhap,MatKhauMoi);
				thongbao="Đã đổi mật khẩu thành công!!!";
				color="green";
			}
			else
			{
				thongbao="Mật khẩu mới không trùng nhau, mời nhập lại!!!";
			}
			
		}
		request.setAttribute("thongbao", thongbao);
		request.setAttribute("color", color);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index_logged_changepass.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
