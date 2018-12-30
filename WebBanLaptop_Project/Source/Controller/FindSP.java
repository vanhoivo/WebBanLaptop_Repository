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

import Model.SanPham;
import DAO.SPDAO;

/**
 * Servlet implementation class FindSP
 */
@WebServlet("/FindSP")
public class FindSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SPDAO spDAO = new SPDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindSP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			getSanPham(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getSanPham(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		
		String TenSP=request.getParameter("TenSP");
		String Check = request.getParameter("check");
		List<SanPham> listSanPham=spDAO.listAllSanPham();
		request.setAttribute("listSanPham", listSanPham);	
		SanPham sanpham = spDAO.getSanPhamTheoTen(TenSP);
		request.setAttribute("sanpham", sanpham);
		request.setAttribute("check", Check);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
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
