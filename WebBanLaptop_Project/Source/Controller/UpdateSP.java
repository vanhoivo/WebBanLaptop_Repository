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
 * Servlet implementation class UpdateSP
 */
@WebServlet("/UpdateSP")
public class UpdateSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private SPDAO spDAO = new SPDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			updateSanPham(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void updateSanPham(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String MaSP = request.getParameter("MaSP");
		String TenSP=request.getParameter("TenSP");
		float DonGia=Float.parseFloat(request.getParameter("DonGia"));
		int TonKho=Integer.parseInt(request.getParameter("TonKho"));
		String HangSX=request.getParameter("HangSX");
		String CPU=request.getParameter("CPU");
		String RAM=request.getParameter("RAM");
		String OCung=request.getParameter("OCung");
		String ManHinh=request.getParameter("ManHinh");
		String HeDH=request.getParameter("HeDH");
		String Hinh="images/"+request.getParameter("iptHinh");
		
		SanPham sp = new SanPham(MaSP,TenSP,DonGia,TonKho,HangSX,CPU,RAM,OCung,ManHinh,HeDH,Hinh);
		spDAO.updateSanPham(sp);
		response.sendRedirect("sanpham");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
