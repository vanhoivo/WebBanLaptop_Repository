package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ChiTietHDDAO;
/**
 * Servlet implementation class DeleteCTHD
 */
@WebServlet("/DeleteCTHD")
public class DeleteCTHD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChiTietHDDAO cthdDAO = new ChiTietHDDAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCTHD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			deleteCTHD(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void deleteCTHD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
		String MaHD = request.getParameter("mahd");
		String MaSP = request.getParameter("masp");
		cthdDAO.deleteChiTietHoaDon(MaHD, MaSP);
		response.sendRedirect("chitiethoadon");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
