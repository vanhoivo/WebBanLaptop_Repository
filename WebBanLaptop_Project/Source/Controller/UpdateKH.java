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
import javax.servlet.http.HttpSession;

import Model.KhachHang;
import DAO.KHDAO;

/**
 * Servlet implementation class UpdateKH
 */
@WebServlet("/UpdateKH")
public class UpdateKH extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KHDAO khDAO = new KHDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateKH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			updateKhachHang(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void updateKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = (HttpSession) request.getSession();
		String TenDangNhap = (String) session.getAttribute("TenDangNhap");
		String TenKH = request.getParameter("TenKH");
		String Email = request.getParameter("Email");
		String SoDT = request.getParameter("SoDT");
		String DiaChi = request.getParameter("DiaChi");
		
		KhachHang kh = khDAO.getKhachHangTheoTK(TenDangNhap);
		kh.setTenkh(TenKH);
		kh.setDiachi(DiaChi);
		kh.setEmail(Email);
		kh.setSodienthoai(SoDT);
		
		khDAO.updateKhachHang(kh);
		response.sendRedirect("GetKHClient");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
