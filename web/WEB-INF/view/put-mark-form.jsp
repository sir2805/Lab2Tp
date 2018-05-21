<%@ page import="by.nc.school.dev.example.spring.data.web.Pages" %>
<%@ page import="by.nc.school.dev.example.spring.data.service.AppStringsService" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="<%=Pages.JOURNAL.PUT_MARK.PATH_ABSOLUTE%>" method="post" class="form-group">
    <h4 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.PUT_MARK.KEY%>"/></h4>
    <div class="row">
        <div class="col-md-4">
            <label for="lesson"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.PUT_MARK.SELECT_LESSON.KEY%>"/></label>
            <select class="form-control" id="lesson" name="lesson" aria-hidden="true">
                <c:forEach var="lesson" varStatus="loop" items="${lessons}">
                    <option>${lesson}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-4">
            <label for="student"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.PUT_MARK.SELECT_STUDENT.KEY%>"/></label>
            <select class="form-control" id="student" name="student" aria-hidden="true">
                <c:forEach var="student" varStatus="loop" items="${students}">
                    <option>${student.fullname}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-2">
            <label for="mark"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.PUT_MARK.SELECT_MARK.KEY%>"/></label>
            <input type="number" step="1" min="0" max="10" id="mark" name="mark" class="form-control" required>

        </div>
        <div class="col-md-2">
            <button class="btn btn-lg btn-primary btn-block" type="submit">
                <app:app-string key="<%=AppStringsService.WEB.JOURNAL.PUT_MARK.BUTTON.KEY%>"/>
            </button>
        </div>

    </div>
</form>