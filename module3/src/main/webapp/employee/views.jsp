<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/13/2023
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<section style="background-color: #eee;">
    <div class="container py-5">
        <div class="row">
            <div class="col">
                <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><a href="index.jsp">Trang chủ</a></li>
                        <li class="breadcrumb-item"><a href="/employees">Danh sách nhân viên</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Hồ sơ nhân viên</li>
                    </ol>
                </nav>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <div class="card mb-4">
                    <div class="card-body text-center">
                        <img src="${requestScope.employee.image}" alt="avatar"
                             class="rounded-circle img-fluid" style="width: 150px;">
                        <h5 class="my-3">${requestScope.employee.name}</h5>
                        <button class="btn btn-outline-danger" type="button">
                            <span><i class="fa-brands fa-youtube"></i></span><a href="https://www.youtube.com/">Youtube</a><span></span>
                        </button>
                        <button class="btn btn-outline-primary" type="button">
                            <span> <i class="fa-brands fa-facebook"></i></span><a href="https://www.facebook.com/">Facebook</a> <span></span>
                        </button>
                        <button class="btn btn-outline-danger" type="button">
                            <span> <i class="fa-brands fa-instagram"></i> </span><a href="https://www.instagram.com/">instagram</a> <span></span>
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">ID :</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${requestScope.employee.id}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Mã NV :</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${requestScope.employee.code}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Full Name :</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${requestScope.employee.name}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Năm sinh :</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${requestScope.employee.date}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Địa chỉ :</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${requestScope.employee.address}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Email :</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${requestScope.employee.email}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">SĐT :</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${requestScope.employee.phone}</p>
                            </div>
                        </div>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>

