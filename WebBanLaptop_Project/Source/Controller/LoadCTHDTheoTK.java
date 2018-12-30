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
import javax.servlet.http.HttpSession;

import Model.ChiTietHD;
import Model.TaiKhoan;
import Model.HoaDon;
import Model.KhachHang;
import DAO.KHDAO;
import DAO.LoginDAO;
import DAO.HDDAO;
import DAO.ChiTietHDDAO;

/**
 * Servlet implementation class LoadCTHDTheoTK
 */
@WebServlet("/LoadCTHDTheoTK")
public class LoadCTHDTheoTK extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KHDAO khDAO = new KHDAO();
	private HDDAO hdDAO = new HDDAO();
	private ChiTietHDDAO cthdDAO = new ChiTietHDDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadCTHDTheoTK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			listCTHD(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void listCTHD(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		try {					
		HttpSession session = (HttpSession) request.getSession();
		String TenDangNhap = (String) session.getAttribute("TenDangNhap");	
		KhachHang kh = khDAO.getKhachHangTheoTK(TenDangNhap);
		HoaDon hd = hdDAO.getHoaDonTheoTK(kh.getMakh());
		List<ChiTietHD> listCTHD = cthdDAO.listChiTietHDTheoHD(hd.getMahd());
		request.setAttribute("listCTHD", listCTHD);
		request.setAttribute("hoadon", hd);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index_logged_orders.jsp");
		dispatcher.forward(request,response);	
		} catch (Exception e)
		{
			request.setAttribute("thongbao", "Bạn chưa có đơn hàng nào!!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index_logged_orders.jsp");
			dispatcher.forward(request,response);
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
