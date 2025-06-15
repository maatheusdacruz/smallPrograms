package br.vianna.aula.petdog.resource;


import br.vianna.aula.petdog.model.Cachorro;
import br.vianna.aula.petdog.model.Cliente;
import br.vianna.aula.petdog.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/user")
public class UsuarioResource {

    @Autowired
    ClienteService cs;

    @GetMapping("")
    public ResponseEntity<?> getUserLogado(
            UsernamePasswordAuthenticationToken auth){
        return ResponseEntity.ok(auth);
    }
    @GetMapping("/dog")
    public ResponseEntity<?> getUserLogado(){
        Cachorro c = new Cachorro(1,"toto",18,"pinscher",
                100,null);
        return ResponseEntity.ok(c);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<?> getclienteLogado(@PathVariable Integer id){
        try {
            Cliente c = cs.getCliente(id);
            if (c==null){
                return ResponseEntity.status(404).body("Cliente não encontrado!!!");
            }
            return ResponseEntity.ok(c);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).body("Cliente não encontrado!!!");
        }
    }

}
