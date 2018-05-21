<%@ page import="by.nc.school.dev.example.spring.data.service.AppStringsService" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<label for="subject"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.SELECT_SUBJECT.KEY%>"/></label>
<select class="form-control" id="subject" name="subject" aria-hidden="true">
    <c:forEach var="subject" varStatus="loop" items="${subjects}">
        <option>${subject.name}</option>
    </c:forEach>
</select>


