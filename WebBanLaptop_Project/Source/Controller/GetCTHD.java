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

import Model.ChiTietHD;
import DAO.ChiTietHDDAO;

/**
 * Servlet implementation class GetCTHD
 */
@WebServlet("/GetCTHD")
public class GetCTHD extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChiTietHDDAO cthdDAO = new ChiTietHDDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCTHD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			getChiTietHoaDon(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

private void getChiTietHoaDon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
		
		String MaHD = request.getParameter("mahd");
		List<ChiTietHD> listCTHD = cthdDAO.listAllChiTietHD();
		request.setAttribute("listCTHD", listCTHD);
		ChiTietHD cthd = cthdDAO.getChiTietHoaDon(MaHD);
		request.setAttribute("chitiethoadon", cthd);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin_CTHD.jsp");
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
