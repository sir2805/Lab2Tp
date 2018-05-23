<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="by.nc.school.dev.example.spring.data.service.AppStringsService" %>
<%@ page import="by.nc.school.dev.example.spring.data.web.Pages" %>
<%@ page import="by.nc.school.dev.example.spring.data.web.controller.SessionAttributes" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><app:app-string key="<%=AppStringsService.WEB.LOGIN.TITLE.KEY%>"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/style.css">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <%
        if ((session.getAttribute(SessionAttributes.IS_LOGGED_IN)) != null && !((Boolean) session.getAttribute(SessionAttributes.IS_LOGGED_IN))) {
    %>
    <script>
        alert('Login failed');
    </script>
    <%
        }
    %>
    <form action="<%=Pages.USER.LOGIN.PATH_ABSOLUTE%>" method="post" class="form-signin">
        <h2 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.LOGIN.TITLE.KEY%>"/></h2>
        <label for="username" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.LOGIN.USER.KEY%>"/></label>
        <input type="text" id="username" name="username" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.WEB.LOGIN.USER.KEY%>"/>" required autofocus>
        <label for="password" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.LOGIN.PASSWORD.KEY%>"/></label>
        <input type="password" id="password" name="password" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.WEB.LOGIN.PASSWORD.KEY%>"/>" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <app:app-string key="<%=AppStringsService.WEB.LOGIN.SUBMIT.KEY%>"/>
        </button>
    </form>
</div>
</body>
</html>