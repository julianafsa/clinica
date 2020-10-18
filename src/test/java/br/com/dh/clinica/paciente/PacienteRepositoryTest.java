package br.com.dh.clinica.paciente;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dh.clinica.model.entities.Paciente;
import br.com.dh.clinica.model.repositories.PacienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PacienteRepositoryTest {
	
	@Autowired
	PacienteRepository pacienteRepository;

	@Test
	public void verificaIdPacienteNull() {

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
		
		Paciente pacienteDB = this.pacienteRepository.findOneByCpf(cpf);
		
		Assertions.assertThat(pacienteDB.getIdPaciente()).isNotNull();
	}
	
	@Test
	public void verificaNomePacienteNull() {
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
		
		Paciente pacienteDB = this.pacienteRepository.findOneByCpf(paciente.getCpf());
		
		Assertions.assertThat(pacienteDB.getNome()).isNotNull();
	}

	@Test
	public void verificaDataNascimentoPacienteNull() {
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
		
		Paciente pacienteDB = this.pacienteRepository.findOneByCpf(paciente.getCpf());
		
		Assertions.assertThat(pacienteDB.getData_nascimento()).isNotNull();
	}

	@Test
	public void verificaPacienteDeletado() {
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
		
		this.pacienteRepository.delete(paciente);
		
		Assertions.assertThat(this.pacienteRepository.findOneByCpf(paciente.getCpf())).isNull();
	}
	
	@Test
	public void verificaPacienteAtualizado() {
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
		
		paciente.setNome("Maria de Fátima Silva");
		paciente.setCpf("000.000.000-98");
		
		this.pacienteRepository.save(paciente);
		
		Paciente pacienteAtualizado = 
				this.pacienteRepository.findOneByCpf(paciente.getCpf());
		
		Assertions.assertThat(pacienteAtualizado.getCpf()).isEqualTo(paciente.getCpf());
	}

}
