<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Quản lí Người dùng</title>
    <link rel="icon" href="images/IMG_Logo_Updated.ico">

    <!--RESPONSIVE-->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!--CDN-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

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
                        <a class="nav-link" href="Admin.jsp">
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
                                <a href="Admin_ChangePass.jsp"><button class="dropdown-item" type="button" name="btnChangePassword">Đổi mật khẩu</button></a>
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
                        <a style="margin-left: 30px;" class="nav-link" href="chitiethoadon">
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
                <a class="nav-link" href="nhanvien">
                    <i class="fas fa-user-tie"></i>
                    Nhân viên
                </a>
                <a class="nav-link active bg-primary text-white" href="nguoidung">
                    <i class="far fa-user"></i>
                    Người dùng
                </a>
            </nav>
        </div>

        <div id="Right">
            <h3><i class="far fa-user"></i>QUẢN LÍ NGƯỜI DÙNG</h3>
            <hr />

            <div id="Feature">
                <form class="form-inline" autocomplete="on">
                    <div class="input-group mb-2 mr-sm-2">
                        <input type="search" class="border-success form-control" name="iptSearch" placeholder="Nhập thông tin ...">
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
                        <a href="nguoidung"><button class="ml-auto btn btn-success mb-2" type="button" name="btnReload" ><i class="fas fa-sync-alt"></i>Tải
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
                                <th>Tên Người dùng</th>
                                <th>Mật khẩu</th>
                                <th>Admin</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="tk" items="${listTaiKhoan }">
                            <tr>
                                <td>${tk.tendangnhap }</td>
                                <td>${tk.matkhau }</td>
                                <td>${tk.admin }</td>
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
                            <form autocomplete="on" action="InsertTKAdmin" method="post">

                                <div class="form-group row">
                                    <label for="InputTenND" class="col-sm-3 col-form-label">Tên Người dùng</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputTenND" name="iptTenND"
                                            placeholder="Tên Người dùng" autofocus>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputMatKhau" class="col-sm-3 col-form-label">Mật khẩu</label>
                                    <div class="col-sm-9">
                                        <input type="password" class="form-control" id="InputMatKhau" name="iptMatKhau"
                                            placeholder="Mật khẩu">
                                    </div>
                                </div>
						<div class="modal-footer">
                            <button type="submit" class="btn btn-primary" name="btnSaveAdd"><i class="far fa-save"></i>Lưu</button>
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
                            <button type="button" class="close" name="btnCloseEditHeader" data-dismiss="modal">&times;</button>
                        </div>

                        <div class="modal-body">
                            <form autocomplete="on">
                                <div class="form-group row">
                                    <label for="InputMaND" class="col-sm-3 col-form-label">Mã Người dùng</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputMaND" name="iptMaND"
                                            placeholder="Mã Người dùng" readonly>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputTenND" class="col-sm-3 col-form-label">Tên Người dùng</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputTenND" name="iptTenND"
                                            placeholder="Tên Người dùng" autofocus>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputMatKhau" class="col-sm-3 col-form-label">Mật khẩu</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputMatKhau" name="iptMatKhau"
                                            placeholder="Mật khẩu">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputCap" class="col-sm-3 col-form-label">Cấp</label>
                                    <div class="col-sm-9">
                                        <input type="number" class="form-control" id="InputCap" name="iptCap" value="5"
                                            placeholder="Cấp">
                                    </div>
                                </div>
                            </form>
                        </div>

                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary" name="btnSaveEdit"><i class="far fa-save"></i>Lưu</button>
                            <button type="button" class="btn btn-danger" name="btnCancelEdit" data-dismiss="modal"><i
                                    class="far fa-times-circle"></i>Đóng</button>
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
                        </div>

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

    <footer class="bg-dark text-white">
        &copy; 2018 PLH Vietnam.
    </footer>

    <!--EXECUTE SCRIPTS-->
    <script>
        //newFunction();
        //document.getElementById("InputNgayNVAdd").defaultValue = ConvertToDate(new Date());
        //document.getElementById("InputNgayNVEdit").defaultValue = ConvertToDate(new Date());
    </script>
</body>

</html>