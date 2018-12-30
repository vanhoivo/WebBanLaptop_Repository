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
<title>Chi tiết sản phẩm</title>
<style>
.product_category {
	font-size: 12px;
	color: rgba(0, 0, 0, 0.5);
}

.image_list li {
	height: 165px;
	border: solid 1px #e8e8e8;
}

.navbar {
	border-radius: 0;
}

.thumbnail:hover {
	border: 3px solid #0082c8;
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
	<nav class="navbar navbar-inverse role="navigation">
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
	<!--/end-->
	<div class="container">
		<div class="row">

			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6"
				style="border: solid 1px #e8e8e8;">
				<img src="${sanpham.hinh }" alt=""
					style="width: 100%; height: 495px">
			</div>
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
				<div class="product_category">Laptop</div>
				<div class="product_name">
					<h3>
						${sanpham.tensp }
						<h3>
				</div>
				<div class="product_text">
					<ul>
						<li><label>Cpu:</label> <span>${sanpham.cpu }</span></li>
						<li><label>Ram:</label> <span>${sanpham.ram }</span></li>
						<li><label>Ổ cứng:</label> <span>${sanpham.ocung }</span></li>
						<li><label>Màn hình:</label> <span> ${sanpham.manhinh }</span></li>
						<li><label>Hệ điều hành:</label> <span>${sanpham.hedh }</span></li>
					</ul>
				</div>
					<label>${sanpham.dongia }</label><br>
					<a href="addGioHang?masp=${sanpham.masp }"><button class="btn btn-info">ADD TO CARD</button></a>
			</div>
		</div>
	</div>
	<div class="container">
		<h3>Có thể bạn quan tâm?</h3>
		<div id="carousel-id" class="carousel slide" data-ride="carousel"
			style="height: 410px">
			<ol class="carousel-indicators">
				<li data-target="#carousel-id" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-id" data-slide-to="1" class=""></li>
				<li data-target="#carousel-id" data-slide-to="2" class=""></li>
			</ol>
			<div class="carousel-inner">
				<div class="item active" style="height: 400px;">
					<div class="row ">
						<c:forEach var="sp" items="${listSanPham }">
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							<div class="thumbnail">
								<img src="${sp.hinh }" alt="">
								<div class="caption text-center">
									<h3>$ ${sp.dongia }</h3>
									<p>${sp.tensp }</p>
									<p>
										<a href="addGioHang?masp=${sp.masp }" class="btn btn-primary">Chọn mua</a> <a
										href="LoadChiTietSP?masp=${sp.masp }" class="btn btn-default">Chi tiết</a>
									</p>
								</div>
							</div>
						</div>
						</c:forEach>
						
					</div>

				</div>
				<div class="item" style="height: 400px;">
					<div class="row ">
					
						<c:forEach var="sp" items="${listSanPham1 }">
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							<div class="thumbnail">
								<img src="${sp.hinh }" alt="">
								<div class="caption text-center">
									<h3>$ ${sp.dongia }</h3>
									<p>${sp.tensp }</p>
									<p>
										<a href="addGioHang?masp=${sp.masp }" class="btn btn-primary">Chọn mua</a> <a
										href="LoadChiTietSP?masp=${sp.masp }" class="btn btn-default">Chi tiết</a>
									</p>
								</div>
							</div>
						</div>
						</c:forEach>
						

					</div>

				</div>
		</div>
			<a class="left carousel-control" href="#carousel-id"
				data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
			<a style="" class="right carousel-control" href="#carousel-id"
				data-slide="next"><span
				class="glyphicon glyphicon-chevron-right"></span></a>

		</div>
	</div>

</body>
<footer class="page-footer ">
	<!-- Copyright -->
	<div class="footer-copyright container"
		style="background-color: #212529; color: #6c757d; margin-top: 10px">
		<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6"
			style="padding-top: 10px;">
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