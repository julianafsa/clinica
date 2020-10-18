package br.com.dh.clinica.controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import br.com.dh.clinica.model.entities.Consulta;
import br.com.dh.clinica.model.entities.Paciente;
import br.com.dh.clinica.model.repositories.PacienteRepository;

@RestController
@RequestMapping("paciente")
public class PacienteController {
	@Autowired
	private PacienteRepository repository;
	
	@GetMapping()
	public Iterable<Paciente> getPacientes() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Paciente> getById(@PathVariable int id) {
		return repository.findById(id);
	}
	
	@GetMapping("/nome/{nome}")
	public Paciente getByNome(@PathVariable String nome) {
		return repository.findOneByNome(nome);
	}

	@PostMapping
	public Paciente addPaciente(@RequestBody Paciente paciente) {
		System.out.println(paciente.getData_nascimento());
		System.out.println(paciente.getAltura());
		System.out.println(paciente.getCpf());
		System.out.println(paciente.getEmail());
		System.out.println(paciente.getEndereco());
		System.out.println(paciente.getNome());
		System.out.println(paciente.getPeso());
		System.out.println(paciente.getData_primeira_consulta());
		
		repository.save(paciente);
		return paciente; 
	}
	
	@DeleteMapping("/{id}")
	public void deletePaciente(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/{idPaciente}")
	public Paciente updatePaciente(@PathVariable int idPaciente, 
			@RequestBody Paciente dadosPaciente) throws IllegalAccessException {
		Paciente pacienteDB = repository.findById(idPaciente).orElseThrow(() -> new IllegalAccessException());
		
		String nome = dadosPaciente.getNome();
		if (nome != null && !nome.isEmpty()) 
			pacienteDB.setNome(nome);
		
		String cpf = dadosPaciente.getCpf();
		if (cpf != null && !cpf.isEmpty()) 
			pacienteDB.setCpf(cpf);
		
		LocalDate dataNascimento = dadosPaciente.getData_nascimento();
		if (dataNascimento != null) 
			pacienteDB.setData_nascimento(dataNascimento);
		
		LocalDate dataPrimeiraConsulta = dadosPaciente.getData_primeira_consulta();
		if (dataPrimeiraConsulta != null) 
			pacienteDB.setData_primeira_consulta(dataPrimeiraConsulta);
		
		String endereco = dadosPaciente.getEndereco();
		if (endereco != null && !endereco.isEmpty()) 
			pacienteDB.setEndereco(endereco);
		
		String telefone = dadosPaciente.getTelefone();
		if (telefone != null && !telefone.isEmpty()) 
			pacienteDB.setTelefone(telefone);	
		
		String email = dadosPaciente.getEmail();
		if (email != null && !email.isEmpty()) 
			pacienteDB.setEmail(email);
		
		int peso = dadosPaciente.getPeso();
		if (peso > 0) 
			pacienteDB.setPeso(peso);	
		
		int altura = dadosPaciente.getPeso();
		if (altura > 0) 
			pacienteDB.setAltura(altura);

		repository.save(pacienteDB);
		
		return dadosPaciente;
	}
	
}
