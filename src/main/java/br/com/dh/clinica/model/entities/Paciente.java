package br.com.dh.clinica.model.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_paciente; // Campo obrigatorio
	private String nome; // Campo obrigatorio
	private String cpf; // Campo obrigatorio
	private LocalDate data_nascimento; // Campo obrigatorio
	private LocalDate data_primeira_consulta; // Campo obrigatorio
	private String endereco;
	private String telefone;
	private String email;
	private int peso; // peso em gramas
	private int altura; // altura em centímetros
	
	/*@OneToMany(mappedBy = "paciente")
	@JsonIgnoreProperties("paciente")
	private Set<Consulta> consultas;*/

	public Paciente() {
	}

	/**
	 * @param nome
	 * @param cpf
	 * @param dataNascimento
	 * @param dataPrimeiraConsulta
	 * @param endereco
	 * @param telefone
	 * @param email
	 * @param peso
	 * @param altura
	 */
	public Paciente(String nome, String cpf, LocalDate dataNascimento, 
			LocalDate dataPrimeiraConsulta, String endereco,
			String telefone, String email, int peso, int altura) {
		this.nome = nome;
		this.cpf = cpf;
		this.data_nascimento = dataNascimento;
		this.data_primeira_consulta = dataPrimeiraConsulta;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.peso = peso;
		this.altura = altura;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the dataNascimento
	 */
	public LocalDate getDataNascimento() {
		return data_nascimento;
	}

	/**
	 * @param data_nascimento the dataNascimento to set
	 */
	public void setDataNascimento(LocalDate nascimento) {
		this.data_nascimento = nascimento;
	}

	/**
	 * @return the dataPrimeiraConsulta
	 */
	public LocalDate getDataPrimeiraConsulta() {
		return data_primeira_consulta;
	}

	/**
	 * @param dataPrimeiraConsulta the dataPrimeiraConsulta to set
	 */
	public void setDataPrimeiraConsulta(LocalDate dataPrimeiraConsulta) {
		this.data_primeira_consulta = dataPrimeiraConsulta;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the peso
	 */
	public int getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}

	/**
	 * @return the altura
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * @param altura the altura to set
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * @return the idPaciente
	 */
	public int getIdPaciente() {
		return id_paciente;
	}

	/**
	 * @return the consultas
	 */
	/*public Set<Consulta> getConsultas() {
		return consultas;
	}*/

	/**
	 * @param consultas the consultas to set
	 */
	/*public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}*/
	
}
