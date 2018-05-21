<%@ page import="by.nc.school.dev.example.spring.data.service.AppStringsService" %>
<%@ page import="by.nc.school.dev.example.spring.data.web.controller.SessionAttributes" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><app:app-string key="<%=AppStringsService.WEB.JOURNAL.TITLE.KEY%>"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style.css">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="page">
        <h2><app:app-string key="<%=AppStringsService.WEB.JOURNAL.TITLE.KEY%>"/></h2>
        <div class="row">
            <div class="container">
                <c:forEach var="lessonAndMarks" varStatus="loop" items="${lessonsAndMarks}">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col"> </th>
                                <c:forEach var="lesson" varStatus="loop" items="${lessonsForCourse[loop.index]}">
                                    <th scope="col">${lesson}</th>
                                </c:forEach>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${courses[loop.index].name}</td>
                                <c:forEach var="mark" varStatus="loop" items="${lessonAndMarks}">
                                    <td>${mark}</td>
                                </c:forEach>
                            </tr>
                        </tbody>
                    </table>
                </c:forEach>
            </div>
        </div>
    </div>
</body>