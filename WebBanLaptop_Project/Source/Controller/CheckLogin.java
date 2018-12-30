package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Time;

import Model.ChiTietHD;
import Model.GioHang;
import Model.TaiKhoan;
import Model.HoaDon;
import Model.Item;
import Model.KhachHang;
import DAO.KHDAO;
import DAO.LoginDAO;
import DAO.HDDAO;
import DAO.ChiTietHDDAO;
/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KHDAO khDAO = new KHDAO();
	private HDDAO hdDAO = new HDDAO();
	private ChiTietHDDAO cthdDAO = new ChiTietHDDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			checkLogin(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		HttpSession session = request.getSession();
		
		if (session.getAttribute("login") == null)
		{
			response.sendRedirect("SignIn.jsp");
		}
		else
		{			
			GioHang giohang = (GioHang) session.getAttribute("giohang");
			String TenDangNhap = (String) session.getAttribute("TenDangNhap");
			KhachHang kh= khDAO.getKhachHangTheoTK(TenDangNhap);		
			String MaHD = "a";
			Date NgayLapHD = Date.valueOf(LocalDate.now());
			Date NgayGiaoHang = Date.valueOf(LocalDate.now());
			float TongTien = 0;
			HoaDon hoadon = new HoaDon(MaHD,kh.getMakh(),NgayLapHD,NgayGiaoHang,TongTien);
			hdDAO.insertHoaDon(hoadon);
			
			HoaDon hd = hdDAO.getHoaDon();
			
			List<Item> ListSanPham = giohang.getListSanPham();
			for(Item item : ListSanPham) {
				String MaSP= item.getSanpham().getMasp();
				int SoLuong = item.getSoluong();
				int ThanhTien =0;
				ChiTietHD cthd = new ChiTietHD(hd.getMahd(),MaSP,SoLuong,ThanhTien);
				cthdDAO.insertChiTietHoaDon(cthd);
				
			}
			session.removeAttribute("giohang");
			
			response.sendRedirect("LoadCTHDTheoTK");
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
