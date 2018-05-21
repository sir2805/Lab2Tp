<%@ page import="by.nc.school.dev.example.spring.data.web.Pages" %>
<%@ page import="by.nc.school.dev.example.spring.data.service.AppStringsService" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<div class="container">
    <form action="<%=Pages.JOURNAL.ADD_LESSON.PATH_ABSOLUTE%>" method="post" class="form-group">
        <h4 class="form-signin-heading"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.ADD_LESSON.KEY%>"/></h4>
        <div class="row">
            <div class="col-md-8">
                <label for="lesson_name" class="sr-only"><app:app-string key="<%=AppStringsService.WEB.JOURNAL.ADD_LESSON.LESSON.KEY%>"/></label>
                <input type="text" id="lesson_name" name="lesson_name" class="form-control" required/>
            </div>
            <div class="col-md-4">
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    <app:app-string key="<%=AppStringsService.WEB.JOURNAL.ADD_LESSON.BUTTON.KEY%>"/>
                </button>
            </div>
        </div>
    </form>
</div>