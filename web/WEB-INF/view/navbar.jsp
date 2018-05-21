<%@ page import="by.nc.school.dev.example.spring.data.model.Person" %>
<%@ page import="by.nc.school.dev.example.spring.data.web.controller.SessionAttributes" %>
<%@ page import="by.nc.school.dev.example.spring.data.model.Role" %>
<%@ page import="by.nc.school.dev.example.spring.data.web.Pages" %>
<%@ page import="by.nc.school.dev.example.spring.data.service.AppStringsService" %>
<%@ taglib prefix="app" uri="/WEB-INF/custom.tld"%>
<nav class="navbar navbar-toggleable-md navbar-inverse navbar-fixed-top bg-primary">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <%--<%--%>
                <%--if (((Person)session.getAttribute(SessionAttributes.CURRENT_PERSON)).getRole() == Role.ADMIN) {--%>
            <%--%>--%>
            <%--<li class="nav-item dropdown">--%>
                <%--<a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                    <%--Add--%>
                <%--</a>--%>
                <%--<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">--%>
                    <%--<a class="dropdown-item" href="add-user">Add User</a>--%>
                    <%--<a class="dropdown-item" href="add-group">Add Group</a>--%>
                    <%--<a class="dropdown-item" href="add-work-plan">Add Work plan</a>--%>
                <%--</div>--%>
            <%--</li>--%>
            <%--<%--%>
                <%--}--%>
            <%--%>--%>
            <li class="nav-item active">
                <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
            </li>
            <%--<%--%>
                <%--if (((Person)session.getAttribute(SessionAttributes.CURRENT_PERSON)).getRole() != Role.STUDENT) {--%>
            <%--%>--%>
            <%--<li class="nav-item active">--%>
                <%--<a class="nav-link" href="subject">Subject <span class="sr-only">(current)</span></a>--%>
            <%--</li>--%>
            <%--<%--%>
                <%--}--%>
            <%--%>--%>
            <%
                if (((Person)session.getAttribute(SessionAttributes.CURRENT_PERSON)).getRole() == Role.STUDENT) {
            %>
                <li class="nav-item active">
                    <a class="nav-link" href="browse-marks">Browse Marks <span class="sr-only">(current)</span></a>
                </li>
            <%
                } else if (((Person)session.getAttribute(SessionAttributes.CURRENT_PERSON)).getRole() == Role.TUTOR) {
            %>
            <li class="nav-item active">
                <a class="nav-link" href="put-marks">Put marks <span class="sr-only">(current)</span></a>
            </li>
            <%
                }
            %>
        </ul>
        <form action="<%=Pages.USER.LOGOUT.PATH_ABSOLUTE%>" method="post" class="form-inline my-2 my-lg-0 ml-auto">
            <button class="btn btn-primary btn-block" type="submit">
                <app:app-string key="<%=AppStringsService.WEB.LOGOUT.SUBMIT.KEY%>"/>
            </button>
        </form>
    </div>
</nav>