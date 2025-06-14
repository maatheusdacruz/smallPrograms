package com.vianna.sigei.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/")
    public class HomeController {

        @GetMapping({"","/home"})
        public String goHome(UsernamePasswordAuthenticationToken auth, Model model){
//            System.out.println(auth);
//            model.addAttribute("nome",((UserLogado)auth.getPrincipal()).getNome());
            return "principal";
        }


        @GetMapping("/login")
        public String goLogin(){
            return "login";
        }

    }
