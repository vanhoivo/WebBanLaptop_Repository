<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<title>Giỏ hàng</title>
<style>
.navbar {
	border-radius: 0;
}

</style>
</head>
<header>
	<div class="container">
		<div class="row">
			<div class="navbar-header col-lg-4" style="padding-left: 0px">
				<a class="navbar-brand" href="index.jsp">PLH STORE</a>
			</div>
			<div class="col-lg-4">
				<form class="navbar-form " action="/action_page.php">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Search</button>
				</form>
			</div>
			<c:if test="${login == null }" >
			<div class="col-lg-4">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="Cart.jsp"><span
							class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
					<li><a href="SignUp.jsp"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="SignIn.jsp"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</ul>
			</div>
			</c:if>
			<c:if test="${login == true }" >
				<div class="col-lg-4">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="Cart.jsp"><span
							class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
					<li><a data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user" ></span> ${TenDangNhap } </a>  
							    <ul class="dropdown-menu">
      								<li><a href="GetKHClient">Thông tin tài khoản</a></li>
      								<li><a href="index_logged_changepass.jsp">Đổi mật khẩu</a></li>
      								<li class="divider"></li>
							      	<li><a href="LogoutTK">Đăng xuất</a></li>
							    </ul></li>
				</ul>
			</div>
			</c:if>
		</div>
	</div>
</header>
<body>
	<!--MENU-->
	<nav class="navbar navbar-default navbar-inverse" role="navigation">
		<div class="container" style="padding-left: 0px">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse"
				style="padding-left: 0px">
				<ul class="nav navbar-nav">
					<li><a href="index">TRANG CHỦ</a></li>
					<li><a href="gioithieu.jsp">GIỚI THIỆU</a></li>
					<li><a href="lienhe.jsp">LIÊN HỆ</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
	</nav>
	<div class="container">
		<c:if test="${giohang !=null }">
		<div class="row">
			<h4>Giỏ hàng của bạn(${giohang.listSanPham.size() })</h4>
		</div>	
		
		<c:forEach var="sp" items="${giohang.listSanPham }">
		<div class="row"
			style="width: 60%; margin: 0 auto; height: 200px; border-bottom: solid 1px;">
			<div class="col-lg-2">
				<img src="images/single_4.jpg" alt=""
					style="width: 100%; height: 100% px">
			</div>
			<div class="col-lg-3">
				<h3 style="margin-top: 40px">
					<a href="/may-tinh-xach-tay/dell-inspiron-n3576s" target="_blank"><p>${sp.sanpham.tensp } </p></a>
				</h3>
			<div class="col-lg-4">
				<p style="margin-top: 40px; font-size: 20px">
					${sp.dongia }<sup>đ</sup>
				</p>
			</div>
			<div class="col-lg-2">

			</div>
			<div class="col-lg-1">
				<a href="DeleteGioHang?masp=${sp.sanpham.masp }"><span class="glyphicon glyphicon-remove"></span></a>
			</div>
		</div>
		</div>
		</c:forEach>
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4"
				style="float: right;">
				<label style="font-size: 18px; color: black; width: 100px;">Tổng tiền:${giohang.tongtien }</label><br>
					<a href="CheckLogin"><button class="btn btn-danger" style=" width:50%">Đặt hàng</button></a>
			</div>
		</c:if>
		<c:if test="${giohang == null }">
			<h2>Không có sản phẩm trong giỏ hàng của bạn!!!</h2>
		</c:if>
	</div>

</body>
<footer class="page-footer ">

	<!-- Copyright -->
	<div class="footer-copyright container"
		style="background-color: #212529; color: #6c757d; margin-top: 5px;">
		<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6"
			style="padding-top: 5px;">
			PLH Store<br> Số 1, Võ Văn Ngân, Linh Chiểu, Thủ Đức, TP Hồ Chí
			Minh<br> Điện thoại:0767 767 767<br> Email:plh@gmail.com<br>
			<p>Copyright © (2018) PLH Store</p>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
			<nav class="navbar" role="navigation">
				<ul class="nav navbar-nav" style="float: right;">
					<li><a href="gioithieu.jsp">Giới thiệu</a></li>
					<li style="padding-top: 15px">|</li>
					<li><a href="lienhe.jsp">Liên hệ</a></li>
				</ul>
			</nav>

		</div>
	</div>
	<!-- Copyright -->

</footer>
</html>