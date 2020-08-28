package com.bcaf.ivan.FinalProject.Controller;

import com.bcaf.ivan.FinalProject.Entity.User;
import com.bcaf.ivan.FinalProject.Util.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @Autowired
    private UserDao userDao;

    @GetMapping
    @RequestMapping({"/profile"})
    public String viewProfile(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(true);
        String userId = (String) session.getAttribute("connectedUser");
        User user = userDao.findById(userId).get();
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("phoneNumber",user.getMobileNumber());
        model.addAttribute("email",user.getEmail());
        return "profile";
    }
}
