package by.nc.school.dev.example.spring.data.web.provider;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface ModelProvider {

    void  fillModel(Model model, HttpSession session);

}
