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

import br.com.dh.clinica.model.entities.Consulta;
import br.com.dh.clinica.model.entities.Paciente;
import br.com.dh.clinica.model.entities.Receita;
import br.com.dh.clinica.model.repositories.ConsultaRepository;
import br.com.dh.clinica.model.repositories.PacienteRepository;
import br.com.dh.clinica.model.repositories.ReceitaRepository;

@RestController
@RequestMapping("consulta")
public class ConsultaController {
	@Autowired
	private ConsultaRepository repository;

	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping()
	public Iterable<Consulta> getConsultas() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Consulta> getById(@PathVariable int id) {
		return repository.findById(id);
	}
	
	@PostMapping
	public Consulta addConsulta(@RequestBody Consulta consulta) {
		Optional<Receita> receita = receitaRepository.findById(consulta.getId_receita());
		consulta.setReceita(receita.get());
		
		Optional<Paciente> paciente = pacienteRepository.findById(consulta.getId_paciente());
		consulta.setPaciente(paciente.get());
		
		repository.save(consulta);
		return consulta; 
	}
	
	@DeleteMapping("/{id}")
	public void deleteConsulta(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/{idConsulta}")
	public Consulta updatePaciente(@PathVariable int idConsulta, 
			@RequestBody Consulta dadosConsulta) throws IllegalAccessException {
		Consulta pacienteDB = repository.findById(idConsulta).orElseThrow(() -> new IllegalAccessException());
		
		Paciente paciente = dadosConsulta.getPaciente();
		if (paciente != null)
			pacienteDB.setPaciente(paciente);
		
		LocalDate data = dadosConsulta.getData();
		if (data != null) 
			pacienteDB.setData(data);
		
		float valor = dadosConsulta.getValor();
		if (valor >= 0) 
			pacienteDB.setValor(valor);
		
		String descricao = dadosConsulta.getDescricao();
		if (descricao != null && !descricao.isEmpty()) 
			pacienteDB.setDescricao(descricao);	
		
		String medico = dadosConsulta.getMedico();
		if (medico != null && !medico.isEmpty()) 
			pacienteDB.setMedico(medico);
		
		repository.save(pacienteDB);
		
		return dadosConsulta;
	}

}
