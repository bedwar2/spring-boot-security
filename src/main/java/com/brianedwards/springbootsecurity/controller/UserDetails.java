package com.brianedwards.springbootsecurity.controller;

import com.brianedwards.springbootsecurity.Service.MdpUserDetailsService;
import com.brianedwards.springbootsecurity.model.MdpUserDetails;
import com.brianedwards.springbootsecurity.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserDetails {

    private final MdpUserDetailsService userDetailsService;

    public UserDetails(MdpUserDetailsService mdpUserDetailsService) {
        this.userDetailsService = mdpUserDetailsService;
    }

    @RequestMapping(value ="/userdetails", method = RequestMethod.GET)
    public String getUserDetails(HttpServletRequest request, Model model) {
        String userName = request.getRemoteUser();

        User user = this.userDetailsService.getMDPUserInfo(userName);

        model.addAttribute("userDetails", user);

        return "userdetails";
    }
}
