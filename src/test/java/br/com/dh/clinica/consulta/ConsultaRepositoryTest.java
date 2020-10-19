package br.com.dh.clinica.consulta;

import java.time.LocalDate;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dh.clinica.model.entities.Consulta;
import br.com.dh.clinica.model.entities.Paciente;
import br.com.dh.clinica.model.entities.Receita;
import br.com.dh.clinica.model.repositories.ConsultaRepository;
import br.com.dh.clinica.model.repositories.PacienteRepository;
import br.com.dh.clinica.model.repositories.ReceitaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConsultaRepositoryTest {
	
	@Autowired
	ConsultaRepository repository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	ReceitaRepository receitaRepository;

	@Test
	public void verificaIdConsultaNull() {

		LocalDate data = LocalDate.of(2020, 10, 19);
		float valor = 50;
		String descricao = "Primeira consulta";
		String medico = "Doutor Medico 1";
		Paciente paciente = criaPaciente();
		Receita receita = criaReceita();
		
		Consulta consulta = new Consulta(data, valor, descricao, medico, paciente, receita);	
		
		this.repository.save(consulta);
		
		Optional<Consulta> consultaDB = this.repository.findById(consulta.getId_consulta());
		Assertions.assertThat(consultaDB.get().getId_consulta()).isNotNull();
		
	}
	
	@Test
	public void verificaDataConsultaNull() {
		LocalDate data = LocalDate.of(2020, 10, 19);
		float valor = 50;
		String descricao = "Primeira consulta";
		String medico = "Doutor Medico 1";
		Paciente paciente = criaPaciente();
		Receita receita = criaReceita();
		
		Consulta consulta = new Consulta(data, valor, descricao, medico, paciente, receita);	
		
		this.repository.save(consulta);
		
		Optional<Consulta> consultaDB = this.repository.findById(consulta.getId_consulta());
		Assertions.assertThat(consultaDB.get().getData()).isNotNull();

	}
	
	@Test
	public void verificaDescricaoConsultaNull() {
		LocalDate data = LocalDate.of(2020, 10, 19);
		float valor = 50;
		String descricao = "Primeira consulta";
		String medico = "Doutor Medico 1";
		Paciente paciente = criaPaciente();
		Receita receita = criaReceita();
		
		Consulta consulta = new Consulta(data, valor, descricao, medico, paciente, receita);	
		
		this.repository.save(consulta);
		
		Optional<Consulta> consultaDB = this.repository.findById(consulta.getId_consulta());
		Assertions.assertThat(consultaDB.get().getDescricao()).isNotNull();

	}
	
	@Test
	public void verificaMedicoConsultaNull() {
		LocalDate data = LocalDate.of(2020, 10, 19);
		float valor = 50;
		String descricao = "Primeira consulta";
		String medico = "Doutor Medico 1";
		Paciente paciente = criaPaciente();
		Receita receita = criaReceita();
		
		Consulta consulta = new Consulta(data, valor, descricao, medico, paciente, receita);	
		
		this.repository.save(consulta);
		
		Optional<Consulta> consultaDB = this.repository.findById(consulta.getId_consulta());
		Assertions.assertThat(consultaDB.get().getMedico()).isNotNull();

	}
	
	@Test
	public void verificaConsultaDeletada() {
		LocalDate data = LocalDate.of(2020, 10, 19);
		float valor = 50;
		String descricao = "Primeira consulta";
		String medico = "Doutor Medico 1";
		Paciente paciente = criaPaciente();
		Receita receita = criaReceita();
		
		Consulta consulta = new Consulta(data, valor, descricao, medico, paciente, receita);	
		
		this.repository.save(consulta);
		
		this.repository.delete(consulta);

		Optional<Consulta> consultaDB = this.repository.findById(consulta.getId_consulta());
		Assertions.assertThat(consultaDB.isPresent() == false);

	}
	
	@Test
	public void verificaConsultaAtualizada() {
		LocalDate data = LocalDate.of(2020, 10, 19);
		float valor = 50;
		String descricao = "Primeira consulta";
		String medico = "Doutor Medico 1";
		Paciente paciente = criaPaciente();
		Receita receita = criaReceita();
		
		Consulta consulta = new Consulta(data, valor, descricao, medico, paciente, receita);	
		
		this.repository.save(consulta);
		
		consulta.setMedico("Doutor Medico 10");
		
		this.repository.save(consulta);
		
		Optional<Consulta> consultaDB = this.repository.findById(consulta.getId_consulta());
		Assertions.assertThat(consultaDB.get().getMedico()).isEqualTo(consulta.getMedico());
		
	}
	
	public Paciente criaPaciente() {
		String nome = "Maria de Fátima";
		String cpf = "000.000.000-99";
		LocalDate dataNascimento = LocalDate.of(1980, 01, 31);
		LocalDate dataPrimeiraConsulta = LocalDate.now();
		String endereco = "Avenida, A, 1000, Bairro Alegre, 22333-001, São Paulo/SP";
		String telefone = "5511999999999";
		String email = "mariadefatima@gmail.com";
		int peso = 60000; // peso em gramas
		int altura = 160; // altura em centímetros		
		Paciente paciente = new Paciente(nome, cpf, dataNascimento, dataPrimeiraConsulta,
			endereco, telefone, email, peso, altura);
		
		this.pacienteRepository.save(paciente);
		return paciente;
	}
	
	public Receita criaReceita() {
		String descricao = "Pantoprazol 40mg";
		int tempo = 5;
		String dosagem = "1x ao dia em jejum";
		Receita receita = new Receita(descricao, tempo, dosagem);

		this.receitaRepository.save(receita);
		return receita;
	}

}
