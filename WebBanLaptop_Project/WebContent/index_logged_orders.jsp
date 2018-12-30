<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	

	<!-- Latest compiled and minified CSS & JS -->
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<title>Đơn hàng của tôi</title>
<style>
		.items{
			display: flex;
			justify-content: center;
			align-items: center;
			border: solid 1px #DDDDDD;
			height: 100px;
			padding-left: 0px;
			}

			.icon{
				margin-right: 26px;
			}
			.thumbnail:hover{
			 border: 3px solid #0082c8;
			}
			.thumbnail img{
				height:105px;
				width: 400px;
			}
			.caption{
				height: 170px;

			}

			.thumbnail{
				height: 275px;
			
			}
			.navbar{
			border-radius: 0;
			}
		}

		#maincontent h4{color: #CC0000;}
		.navbar-brand img{height: 35px; padding: 0; margin-top: -7px;}
	</style>

</head>

<body>
<header>
<div class="container">
<div class="row">
    <div class="navbar-header col-lg-4" style="padding-left: 0px">
      		<a class="navbar-brand" href="index.html" title="PLH Store"><img src="images/IMG_Company_Blur.png" alt="IMG_Branch"></img></a>
    </div>
 	<div class="col-lg-4">
   		<form class="navbar-form " action="/action_page.php">
      		<div class="form-group">
       		 	<input type="text" class="form-control" placeholder="Search">
      		</div>
      		<button type="submit" class="btn btn-default">Search</button>
    	</form>
	</div>
	<div class="col-lg-4">
    	<ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> ${TenDangNhap }
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="LoadCTHDTheoTK">Đơn hàng của tôi</a></li>
		  <li><a href="GetKHClient">Thông tin tài khoản</a></li>
		  <li class="divider"></li>
          <li><a href="LogoutTK">Đăng xuất</a></li>
        </ul>
      </li>
    		<li><a href="Cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Giỏ hàng</a></li>
    	</ul>
	</div>
</div>
</div>
</header>

<!-- /start menu -->
	<nav class="navbar navbar-default navbar-inverse" role="navigation">
		<div class="container"style="padding-left: 0px">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
	
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse"style="padding-left: 0px">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index">TRANG CHỦ</a></li>
					<li><a href="gioithieu.html">GIỚI THIỆU</a></li>
					<li><a href="lienhe.html">LIÊN HỆ</a></li>
				</ul>
			</div><!-- /.navbar-collapse -->
		</div>
	</nav>
<!-- /end menu -->
<div class="container">
	<div class="row">
		<ul class="breadcrumb">
			<li><a href="index">Trang chủ</a></li>
			<li><a href="#">Tài khoản</a></li>
			<li class="active"><a href="#">Đơn hàng của tôi</a></li>
		</ul>
	</div>

	<div class="row" style="height: 650px;">
		<!-- /start catalog-->
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="padding-left: 0px">
			<div class="list-group">
				<a href=""class="list-group-item" style="background-color: #44bbb6;"><span class="glyphicon glyphicon-user"></span> Tài khoản</a>
				<a href="GetKHClient"class="list-group-item list-group-item-info"><span class="glyphicon glyphicon-info-sign"></span> Thông tin tài khoản</a>
				<a href="LoadCTHDTheoTK" class="list-group-item list-group-item-info active"><span class="glyphicon glyphicon-list"></span> Đơn hàng của tôi</a>
				<a href="LogoutTK" class="list-group-item list-group-item-info"><span class="glyphicon glyphicon-log-out"></span> Đăng xuất</a>
			</div>
		</div>
		<!-- /end catalog -->

		<!--START ACCOUNTS-->
		<div id="maincontent" class="col-xs-9 col-sm-9 col-md-9 col-lg-9" style="padding-right: 0px;padding-left: 0px;">
			<h4 style="color: #CC0000;"><span class="glyphicon glyphicon-list"></span> Đơn hàng của tôi</h4>
			<hr />
			<c:if test="${thongbao == null }">
			<div class="table-responsive">          
				<table class="table table-hover table-striped">
					<thead>
					<tr>
						<th>Mã đơn hàng</th>
						<th>Ngày mua</th>
						<th>Sản phẩm</th>
						<th>Tổng tiền</th>
					</tr>
					</thead>				
					<tbody>
						<c:forEach var="chtd" items="${listCTHD }">
						<tr>					
							<td>${chtd.mahd }</td>
							<td>${hoadon.ngaylaphd }</td>
							<td>${chtd.layTenSP(chtd.masp) }</td>
							<td>${chtd.thanhtien }</td>					
						</tr>		
						</c:forEach>				
					</tbody>					
				</table>
  			</div>

			<ul class="pagination">
				<li title="Trang Äáº§u"><a href="#"><span>&laquo;</span></a></li>
				<li title="Trang trÆ°á»c"><a href="#"><span>&lsaquo;</span></a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li title="Trang káº¿"><a href="#"><span>&rsaquo;</span></a></li>
				<li title="Trang cuá»i"><a href="#"><span>&raquo;</span></a></li>
			</ul>
			</c:if>
			<c:if test="${thongbao != null }">
			<p>${thongbao }</p>
			</c:if>
		</div>
		<!--END ACCOUNTS-->
	</div>
 </div>			

<footer class="page-footer " >

    <!-- Copyright -->
    <div class="footer-copyright container" style="background-color: #212529;color:  #6c757d;">
    	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6" style="padding-top: 5px;">  		  
    	PLH Store<br>
    	Sá» 1, VÃµ VÄn NgÃ¢n, Linh Chiá»u, Thá»§ Äá»©c, TP Há» ChÃ­ Minh<br>
    	Äiá»n thoáº¡i:0767 767 767<br>
    	Email:plh@gmail.com<br>
    	<p>Copyright Â© (2018) PLH Store</p>
    </div>
    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6" >
    	<nav class="navbar" role="navigation">
    				<ul class="nav navbar-nav" style="float: right;">
    					<li><a href="gioithieu.html">Giá»i thiá»u</a></li>
    					<li style="padding-top: 15px">|</li>
    					<li><a href="lienhe.html">LiÃªn há»</a></li>
    				</ul>
    	</nav>
    	    	
    </div>

    </div>
    <!-- Copyright -->

  </footer>
  </body>
</html>