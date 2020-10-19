package br.com.dh.clinica.controllers;

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

import br.com.dh.clinica.model.entities.Receita;
import br.com.dh.clinica.model.repositories.ReceitaRepository;

@RestController
@RequestMapping("receita")
public class ReceitaController {
	@Autowired
	private ReceitaRepository repository;
	
	@GetMapping()
	public Iterable<Receita> getReceitas() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Receita> getById(@PathVariable int id) {
		return repository.findById(id);
	}
	
	@PostMapping
	public Receita addReceita(@RequestBody Receita receita) {
		repository.save(receita);
		return receita; 
	}
	
	@DeleteMapping("/{id}")
	public void deleteReceita(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/{idReceita}")
	public Receita updateReceita(@PathVariable int idReceita, 
			@RequestBody Receita dadosReceita) throws IllegalAccessException {
		Receita receitaDB = repository.findById(idReceita).orElseThrow(() -> new IllegalAccessException());
		
		String descricao = dadosReceita.getDescricao();
		if (descricao != null && !descricao.isEmpty()) 
			receitaDB.setDescricao(descricao);
		
		int tempo = dadosReceita.getTempo();
		if (tempo > 0) 
			receitaDB.setTempo(tempo);	
		
		String dosagem = dadosReceita.getDosagem();
		if (dosagem != null && !dosagem.isEmpty()) 
			receitaDB.setDosagem(dosagem);
		
		repository.save(receitaDB);
		
		return dadosReceita;
	}
	
}
