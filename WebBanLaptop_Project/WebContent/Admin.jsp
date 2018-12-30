<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Trang chủ</title>
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
                <a class="navbar-brand" href="Admin.html">
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
                            <h4 style="margin: auto; padding: 0px 10px">Hệ thống Quản trị PLH Store</h4><span class="sr-only">(current)</span>
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
                                ${TenDangNhap}
                            </button>
                            <div class="dropdown-content dropdown-menu dropdown-menu-right">
                                <a href="Admin_ChangePass.jsp"><button class="dropdown-item" type="button" name="btnChangePassword">Đổi mật khẩu</button></a>
                                <button class="dropdown-item" type="button" name="btnEditInfo">Sửa thông tin</button>
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
                <a class="nav-link active bg-primary text-white" href="Admin.html">
                    <i class="fas fa-home"></i>
                    Trang chủ
                </a>
                <div class="dropdown">
                    <!--<a class="nav-link dropbtn" data-toggle="collapse" href="#BanHang" aria-expanded="false" aria-controls="BanHang">BÃ¡n hÃ ng</a>-->
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
                            Chi tiết đơn hàng
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
                <a class="nav-link" href="Admin_ND.jsp">
                    <i class="far fa-user"></i>
                    Người dùng
                </a>
            </nav>
        </div>

        <div id="Right">
            <h3>Thông tin bán hàng</h3>
            <hr />

            <!--
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce id nunc vel ipsum vulputate iaculis.
                Cras mauris
                enim, varius at suscipit ac, tincidunt ut ligula. Donec et ligula non sem tempus iaculis vitae id
                felis. Sed
                venenatis accumsan mattis. Pellentesque laoreet ipsum id nibh ultricies iaculis. In maximus hendrerit
                bibendum.
                Quisque eget enim elit. Pellentesque lorem nisl, feugiat vestibulum magna vel, hendrerit congue nisi.
                Proin felis
                diam, sollicitudin sed justo vitae, vestibulum tincidunt lorem. Proin in felis eu nulla suscipit
                vehicula et sed
                elit. Donec venenatis felis ex, ac mattis est ornare eget. Proin ornare ante vel tempus sollicitudin.
                Suspendisse
                potenti. Quisque id sodales tortor.

                In nunc leo, interdum id felis id, consectetur luctus lorem. Duis egestas lectus sit amet pulvinar
                ultrices.
                Suspendisse luctus maximus libero ut tristique. Etiam in ipsum rutrum, facilisis ligula vitae, laoreet
                ex. Mauris
                eu varius ex, at tristique odio. Vestibulum dignissim tincidunt sem, ac eleifend sem blandit a. Lorem
                ipsum dolor
                sit amet, consectetur adipiscing elit. Nunc venenatis libero quis elit auctor egestas nec non risus.
                Suspendisse in
                scelerisque felis.

                Praesent quis elit sit amet metus consectetur volutpat eleifend ac ex. Duis vitae ultrices sapien, a
                bibendum
                dolor. Quisque quis semper erat. Donec feugiat sagittis blandit. Morbi tellus ex, lacinia suscipit ante
                ut,
                tincidunt aliquam sapien. Suspendisse potenti. Donec vitae nunc viverra, ultricies metus et, vehicula
                purus. Morbi
                vitae pharetra augue. Donec ullamcorper eros quis augue porttitor, id posuere augue euismod. Mauris
                posuere dui
                neque, eu porttitor lacus feugiat nec. Etiam quam tellus, tristique varius commodo ac, ullamcorper nec
                neque. Nunc
                placerat ultrices purus nec ornare. Nulla sodales dignissim lectus, quis pretium urna ornare a.
                Phasellus
                consectetur leo in aliquam condimentum. Donec eu lectus turpis. Fusce at nulla eget quam tristique
                imperdiet.

                Sed molestie aliquet felis sed tincidunt. Sed et aliquet quam. Praesent porttitor ullamcorper arcu, a
                vestibulum
                felis interdum quis. Quisque justo dolor, malesuada sit amet mollis id, placerat non nunc. Phasellus
                erat dui,
                malesuada quis vulputate at, tempor efficitur ligula. Duis pellentesque nisl sit amet metus venenatis,
                quis tempus
                sem egestas. Ut dapibus accumsan lorem, in finibus magna interdum ac. Proin fringilla pellentesque ex
                nec
                condimentum. Proin fermentum consequat fermentum. Vivamus tristique gravida diam. Duis iaculis metus ut
                velit
                maximus tristique ut in ipsum.

                Proin at scelerisque urna. Pellentesque maximus sit amet augue sed interdum. Aliquam vel mauris congue
                ex ultricies
                laoreet. Ut aliquet, nunc nec placerat pretium, ipsum urna imperdiet quam, ac feugiat lorem lacus id
                quam. Aenean
                sit amet egestas elit. Pellentesque volutpat nulla ante, a faucibus dolor lacinia at. Cras a dolor
                nulla. Curabitur
                rhoncus diam quam, sed sagittis ligula vehicula eu. Sed faucibus gravida dolor ut interdum.

                Etiam fringilla ex diam, ac dapibus leo congue vel. Phasellus euismod id sem eu egestas. Pellentesque
                id nisl
                auctor, dignissim est vitae, ultricies sapien. Aliquam interdum urna nec urna tincidunt, vitae ultrices
                sem rutrum.
                Nulla facilisi. Curabitur eget sem dolor. Maecenas vitae quam augue. Curabitur gravida ipsum ut nisl
                pulvinar
                cursus. Aliquam erat volutpat. Fusce turpis magna, ultrices ut accumsan pulvinar, viverra quis massa.
                Curabitur in
                metus et erat cursus bibendum.

                Praesent libero felis, porttitor vitae felis sed, porta varius magna. In non imperdiet nisl, id
                tincidunt metus.
                Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce velit
                purus,
                feugiat at nulla quis, dignissim tempor est. Vivamus tempor dictum est, at eleifend ipsum dictum eget.
                Curabitur
                accumsan eleifend bibendum. Nam nec tincidunt ex, hendrerit interdum odio. Phasellus varius ornare
                nisl, et
                pulvinar velit sodales eget. Suspendisse scelerisque, diam vitae elementum aliquam, lorem quam
                fermentum felis,
                pretium laoreet dolor leo ac nisl. Aliquam mollis est a ante euismod, vel rutrum nisi consequat.

                In viverra ut erat eu scelerisque. Praesent vitae faucibus enim, nec sodales arcu. Sed scelerisque
                lorem iaculis,
                condimentum est in, sollicitudin massa. Nullam dignissim, libero a faucibus sagittis, odio quam
                pulvinar augue, in
                pellentesque neque nisl sodales mauris. Integer egestas convallis tellus a suscipit. Sed pharetra magna
                erat, eu
                elementum nisi fermentum ac. Nullam sed aliquam neque, sit amet venenatis lorem.

                Etiam maximus rhoncus lorem id lobortis. Ut justo nunc, aliquet commodo varius ut, dignissim sit amet
                dui.
                Curabitur congue tortor ut metus eleifend, eu pulvinar metus tincidunt. Mauris pharetra volutpat augue
                non semper.
                Aenean iaculis mi nunc, ac gravida mi sollicitudin vitae. Quisque dignissim tellus vel lectus molestie,
                ut mattis
                quam cursus. Sed commodo tincidunt arcu, at fermentum dolor pellentesque sed. Aenean bibendum odio eu
                eros viverra,
                in mattis neque ultricies. Integer hendrerit cursus tincidunt. Pellentesque habitant morbi tristique
                senectus et
                netus et malesuada fames ac turpis egestas. Donec gravida sem sed ex dictum, vel imperdiet mauris
                posuere.
                Pellentesque vehicula, justo eu pretium maximus, est nunc tristique arcu, sed congue velit ligula ac
                urna. Maecenas
                eu efficitur diam, at tincidunt erat. Nullam lorem orci, mattis ut ullamcorper et, sodales ut erat. Ut
                mollis, est
                in scelerisque fermentum, libero justo accumsan eros, ac porta velit nisl sed urna.

                Maecenas pretium cursus justo ac consequat. In aliquet sapien vitae rhoncus dictum. Nulla facilisi. In
                eu arcu
                accumsan, feugiat quam sed, mollis libero. Mauris a felis vitae est ullamcorper congue ac ut nisi.
                Suspendisse
                potenti. Maecenas tempus ex pretium, maximus mauris tincidunt, fermentum purus. Duis eu mauris et sem
                congue
                accumsan ac in erat. Cras et risus tortor. Proin pretium dapibus varius. Suspendisse lacinia risus sit
                amet
                fermentum viverra. Sed porta fringilla lacus quis accumsan. Aliquam cursus venenatis est sit amet
                bibendum. Aenean
                quis diam placerat, venenatis augue vitae, ornare leo.
            </p>
            -->
        </div>
    </div>

    <footer class="bg-dark text-white">
        &copy; 2018 PLH Vietnam.
    </footer>

    <!--EXECUTE SCRIPTS-->
    <script>
        //newFunction();
    </script>
</body>

</html>