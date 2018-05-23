<%@ page import="by.nc.school.dev.example.spring.data.service.AppStringsService" %>
<%@ page import="by.nc.school.dev.example.spring.data.web.Pages" %>
<%@ page import="by.nc.school.dev.example.spring.data.web.controller.SessionAttributes" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <div class="put-marks">
        <h2>Course marks</h2>
        <div class="row select-course">
            <div class="col-md-2">
                <form action="<%=Pages.JOURNAL.SELECT_SUBJECT.PATH_ABSOLUTE%>" method="post" class="form-group">
                    <h4 class="form-signin-heading">Select Course</h4>
                            <div class="list-group">
                                <c:forEach var="subject" varStatus="loop" items="${subjects}">
                                    <button type="submit" class="list-group-item list-group-item-action" name = "subjectbutton" value=${subject.id}>
                                            ${subject.name}
                                    </button>
                                    <%--<option>${subject.name}</option>--%>
                                </c:forEach>
                        </div>
                </form>
            </div>
            <div class="col-md-10">
                <%
                    if (session.getAttribute(SessionAttributes.CURRENT_SUBJECT) != null) {
                %>
                <div class="marks">
                    <jsp:include page="add-lesson-form.jsp"/>
                    <c:if test="${not empty lessons}">
                        <jsp:include page="put-mark-form.jsp"/>
                    </c:if>
                </div>
                <h3><app:app-string key="<%=AppStringsService.WEB.JOURNAL.TABLE.TITLE.KEY%>"/> <%=session.getAttribute(SessionAttributes.CURRENT_SUBJECT)%></h3>
                <div class="container">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.TABLE.STUDENTS.KEY%>"/></th>
                            <c:forEach var="lesson" varStatus="loop" items="${lessons}">
                                <th scope="col">${lesson}</th>
                            </c:forEach>
                        </tr>
                        </thead>
                        <c:forEach var="lessonAndMarks" varStatus="loop" items="${lessonsAndMarks}">
                            <tbody>
                            <tr>
                                <th scope="row">${students[loop.index].fullname}</th>
                                <c:forEach var="mark" varStatus="loop" items="${lessonAndMarks}">
                                    <td>${mark}</td>
                                </c:forEach>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</body>