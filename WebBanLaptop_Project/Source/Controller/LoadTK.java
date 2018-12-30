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

import DAO.LoginDAO;
import Model.TaiKhoan;



/**
 * Servlet implementation class LoadTK
 */
@WebServlet("/nguoidung")
public class LoadTK extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO lgDAO= new LoginDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadTK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			listTaiKhoan(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void listTaiKhoan(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		List<TaiKhoan> listTaiKhoan=lgDAO.listAllTaiKhoan();
		request.setAttribute("listTaiKhoan", listTaiKhoan);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin_ND.jsp");
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
