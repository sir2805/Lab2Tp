package by.nc.school.dev.example.spring.data.web.controller;

import by.nc.school.dev.example.spring.data.web.Pages;
import by.nc.school.dev.example.spring.data.web.provider.ModelProvider;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(Pages.VIEWS.PATH_ABSOLUTE)
public class ViewController {

    protected Map<String, ModelProvider> modelProviders;

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(Model model) {
        return "redirect:" + Pages.VIEWS.LOGIN.PATH_ABSOLUTE;
    }

    @RequestMapping(method = RequestMethod.GET, path = Pages.VIEWS.HOME.PATH)
    public String getHomePage(Model model, HttpSession session) {
        processRequest(model, session, Pages.VIEWS.HOME.VIEW);
        return Pages.VIEWS.HOME.VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, path = Pages.VIEWS.LOGIN.PATH)
    public String getLoginPage(Model model, HttpSession session) {
        processRequest(model, session, Pages.VIEWS.LOGIN.VIEW);
        return Pages.VIEWS.LOGIN.VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, path = Pages.VIEWS.PUT_MARKS.PATH)
    public String getPutMarksPage(Model model, HttpSession session) {
        processRequest(model, session, Pages.VIEWS.PUT_MARKS.VIEW);
        return Pages.VIEWS.PUT_MARKS.VIEW;
    }

    @RequestMapping(method = RequestMethod.GET, path = Pages.VIEWS.BROWSE_MARKS.PATH)
    public String getBrowseMarksPage(Model model, HttpSession session) {
        processRequest(model, session, Pages.VIEWS.BROWSE_MARKS.VIEW);
        return Pages.VIEWS.BROWSE_MARKS.VIEW;
    }

    protected void processRequest(Model model, HttpSession session, String view) {
        ModelProvider modelProvider = modelProviders.get(view);
        if (modelProvider != null) {
            modelProvider.fillModel(model, session);
        }
    }

    @Required
    public void setModelProviders(Map<String, ModelProvider> modelProviders) {
        this.modelProviders = modelProviders;
    }
}
