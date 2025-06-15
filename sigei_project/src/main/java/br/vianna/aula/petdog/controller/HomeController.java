package br.vianna.aula.petdog.controller;


import br.vianna.aula.petdog.config.security.model.UserLogado;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping({"","/home"})
    public String goHome(UsernamePasswordAuthenticationToken auth, Model model){
        System.out.println(auth);
        model.addAttribute("nome",((UserLogado)auth.getPrincipal()).getNome());
        return "principal";
    }

    @GetMapping("atendimento")
    public String goAtendimento(){
        return "atendimento";
    }

    @GetMapping("login")
    public String goLogin(){
        return "login";
    }
//    @GetMapping("/{id}")
//    public String goHome1(@PathVariable int id, Model model){
//        System.out.println(id);
//        model.addAttribute("id",id);
//        return "home1";
//    }
//
//    @GetMapping("/nome")
//    public String goHome1(@RequestParam String nome, Model model){
////        System.out.println(id);
//        model.addAttribute("nome",nome);
//        model.addAttribute("id","01");
//        return "home1";
//    }

}
