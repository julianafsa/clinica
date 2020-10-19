package br.com.dh.clinica.receita;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dh.clinica.model.entities.Receita;
import br.com.dh.clinica.model.repositories.ReceitaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReceitaRepositoryTest {
	
	@Autowired
	ReceitaRepository repository;

	@Test
	public void verificaIdReceitaNull() {

		String descricao = "Pantoprazol 40mg";
		int tempo = 5;
		String dosagem = "1x ao dia em jejum";

		Receita receita = new Receita(descricao, tempo, dosagem);	
		
		this.repository.save(receita);
		
		Optional<Receita> receitaDB = this.repository.findById(receita.getId_receita());
		Assertions.assertThat(receitaDB.get().getId_receita()).isNotNull();
		
	}
	
	@Test
	public void verificaDescricaoReceitaNull() {
		String descricao = "Pantoprazol 40mg";
		int tempo = 5;
		String dosagem = "1x ao dia em jejum";

		Receita receita = new Receita(descricao, tempo, dosagem);	
		
		this.repository.save(receita);
		
		Optional<Receita> receitaDB = this.repository.findById(receita.getId_receita());
		Assertions.assertThat(receitaDB.get().getDescricao()).isNotNull();

	}
	
	@Test
	public void verificaDosagemReceitaNull() {
		String descricao = "Pantoprazol 40mg";
		int tempo = 5;
		String dosagem = "1x ao dia em jejum";

		Receita receita = new Receita(descricao, tempo, dosagem);	
		
		this.repository.save(receita);
		
		Optional<Receita> receitaDB = this.repository.findById(receita.getId_receita());
		Assertions.assertThat(receitaDB.get().getDosagem()).isNotNull();

	}	

	@Test
	public void verificaReceitaDeletada() {
		String descricao = "Pantoprazol 20mg";
		int tempo = 5;
		String dosagem = "1x ao dia em jejum";

		Receita receita = new Receita(descricao, tempo, dosagem);	
		
		this.repository.save(receita);
		
		this.repository.delete(receita);
		
		Optional<Receita> receitaDB = this.repository.findById(receita.getId_receita());

		Assertions.assertThat(receitaDB.isPresent() == false);

	}
	
	@Test
	public void verificaReceitaAtualizada() {
		String descricao = "Pantoprazol 40mg";
		int tempo = 5;
		String dosagem = "1x ao dia em jejum";

		Receita receita = new Receita(descricao, tempo, dosagem);	
		
		this.repository.save(receita);
		
		receita.setDosagem("1x a cada 2 dias em jejum");
		
		this.repository.save(receita);
		
		Optional<Receita> receitaDB = this.repository.findById(receita.getId_receita());
		Assertions.assertThat(receitaDB.get().getDosagem()).isEqualTo(receita.getDosagem());
		
	}

}
