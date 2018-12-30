package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HDDAO;
import Model.HoaDon;

/**
 * Servlet implementation class InsertHD
 */
@WebServlet("/InsertHD")
public class InsertHD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HDDAO hdDAO = new HDDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertHD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			insertSanPham(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void insertSanPham(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		String MaHD=null;
		String MaKH=request.getParameter("MaKH");
		Date NgayLapHD=Date.valueOf(request.getParameter("NgayLapHD"));
		Date NgayGiaoHang=Date.valueOf(request.getParameter("NgayGiaoHang"));
		float TongTien = 0;
		
		HoaDon hoadon = new HoaDon (MaHD,MaKH,NgayLapHD,NgayGiaoHang,TongTien);
		hdDAO.insertHoaDon(hoadon);
		response.sendRedirect("hoadon");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
