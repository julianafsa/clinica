package br.com.dh.clinica.model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="consulta")
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_consulta;
	
	@Column(name = "data")
	private LocalDate data;
	
	@Column(name = "valor")
	private float valor;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "medico")
	private String medico;
	
	@ManyToOne
	@JoinColumn(name = "id_paciente")
	@JsonIgnoreProperties("consultas")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "id_receita")
	@JsonIgnoreProperties("consultas")
	private Receita receita;
	
	@Transient
	private int id_paciente;

	@Transient
	private int id_receita;
	
	public Consulta() {
	}
	
	/**
	 * @param data
	 * @param valor
	 * @param descricao
	 * @param medico
	 * @param paciente
	 * @param receita
	 */
	public Consulta(LocalDate data, float valor, String descricao, String medico, Paciente paciente,
			Receita receita) {
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
		this.medico = medico;
		this.paciente = paciente;
		this.receita = receita;
		this.id_paciente = paciente.getIdPaciente();
		this.id_receita = receita.getId_receita();
	}

	/**
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}
	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	/**
	 * @return the data
	 */
	public LocalDate getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(LocalDate data) {
		this.data = data;
	}
	/**
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the medico
	 */
	public String getMedico() {
		return medico;
	}
	/**
	 * @param medico the medico to set
	 */
	public void setMedico(String medico) {
		this.medico = medico;
	}
	/**
	 * @return the id_consulta
	 */
	public int getId_consulta() {
		return id_consulta;
	}

	/**
	 * @return the receita
	 */
	public Receita getReceita() {
		return receita;
	}

	/**
	 * @param receita the receita to set
	 */
	public void setReceita(Receita receita) {
		this.receita = receita;
	}
	
	/**
	 * @return the id_paciente
	 */
	public int getId_paciente() {
		return id_paciente;
	}

	/**
	 * @param id_paciente the id_paciente to set
	 */
	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}
	
	/**
	 * @return the id_receita
	 */
	public int getId_receita() {
		return id_receita;
	}

	/**
	 * @param id_receita the id_receita to set
	 */
	public void setId_receita(int id_receita) {
		this.id_receita = id_receita;
	}
	
}
