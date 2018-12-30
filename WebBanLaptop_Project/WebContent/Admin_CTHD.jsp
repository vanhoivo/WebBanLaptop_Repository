<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Quản lí Hóa Đơn</title>
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
                                <button class="dropdown-item" type="button" name="">zzz</button>
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
                                <a href="Admin_ChangePass.jsp"><button class="dropdown-item" type="button" name="btnChangePassword">Đổi Mật khẩu</button></a>
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
                    <a class="nav-link dropbtn active bg-primary text-white" data-toggle="" href="#BanHang" aria-expanded="false" aria-controls="BanHang">
                        <i class="fas fa-shopping-cart"></i>
                        Bán hàng
                    </a>
                    <div class="collapse dropdown-content" id="BanHang">
                        <a style="margin-left: 30px;" class="nav-link  " href="hoadon">
                            <i class="fas fa-file-invoice-dollar"></i>
                            Đơn hàng
                        </a>
                        <a style="margin-left: 30px;" class="nav-link active bg-primary text-white" href="chitiethoadon">
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

                <a class="nav-link" href="nguoidung">
                    <i class="far fa-user"></i>
                    Người dùng
                </a>
            </nav>
        </div>

        <div id="Right">
            <h3><i class="fas fa-user-tie"></i>QUẢN LÍ CHI TIẾT HÓA ĐƠN</h3>
            <hr />

            <div id="Feature">
                <form class="form-inline" autocomplete="on" action="/search" method="post">
                    <div class="input-group mb-2 mr-sm-2">
                        <input type="search" class="border-success form-control" name="iptSearch" placeholder="Nhập thông tin ..." required>
                        <div class="input-group-append">
                            <button class="btn btn-success" type="submit" name="btnSearch"><i class="fas fa-search"></i>Tìm
                                kiếm</button>
                        </div>
                    </div>

                    <button class="btn btn-outline-success mb-2" type="button" name="btnAdvanced" data-toggle="collapse"
                        data-target="#CollapseAdvanced" aria-expanded="false" aria-controls="CollapseAdvanced"><i class="fas fa-chevron-circle-down"></i>
                        Nâng cao
                    </button>
 					<div class="ml-auto">
                        <a href="chitiethoadon"><button class="ml-auto btn btn-success mb-2" type="button" name="btnReload">
                            <i class="fas fa-sync-alt"></i>Tải
                            lại</button></a>
                        <button class="ml-auto btn btn-success mb-2" type="button" name="btnAdd" data-toggle="modal"
                            data-target="#ModalAdd"><i class="fas fa-plus-circle"></i>Thêm
                            mới</button>
                    </div>
                    
                </form>
               

                <div class="collapse" id="CollapseAdvanced">
                    <div class="card card-body">
                        zzz
                    </div>
                </div>
            </div>

            <div id="DataView">
                <div class="table-responsive-md">
                    <table class="table table-striped table-hover border border-primary table-bordered">
                        <!--<caption>Tổng số:</caption>-->
                        <thead class="thead-dark">
                            <tr>
                                <th>Mã hóa đơn</th>
								<th>Mã sản phẩm</th>
								<th>Số lượng</th>
								<th>Thành tiền</th>
                                <th>    <i title="Xóa Tất cả" class="fas fa-trash-alt"></i></th>
                                <th>    <i title="Tải lại" class="fas fa-sync-alt"></i>
                                </th>
                            </tr>
                        </thead>
                        
                        <tbody>
                        <c:forEach var="cthd" items="${listCTHD }">
								<tr>
									<td>${cthd.mahd }</td>
									<td>${cthd.masp }</td>
									<td>${cthd.soluong }</td>
									<td>${cthd.thanhtien }</td>

									<td><a href="DeleteCTHD?mahd=${cthd.mahd }?masp=${cthd.masp}"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a href="GetCTHD?mahd=${cthd.mahd }"><i class="fas fa-edit"></i></td></a>
								</tr>
							</c:forEach>
                            
                        </tbody>
                    </table>
                </div>

                <div class="form-inline">
                    <nav>
                        <ul class="pagination">
                            <li class="page-item" title="Trang đầu">
                                <a class="page-link" href="#">
                                    <span>&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item" title="Trang trước">
                                <a class="page-link" href="#">
                                    <span>&lsaquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item" title="Trang kế">
                                <a class="page-link" href="#">
                                    <span>&rsaquo;</span>
                                </a>
                            </li>
                            <li class="page-item" title="Trang cuối">
                                <a class="page-link border rounded-right" href="#">
                                    <span>&raquo;</span>
                                </a>
                            </li>

                            <input type="number" step="1" class="ml-sm-2 form-control" name="iptPage" placeholder="Trang:">
                        </ul>
                    </nav>

                    <div class="form-group form-inline mb-3 ml-auto">
                        <label class="mr-sm-2" for="SelectDisplay">Hiển thị:</label>
                        <select class="form-control" id="SelectDisplay">
                            <option selected>5</option>
                            <option>10</option>
                            <option>20</option>
                            <option>50</option>
                            <option>Tất cả</option>
                        </select>
                    </div>
                </div>
            </div>

            <div id="Explain" class="card">
                <div class="card-body">
                    <i class="fas fa-check-circle"></i>: Chọn
                    <br />
                    <i class="fas fa-trash-alt"></i>: Xóa
                    <br />
                    <i class="fas fa-edit"></i>: Sửa
                </div>
            </div>

            <div class="modal fade" id="ModalAdd">
                <div class="modal-dialog modal-lg modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">THÊM THÔNG TIN</h4>
                            <button type="button" class="close" name="btnCloseAddHeader" data-dismiss="modal">&times;</button>
                        </div>

                        <div class="modal-body">
                            <form autocomplete="on" action="InsertCTHD" method="post" id="formAdd">
                                <div class="form-group row">
                                    <label for="InputMaHD" class="col-sm-3 col-form-label">Mã Hóa Đơn</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputMaHD" name="MaHD"
                                            placeholder="Mã Hóa Đơn" required>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputMaSP" class="col-sm-3 col-form-label">Mã Sản Phẩm</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputMaSP" name="MaSP"
                                            placeholder="Mã Sản Phẩm" autofocus>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="InputSoLuong" class="col-sm-3 col-form-label">Số Lượng</label>
                                    <div class="col-sm-9">
                                        <input type="number" class="form-control" id="InputSoLuong" name="SoLuong"
                                            placeholder="Số Lượng" >
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="InputThanhTien" class="col-sm-3 col-form-label">Thành Tiền</label>
                                    <div class="col-sm-9">
                                        <input type="number" class="form-control" id="InputThanhTien" name="ThanhTien"
                                            placeholder="Thành Tiền" disable>
                                    </div>
                                </div>

                           
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary" name="btnSaveAdd" onclick="newFunction2()"><i class="far fa-save"></i>Lưu</button>
                            <button type="button" class="btn btn-danger" name="btnCancelAdd" data-dismiss="modal"><i
                                    class="far fa-times-circle"></i>Đóng</button>
                        </div>
	                </form>
                        </div>


                    </div>
                </div>
            </div>

            <div class="modal fade" id="ModalEdit">
                <div class="modal-dialog modal-lg modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">SỬA THÔNG TIN</h4>
                            <a href="chitiethoadon"><button type="button" class="close" name="btnCloseEditHeader" >&times;</button></a>
                        </div>

                        <div class="modal-body">
                            <form autocomplete="on" action="UpdateHD" method="post" id="formAdd">
                                <div class="form-group row">
                                    <label for="InputMaHD" class="col-sm-3 col-form-label">Mã Hóa Đơn</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputMaHD" name="MaHD"
                                            placeholder="Mã Hóa Đơn" disable value="${chitiethoadon.mahd }">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputMaSP" class="col-sm-3 col-form-label">Mã Sản Phẩm</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputMaSp" name="MaSP"
                                            placeholder="Mã Sản Phẩm" autofocus value="${chitiethoadon.masp }">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputSoLuong" class="col-sm-3 col-form-label">Số Lượng</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputSoLuong" name="SoLuong"
                                            placeholder="Số Lượng" value="${chitiethoadon.soluong }">
                                    </div>
                                </div>
                               
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary" name="btnSaveAdd" onclick="newFunction2()"><i class="far fa-save"></i>Lưu</button>
                            <a href="chitiethoadon"><button type="button" class="btn btn-danger" name="btnCancelAdd" data-dismiss="modal"><i
                                    class="far fa-times-circle"></i>Đóng</button></a>
                        </div>
	                </form>
                        </div>


                    </div>
                </div>
            </div>
			
            <div class="modal fade" id="ModalDelete">
                <div class="modal-dialog modal-md modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">XÓA THÔNG TIN</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <div class="modal-body">
                            <p>Chắc không?</p>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary" name="btnSaveDelete"><i class="far fa-save"></i>Xóa</button>
                            <button type="button" class="btn btn-danger" name="btnCancelDelete" data-dismiss="modal"><i
                                    class="far fa-times-circle"></i>Hủy</button>
                        </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer class="bg-dark text-white">
        &copy; 2018 PLH Vietnam.
    </footer>
    
		<c:if test="${chitiethoadon !=null}">
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