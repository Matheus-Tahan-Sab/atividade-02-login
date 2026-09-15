package com.example.Login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecureLoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(
            @RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("cpf") String cpf,
            @RequestParam("senha") String senha,
            @RequestParam("confirmarSenha") String confirmarSenha,
            Model model) {

        
        if (!senha.equals(confirmarSenha)) {
            model.addAttribute("error", "As senhas não coincidem!");
            return "register";
        }

        System.out.println("Usuário registrado com sucesso: " + email);
        return "redirect:/login?registered=true";
    }

    @GetMapping("/recoverpassword")
    public String recoverpassword() {
        return "recoverpassword";
    }

    @PostMapping("/recoverpassword")
    public String handleRecoverPassword(@RequestParam("email") String email) {
        System.out.println("Recuperação solicitada para o e-mail: " + email);
        return "redirect:/login";
    }
}