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

import Model.HoaDon;
import DAO.HDDAO;
/**
 * Servlet implementation class GetHD
 */
@WebServlet("/GetHD")
public class GetHD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HDDAO hdDAO = new HDDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			getHoaDon(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getHoaDon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
		
		String MaHD = request.getParameter("mahd");
		List<HoaDon> listHoaDon = hdDAO.listAllHoaDon();
		request.setAttribute("listHoaDon", listHoaDon);
		HoaDon hd = hdDAO.getHoaDon();
		request.setAttribute("hoadon", hd);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin_HD.jsp");
		dispatcher.forward(request,response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
