package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ChiTietHD;
import Model.HoaDon;
import DAO.ChiTietHDDAO;

/**
 * Servlet implementation class InsertCTHD
 */
@WebServlet("/InsertCTHD")
public class InsertCTHD extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChiTietHDDAO cthdDAO = new ChiTietHDDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCTHD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			insertCTHD(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void insertCTHD(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		String MaHD=request.getParameter("MaHD");
		String MaSP=request.getParameter("MaSP");
		int SoLuong=Integer.parseInt(request.getParameter("SoLuong")) ;
		int ThanhTien =0;

		ChiTietHD cthd = new ChiTietHD(MaHD,MaSP,SoLuong,ThanhTien);
		cthdDAO.insertChiTietHoaDon(cthd);
		response.sendRedirect("chitiethoadon");
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
