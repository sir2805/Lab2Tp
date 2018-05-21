<%@ page import="by.nc.school.dev.example.spring.data.service.AppStringsService" %>
<%@ page import="by.nc.school.dev.example.spring.data.model.Person" %>
<%@ page import="by.nc.school.dev.example.spring.data.web.controller.SessionAttributes" %>
<%@ page import="by.nc.school.dev.example.spring.data.model.Role" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><app:app-string key="<%=AppStringsService.WEB.HOME.TITLE.KEY%>"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style.css">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="container">
    <h2>Welcome <%=((Person)session.getAttribute(SessionAttributes.CURRENT_PERSON)).getFullname()%>!</h2>
    <%
        if (((Person)session.getAttribute(SessionAttributes.CURRENT_PERSON)).getRole() == Role.ADMIN) {
    %>
    <h2><app:app-string key="<%=AppStringsService.WEB.HOME.TITLE.KEY%>"/></h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col"><app:app-string key="<%=AppStringsService.WEB.HOME.TABLE.USER.KEY%>"/></th>
            <th scope="col"><app:app-string key="<%=AppStringsService.WEB.HOME.TABLE.PASSWORD.KEY%>"/></th>
            <th scope="col"><app:app-string key="<%=AppStringsService.WEB.HOME.TABLE.FULLNAME.KEY%>"/></th>
            <th scope="col"><app:app-string key="<%=AppStringsService.WEB.HOME.TABLE.ROLE.KEY%>"/></th>
        </tr>
        </thead>
        <c:forEach var="user" varStatus="loop" items="${users}">
            <tbody>
            <tr>
                <th scope="row">${loop.index+1}</th>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.person.fullname}</td>
                <td>${user.person.role}</td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
    <%
        }
    %>
</div>

</body>
</html>