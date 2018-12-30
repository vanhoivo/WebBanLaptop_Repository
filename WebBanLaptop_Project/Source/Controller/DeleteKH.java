package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KHDAO;

/**
 * Servlet implementation class DeleteKH
 */
@WebServlet("/DeleteKH")
public class DeleteKH extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KHDAO khDAO = new KHDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteKH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			deleteKhachHang(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deleteKhachHang(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		String MaKH=request.getParameter("makh");
		
		khDAO.deleteKhachHang(MaKH);
		response.sendRedirect("khachhang");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
