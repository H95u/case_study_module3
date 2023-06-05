<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="px-lg-5">
        <header class="banner">
            <div class="row py-5">
                <div class="col-lg-3">
                    <a class="btn btn-primary" style="text-decoration: none; color: white"
                       href="/students?action=create">LOGO</a>
                </div>
                <div class="col-lg-2">
                    <a class="btn btn-primary" style="text-decoration: none; color: white" href="/classes">Loại DV</a>
                </div>
                <div class="col-lg-5">
                    <form action="/students?action=search" method="post">
                        <input type="text" name="search">
                        <button class="btn btn-info" type="submit">Search</button>
                    </form>
                </div>
                <div class="col-lg-1">
                    <a class="btn btn-primary" style="text-decoration: none; color: white" href="/classes">Đăng Nhập</a>
                </div>
                <div class="col-lg-1">
                    <a class="btn btn-primary" style="text-decoration: none; color: white" href="/classes">Đăng Ký</a>
                </div>
            </div>
        </header>

        <div class="row">    <!-- Gallery item -->
            <c:forEach var="p" items="${partnerList}">
                <div class="col-xl-3 col-lg-4 col-md-6 mb-4">
                    <div class="bg-white rounded shadow-sm">
                        <img style="border-radius: 5px" width="300" height="250"
                             src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(p.image)}"/>
                        <div class="p-4">
                            <h5><a href="#" class="text-dark">Blorange</a></h5>
                            <p class="small text-muted mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing
                                elit</p>
                            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
                                <p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span
                                        class="font-weight-bold">PNG</span></p>
                                <div class="badge badge-primary px-3 rounded-pill font-weight-normal">Trend</div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="py-5 text-right"><a href="#" class="btn btn-dark px-5 py-3 text-uppercase">Show me more</a></div>
</div>
</div>
</body>
</html>