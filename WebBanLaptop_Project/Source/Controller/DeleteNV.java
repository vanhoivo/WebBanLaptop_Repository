package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.NVDAO;

/**
 * Servlet implementation class DeleteNV
 */
@WebServlet("/DeleteNV")
public class DeleteNV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NVDAO nvDAO=new NVDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			deleteNhanVien(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		String MaNV=request.getParameter("manv");
		
		nvDAO.deleteNhanVien(MaNV);
		response.sendRedirect("nhanvien");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
