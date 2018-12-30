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

import DAO.NVDAO;
import Model.NhanVien;

/**
 * Servlet implementation class ControllerNV
 */
public class LoadNV extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NVDAO nvDAO= new NVDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadNV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listNhanVien(request,response);
		}catch(SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void listNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		List<NhanVien> listNhanVien=nvDAO.listAllNhanVien();
		request.setAttribute("listNhanVien", listNhanVien);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin_NV.jsp");
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
