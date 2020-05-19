package com.brianedwards.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Logout {

    @RequestMapping(path="/logout", method={RequestMethod.POST, RequestMethod.GET})
    public String Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        request.logout();
        //request.getSession().invalidate();

        return "redirect:login?logout";
    }
}
