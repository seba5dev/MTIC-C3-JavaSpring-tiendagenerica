package com.sebas.tiendagenerica.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @GetMapping({ "/", "/login" })
    public String index() {
        return "index";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/usuarios")
    public String usuarios() {
        return "usuarios";
    }

    @RequestMapping("/validar")
    public String validar(HttpServletRequest request, HttpServletResponse response) {
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        if (usuario.equals("admininicial") && contrasena.equals("123456")) {
            return "menu";
        } else {
            return "error";
        }
    }

}
