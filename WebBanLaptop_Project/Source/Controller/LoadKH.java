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

import Model.KhachHang;
import DAO.KHDAO;

/**
 * Servlet implementation class ControllerKH
 */
@WebServlet("/ControllerKH")
public class LoadKH extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KHDAO khDAO=new KHDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadKH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			listKhachHang(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void listKhachHang(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		List<KhachHang> listKhachHang=khDAO.listAllKhachHang();
		request.setAttribute("listKhachHang", listKhachHang);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin_KH.jsp");
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
