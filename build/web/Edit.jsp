<%-- 
    Document   : Edit
    Created on : Oct 20, 2020, 5:53:13 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="p" class="dao.DAO" scope="request"></jsp:useBean>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit person</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="row">
                <div class="col-md-3">
                </div>
                <div class="col-md-6">
                    <form action="edit?id=${param.id}" method="post">
                        <h2>Add person</h2>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Full Name</label>
                            <input value="${p.getPersonByid(param.id).name}" name="name" type="text" class="form-control" id="exampleInputEmail1" placeholder="input name">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Date of birth</label>
                            <input value="${p.getPersonByid(param.id).dob}" name="dob" type="text" class="form-control" id="exampleInputEmail1" placeholder="yyyy-MM-dd">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Address</label>
                            <input value="${p.getPersonByid(param.id).address}"  name="address" type="text" class="form-control" id="exampleInputEmail1" placeholder="input address">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Join date</label>
                            <input value="${p.getPersonByid(param.id).joinDate}"  name="join" type="text" class="form-control" id="exampleInputEmail1" placeholder="yyyy-MM-dd">
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <label for="exampleInputEmail1">Gender</label>
                            </div>
                            <div class="form-check col-md-4">
                                <input class="form-check-input" type="radio" name="gender" id="exampleRadios1" value="1" ${p.getPersonByid(param.id).gender==1?"checked":""}>
                                <label class="form-check-label" for="exampleRadios1">
                                    Male
                                </label>
                            </div>
                            <div class="form-check col-md-4">
                                <input class="form-check-input" type="radio" name="gender" id="exampleRadios2" value="0"  ${p.getPersonByid(param.id).gender==0?"checked":""}>
                                <label class="form-check-label" for="exampleRadios2">
                                    Female
                                </label>
                            </div>
                        </div>
                        <div class="row">
                            <label class="col-md-4" for="exampleInputEmail1">Position</label>
                            <select name="pid" class="form-control col-md-7">
                                <c:forEach items="${p.allPosition}" var="o">
                                <option ${p.getPersonByid(param.id).pid==o.pid?"selected":""} value="${o.pid}">${o.pname}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Edit person</button>
                </form>
            </div>
            <div class="col-md-3">
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    </body>
</html>
