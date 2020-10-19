package br.com.dh.clinica.model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="receita")
public class Receita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_receita;
	
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "tempo")
	private int tempo;
	
	@Column(name = "dosagem")	
	private String dosagem;
	
	@OneToMany(mappedBy = "receita")
	@JsonIgnoreProperties("receita")
	private Set<Consulta> consultas = new HashSet<>();

	public Receita() {
	}
	
	/**
	 * @param id_receita
	 * @param descricao
	 * @param tempo
	 * @param dosagem
	 */
	public Receita(String descricao, int tempo, String dosagem) {
		this.descricao = descricao;
		this.tempo = tempo;
		this.dosagem = dosagem;
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
	/*public void setId_receita(int id_receita) {
		this.id_receita = id_receita;
	}*/

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
	 * @return the tempo
	 */
	public int getTempo() {
		return tempo;
	}

	/**
	 * @param tempo the tempo to set
	 */
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	/**
	 * @return the dosagem
	 */
	public String getDosagem() {
		return dosagem;
	}

	/**
	 * @param dosagem the dosagem to set
	 */
	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}
	
	/**
	 * @return the consultas
	 */
	public Set<Consulta> getConsultas() {
		return consultas;
	}

	/**
	 * @param consultas the consultas to set
	 */
	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}
	
}
