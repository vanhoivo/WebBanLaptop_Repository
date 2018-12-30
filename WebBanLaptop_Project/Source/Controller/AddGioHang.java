package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class AddGioHang
 */
@WebServlet("/addGioHang")
public class AddGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SPDAO spDAO = new SPDAO();
    private GioHang giohang = new GioHang();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGioHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			addGioHang(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addGioHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		int SoLuong;
		try {
			SoLuong = Integer.parseInt(request.getParameter("SoLuong"));
		} catch (Exception e)
		{
			SoLuong=1;
		}

		String MaSP;
		if (request.getParameter("masp")!=null) {
			MaSP = request.getParameter("masp");
			SanPham sp = spDAO.getSanPham(MaSP);
			if(sp!=null) {
				if (request.getParameter("soluong")!=null) {
					SoLuong = Integer.parseInt(request.getParameter("soluong"));
				}
				HttpSession session = request.getSession();
				if (session.getAttribute("giohang") == null ) {
					GioHang giohang = new GioHang();
					List<Item> ListSanPham = new ArrayList<Item>();
					Item item = new Item();
					item.setSoluong(SoLuong);
					item.setSanpham(sp);
					item.setDongia((long) sp.getDongia());
					ListSanPham.add(item);
					giohang.setListSanPham(ListSanPham);
					giohang.setTongtien();
					session.setAttribute("giohang", giohang);
				} else {
					GioHang giohang = (GioHang) session.getAttribute("giohang");
					List<Item> ListSanPham = giohang.getListSanPham();
					boolean check = false;
					for(Item item : ListSanPham) {
						if (item.getSanpham().getMasp().equals(sp.getMasp())) {
							item.setSoluong(item.getSoluong()+SoLuong);
							check=true;
						}
					}
					if (check == false) {
						Item item = new Item();
						item.setSoluong(SoLuong);
						item.setSanpham(sp);
						item.setDongia((long) (sp.getDongia()));
						ListSanPham.add(item);
					}
					giohang.setListSanPham(ListSanPham);
					giohang.setTongtien();
					session.setAttribute("giohang", giohang);
				}
			}
			response.sendRedirect("Cart.jsp");
		} else {			
			response.sendRedirect(request.getRequestURI()+"#"); 
			
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
