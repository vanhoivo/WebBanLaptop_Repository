package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SPDAO;
import Model.SanPham;

/**
 * Servlet implementation class ControllerServlet
 */
public class LoadSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SPDAO spDAO = new SPDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadSP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	            try {
					listSanPham(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	private void listSanPham(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		List<SanPham> listSanPham=spDAO.listAllSanPham();
		request.setAttribute("listSanPham", listSanPham);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin_SP.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}
