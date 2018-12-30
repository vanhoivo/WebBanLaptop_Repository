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

import DAO.SPDAO;
import Model.SanPham;

/**
 * Servlet implementation class ChiTietSanPham
 */
@WebServlet("/LoadChiTietSP")
public class LoadChiTietSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SPDAO spDAO = new SPDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadChiTietSP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			loadChiTietSanPham(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void loadChiTietSanPham(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		
		String MaSP=request.getParameter("masp");
		SanPham sanpham = spDAO.getSanPham(MaSP);
		request.setAttribute("sanpham", sanpham);
		List<SanPham> listSanPham = spDAO.listSanPhamTheoHangSX(sanpham.getHangsx());
		request.setAttribute("listSanPham", listSanPham);
		List<SanPham> listSanPham1 = spDAO.listSanPhamTheoRAM(sanpham.getRam());
		request.setAttribute("listSanPham1", listSanPham1);
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
