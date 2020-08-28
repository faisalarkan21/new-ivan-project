package com.bcaf.ivan.FinalProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping
    @RequestMapping({"/","/index","/dashboard"})
    public String viewDashboard(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        String userId=(String)session.getAttribute("connectedUser");
        System.out.println(userId);
        return "index";
    }
}
