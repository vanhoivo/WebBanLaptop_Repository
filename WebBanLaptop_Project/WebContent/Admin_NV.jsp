<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Quản lí Nhân viên</title>
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
                <a class="nav-link active bg-primary text-white" href="nhanvien">
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
            <h3><i class="fas fa-user-tie"></i>QUẢN LÍ NHÂN VIÊN</h3>
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
                        <button class="ml-auto btn btn-success mb-2" type="button" name="btnReload" data-toggle="modal"
                            data-target="#ModalEdit"><i class="fas fa-sync-alt"></i>Tải
                            lại</button>
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
                                <th>Mã Nhân viên</th>
                                <th>Tên Nhân viên</th>
                                <th>Giới tính</th>
                                <th>Điện thoại</th>
                                <th>Lương cơ bản</th>
                                <th>Phụ cấp</th>
                                <th>Lương Chính thức</th>
                                  <th>  <i title="Xóa Tất cả" class="fas fa-trash-alt"></i></th>
                                   <th> <i title="Tải lại" class="fas fa-edit"></i>
                                </th>
                            </tr>
                        </thead>
                        
                        <tbody>
                        <c:forEach var="nhanvien" items="${listNhanVien }"> 
					         <tr>
                                <td>${nhanvien.manv }</td>
                                <td>${nhanvien.tennv }</td>
                                <td>${nhanvien.gioitinh }
                                <td>${nhanvien.sodienthoai }</td>
                                <td>${nhanvien.luongcb }</td>
                                <td>${nhanvien.phucap }</td>
                                <td>${nhanvien.luongct }</td>
                                <td>
                                	<a href="DeleteNV?manv=${nhanvien.manv }"/><i class="fas fa-trash-alt"></i></a></td>
                                <td>    <a href="GetNV?manv=<c:out value="${nhanvien.manv}" />"><i class="fas fa-edit"></i></a>
                                </td> 
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
                            <form autocomplete="on" action="InsertNV" method="post" id="formAdd">
                                <div class="form-group row">
                                    <label for="InputMaNV" class="col-sm-3 col-form-label">Mã Nhân viên</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputMaNV" name="iptMaNV"
                                            placeholder="Mã Nhân viên" required>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputTenNV" class="col-sm-3 col-form-label">Tên Nhân viên</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputTenNV" name="iptTenNV"
                                            placeholder="Tên Nhân viên" autofocus>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-sm-3">Giới tính</div>
                                    <div class="col-sm-9">
                                        <div class="form-check">
                                            <input type="checkbox" class="form-check-input" id="InputGioiTinh" name="iptGioiTinh"
                                                checked>
                                            <label for="InputGioiTinh" class="form-check-label">
                                                Nữ
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputNgayNVAdd" class="col-sm-3 col-form-label">Ngày Nhận việc</label>
                                    <div class="col-sm-9">
                                        <input type="date" class="form-control DefaultDate" id="InputNgayNVAdd" name="iptNgayNVAdd"
                                            value="2018-09-30" placeholder="Ngày Nhận việc">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputDiaChi" class="col-sm-3 col-form-label">Địa chỉ</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputDiaChi" name="iptDiaChi"
                                            placeholder="Địa chỉ">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputSoDT" class="col-sm-3 col-form-label">Điện thoại</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputSoDT" name="iptSoDT"
                                            placeholder="Điện thoại">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputLuongCB" class="col-sm-3 col-form-label">Lương Cơ bản</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputLuongCB" name="iptLuongCB"
                                            placeholder="Lương Cơ bản">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputPhuCap" class="col-sm-3 col-form-label">Phụ cấp</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputPhuCap" name="iptPhuCap"
                                            placeholder="Phụ cấp">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputLuongCT" class="col-sm-3 col-form-label">Lương Chính thức</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputLuongCT" name="iptLuongCT"
                                            placeholder="Lương Chính thức" disabled>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputHinh" class="col-sm-3 col-form-label">Hình</label>
                                    <div class="col-sm-9">
                                        <div class="input-group">
                                            <div class="custom-file">
                                                <input onchange="ReadFile(this, '#ImageAdd');" type="file" class="custom-file-input"
                                                    id="InputHinh" name="iptHinh">
                                                <label for="InputHinh" class="custom-file-label">Chọn file</label>
                                            </div>
                                            <div class="input-group-append">
                                                <button class="btn btn-outline-secondary" type="button" name="btnUpload">Upload</button>
                                            </div>
                                        </div>
                                        <br />
                                        <div class="border border-primary"><img id="ImageAdd" src="" alt="Image" style="width: 100%; height: auto;" /></div>
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
                            <a href="nhanvien"><button type="button" class="close" name="btnCloseEditHeader" data-dismiss="modal">&times;</button></a>
                        </div>

                        <div class="modal-body">
                            <form autocomplete="on" action="UpdateNV" method="post">
                                <div class="form-group row">
                                    <label for="InputMaNV" class="col-sm-3 col-form-label">Mã Nhân viên</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputMaNV" name="MaNVEdit"
                                            placeholder="Mã Nhân viên" value="${nhanvien.manv }" readonly>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputTenNV" class="col-sm-3 col-form-label">Tên Nhân viên</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputTenNV" name="TenNVEdit"
                                            placeholder="Tên Nhân viên" autofocus value="${nhanvien.tennv }">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-sm-3">Giới tính</div>
                                    <div class="col-sm-9">
                                        <div class="form-check">
                                        	<c:if test="${nhanvien.gioitinh == true }">
                                        	
                                        	
                                            <input type="checkbox" class="form-check-input" id="InputGioiTinh" name="GioiTinhEdit" checked>
                                                 
                                            <label for="InputGioiTinh" class="form-check-label">
                                                Nữ
                                            </label>
                                            </c:if>
                                            <c:if test="${nhanvien.gioitinh == false }">
                                            <input type="checkbox" class="form-check-input" id="InputGioiTinh" name="GioiTinhEdit">
                                                 
                                            <label for="InputGioiTinh" class="form-check-label">
                                                Nữ
                                            </label>
                                            </c:if>
                                            
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputNgayNVEdit" class="col-sm-3 col-form-label">Ngày Nhận việc</label>
                                    <div class="col-sm-9">
                                        <input type="date" class="form-control DefaultDate" id="InputNgayNVEdit" name="NgayNVEdit"
                                            value="${nhanvien.ngaynv }" placeholder="Ngày Nhận việc">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputDiaChi" class="col-sm-3 col-form-label">Địa chỉ</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputDiaChi" name="DiaChiEdit"
                                            placeholder="Địa chỉ" value="${nhanvien.diachi }">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputSoDT" class="col-sm-3 col-form-label">Điện thoại</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputSoDT" name="SoDTEdit"
                                            placeholder="Điện thoại" value="${nhanvien.sodienthoai }">
                                    </div>
                                </div>


                                <div class="form-group row">
                                    <label for="InputLuongCB" class="col-sm-3 col-form-label">Lương Cơ bản</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputLuongCB" name="LuongCBEdit"
                                            placeholder="Lương Cơ bản" value="${nhanvien.luongcb }">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputPhuCap" class="col-sm-3 col-form-label">Phụ cấp</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="InputPhuCap" name="PhuCapEdit"
                                            placeholder="Phụ cấp" value="${nhanvien.phucap }" }>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="InputHinh" class="col-sm-3 col-form-label">Hình</label>
                                    <div class="col-sm-9">
                                        <div class="input-group">
                                            <div class="custom-file">
                                                <input onchange="ReadFile(this, '#ImageEdit');" type="file" class="custom-file-input"
                                                    id="InputHinh" name="iptHinh">
                                                <label for="InputHinh" class="custom-file-label">Chọn file</label>
                                            </div>
                                            <div class="input-group-append">
                                                <button class="btn btn-outline-secondary" type="button" name="btnUpload">Upload</button>
                                            </div>
                                        </div>
                                        <br />
                                        <div class="border border-primary"><img id="ImageEdit" src="" alt="Image" style="width: 100%; height: auto;" /></div>
                                    </div>
                                </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary" name="btnSaveEdit"><i class="far fa-save"></i>Lưu</button>
                            <button type="button" class="btn btn-danger" name="btnCancelEdit" data-dismiss="modal"><i
                                    class="far fa-times-circle"></i>Đóng</button>
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