package br.vianna.aula.petdog.controller;

import br.vianna.aula.petdog.model.Cliente;
import br.vianna.aula.petdog.model.dto.ClienteListDTO;
import br.vianna.aula.petdog.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService cServ;

    @GetMapping("")
    public String lista(Model model, @RequestParam(required = false) String cpPesq){

        List<ClienteListDTO> clientes = cServ.getClientes(cpPesq);
        model.addAttribute("lista", clientes);
        return "cliente/list";
    }

    @GetMapping("/novo")
    public String novo(Model model){
        Cliente cli = new Cliente();
        cli.setNome("abc");
        model.addAttribute("cliente", cli);
        return "cliente/novo";
    }

    @PostMapping("")
    public String saveCliente(@ModelAttribute Cliente cliente ){

//        System.out.println(cliente.getNome());
        cServ.save(cliente);

        return "redirect:/cliente";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id){

        Cliente cli = cServ.getCliente(id);
        model.addAttribute("cliente", cli);
        return "cliente/novo";
    }

}
