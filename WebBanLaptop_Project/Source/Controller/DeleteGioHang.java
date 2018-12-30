package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SPDAO;
import Model.GioHang;
import Model.SanPham;
import Model.Item;
/**
 * Servlet implementation class DeleteGioHang
 */
@WebServlet("/DeleteGioHang")
public class DeleteGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SPDAO spDAO = new SPDAO();
    private GioHang giohang = new GioHang();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGioHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			deleteGioHang(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deleteGioHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String MaSP= request.getParameter("masp");
		
		HttpSession session = request.getSession();
		GioHang giohang = (GioHang) session.getAttribute("giohang");
		List<Item> ListSanPham = giohang.getListSanPham();
		for(Item item : ListSanPham) {
			if (item.getSanpham().getMasp().equals(MaSP)) {
				ListSanPham.remove(ListSanPham.indexOf(item));
				break;
			}
		}
		if (ListSanPham.size() == 0)
			session.removeAttribute("giohang");
		response.sendRedirect("Cart.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
