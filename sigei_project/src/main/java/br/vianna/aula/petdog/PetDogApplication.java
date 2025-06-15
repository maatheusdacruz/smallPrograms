package br.vianna.aula.petdog;

import br.vianna.aula.petdog.model.Cliente;
import br.vianna.aula.petdog.model.Funcionario;
import br.vianna.aula.petdog.model.repository.ClienteDAO;
import br.vianna.aula.petdog.model.repository.FuncionarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class PetDogApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PetDogApplication.class, args);
	}

	@Autowired
	FuncionarioDAO fDao;

	@Autowired
	PasswordEncoder pass;

	@Autowired
	ClienteDAO cDao;


	@Override
	public void run(String... args) throws Exception {
		System.out.println("### Server Started");

		Cliente cli = new Cliente(0,"Zezin",
				"ze@ze","ze",pass.encode("123"),"7070",null);

		cDao.save(cli);

		Funcionario func = new Funcionario(0,"Pedrin",
				"ped@ped","ped",pass.encode("123"),null);

		fDao.save(func);

		Funcionario func1 = new Funcionario(0,"Administrador da Silva",
				"admin@ped","admin",pass.encode("321"),null);

		fDao.save(func1);

//		Optional<Cliente> c1 = cDao.findById(1);
//		Cliente c2 = c1.get();
//
//		Funcionario f = fDao.findById(1).get();
//
//		System.out.println("Cliente : "+c2.getNome());
//		System.out.println("Funcionário : "+f.getNome());
//
//		Funcionario f1 = fDao.findByNome("Pedrin");
//		System.out.println("Funcionário : "+f1.getNome());

	}
}
