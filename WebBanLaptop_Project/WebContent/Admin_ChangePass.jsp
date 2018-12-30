<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Quản lí Sản Phẩm</title>
    <link rel="icon" href="images/IMG_Logo_Updated.ico">

    <!--RESPONSIVE-->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--CDN-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <!--VALIDATE JQUERY-->
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>

    <!--OFFLINE
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    -->

    <!--ICONS-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
        crossorigin="anonymous">

    <!--CUSTOM-->
    <link rel="stylesheet" type="text/css" href="Styles_Admin.css">
    <script type="text/javascript" src="Scripts_Admin.js"></script>

    <!--INTERNAL JS-->
    <script>
        /*
        $(document).ready(function () {
                $('a').click(function () {
                    $('a').removeClass("active");
                    $(this).addClass("active");
                });
            });
        */

        //alert('zzz');
    </script>
</head>

<body onload="StartTime()">
    <header>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top" style="min-height: 60px; padding: 0 16px;">
            <div width="15%">
                <a class="navbar-brand" href="Admin.jsp">
                    <img title="PLH Store" src="images/IMG_Company_Blur.png" width="auto" height="48px" class="d-inline-block align-top"
                        alt="IMG_Brand">
                </a>
            </div>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#NavbarCollapse"
                aria-controls="NavbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="NavbarCollapse">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="Admin.html">
                            <h4 style="margin: auto; padding: 0px 10px">Hệ thống Quản trị PLH Store</h4><span class="sr-only">(current)</span>
                        </a>
                    </li>
                </ul>

                <ul class="navbar-nav ml-auto">
                    <!--clock-->
                    <li class="nav-item" style="width: 250px; display: flex; align-items: center;">
                        <i class="far fa-clock"></i>
                        <div id="Clock" style="color: white; margin-left: 3px;"></div>
                    </li>

                    <li class="nav-item dropdown" style="width: 150px;">
                        <div class="btn-group">
                            <button style="border: none;" type="button" class="dropbtn bg-dark btn btn-secondary dropdown-toggle"
                                name="btnNotification" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-bell"></i>
                                Thông báo
                            </button>
                            <div class="dropdown-content dropdown-menu dropdown-menu-right">
                                <button class="dropdown-item" type="button" name="">Không có thông báo</button>
                                <div class="dropdown-divider"></div>
                                <button class="dropdown-item" type="button" name="">xxx</button>
                            </div>
                        </div>
                    </li>

                    <li class="nav-item dropdown" style="width: 150px;">
                        <div class="btn-group">
                            <button style="border: none;" type="button" class="dropbtn bg-dark btn btn-secondary dropdown-toggle"
                                name="btnAccount" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-user"></i>
                                ${TenDangNhap }
                            </button>
                            <div class="dropdown-content dropdown-menu dropdown-menu-right">
                                <button class="dropdown-item" type="button" name="btnChangePassword">Đổi Mật khẩu</button>
                                <button class="dropdown-item" type="button" name="btnEditInfo">Sửa Thông tin</button>
                                <div class="dropdown-divider"></div>
                                <a href="LogoutTK"><button class="dropdown-item" type="button" name="btnSignOut">Đăng xuất</button></a>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <div id="Middle">
        <div id="Left">
            <nav class="nav flex-column">
                <a class="nav-link" href="Admin.jsp">
                    <i class="fas fa-home"></i>
                    Trang chủ
                </a>
                <div class="dropdown">
                    <!--<a class="nav-link dropbtn" data-toggle="collapse" href="#BanHang" aria-expanded="false" aria-controls="BanHang">Bán hàng</a>-->
                    <a class="nav-link dropbtn" data-toggle="" href="#BanHang" aria-expanded="false" aria-controls="BanHang">
                        <i class="fas fa-shopping-cart"></i>
                        Bán hàng
                    </a>
                    <div class="collapse dropdown-content" id="BanHang">
                        <a style="margin-left: 30px;" class="nav-link" href="hoadon">
                            <i class="fas fa-file-invoice-dollar"></i>
                            Đơn hàng
                        </a>
                        <a style="margin-left: 30px;" class="nav-link" href="chitietdonhang">
                            <i class="fas fa-file-invoice"></i>
                            Chi tiết Đơn hàng
                        </a>
                    </div>
                </div>
                <a class="nav-link" href="sanpham">
                    <i class="fas fa-laptop"></i>
                    Sản phẩm
                </a>
                <a class="nav-link" href="khachhang">
                    <i class="fas fa-users"></i>
                    Khách hàng
                </a>
                <a class="nav-link " href="nhanvien">
                    <i class="fas fa-user-tie"></i>
                    Nhân viên
                </a>
                <a class="nav-link disabled" href="nguoidung">
                    <i class="far fa-user"></i>
                    Người dùng
                </a>
            </nav>
        </div>

        <div id="Right">
            <h3><i class="fas fa-user-tie"></i>Đổi Mật Khẩu</h3>
            <hr />

            			<form action="ChangePassTK" method="post">

								<div class="form-group row">
									<label for="MatKhauCu" class="col-sm-2 col-form-label">Mật khẩu cũ</label>
									<div class="col-sm-10">
										<input type="password" class="form-control" id="MatKhauCu"
											name="MatKhauCu" placeholder="">
									</div>
								</div>
								<div class="form-group row">
									<label for="MatKhauMoi" class="col-sm-2 col-form-label">Mật khẩu mới</label>
									<div class="col-sm-10">
										<input type="password" class="form-control" id="MatKhauMoi"
											name="MatKhauMoi" placeholder="">
									</div>
								</div>
								<div class="form-group row">
									<label for="LapLaiMatKhauMoi" class="col-sm-2 col-form-label">Lặp lại mật khẩu mới</label>
									<div class="col-sm-10">
										<input type="password" class="form-control" id="LapLaiMatKhauMoi"
											name="LapLaiMatKhauMoi" placeholder="">
									</div>
								</div>
								<p style="color : ${color}">${thongbao }</p>
								<div class="modal-footer">
									<a href="Admin.jsp"><button type="button" class="btn btn-danger"
										>Hủy</button></a>
									<button type="submit" class="btn btn-primary">Lưu</button>
								</div>
				</form>

 
 	
     </div>
    </div>
	</div>
    <footer class="bg-dark text-white">
        &copy; 2018 PLH Vietnam.
    </footer>
    
		<c:if test="${nhanvien !=null}">
			<script>
				$("#ModalEdit").modal("show");
			</script>
		</c:if>
    <!--EXECUTE SCRIPTS-->
    <script type="text/javascript">
        //newFunction();
        document.getElementById("InputNgayNVAdd").defaultValue = ConvertToDate(new Date());
        //VALIDATE
        /*
        $(document).ready(function() {
 
        $("#formAdd").validate({
            rules: {
                iptSoDT: "required",
                iptEmail: "required",
                iptTenNV: {
                    required: true,
                    minlength: 1
                }
            },
            messages: {
                iptSoDT: "Vui lòng nhập số điện thoại đúng!",
                iptEmail: "Vui lòng nhập email đúng!",
                iptTenNV: {
                    required: "Vui lòng nhập tên!",
                    minlength: "Vui lòng nhập tên dài hơn!"
                }
            }
        });
    });*/

        function newFunction2(){
            $(function() {
		$('#formAdd').validate({
			rules : {
				iptEmail : {
					required : true,
					email : true
				},
				iptTenNV : {
					required : true,
					minlength : 1
				}
			},
			messages : {
				iptEmail : {
					required : "Email không được để trống!",
					email : "Email không đúng định dạng!",
				},
				iptTenNV : {
					required : "Tên không được để trống!",
					minlength : "Tên phải có ít nhất 1 ký tự!"
				}
			},
			submitHandler : function (form) {
				
			}

		});
	})
        }
    </script>
</body>

</html>