package br.com.dh.clinica.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.clinica.model.entities.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Integer> {

	Paciente findOneByNome(String string);
	
	List<Paciente> findByNome(String nome);
	
	Paciente findOneByCpf(String cpf);

}
