package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class PopulaMovimentacao {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = em.find(Conta.class, 2L);
		Categoria c1 = new Categoria("Viagem");
		Categoria c2 = new Categoria("Negocios");
		

		
		Movimentacao mov1 = new Movimentacao(new BigDecimal(200.00),TipoMovimentacao.SAIDA, LocalDateTime.now(), "SP",conta, Arrays.asList(c1,c2));
		Movimentacao mov2 = new Movimentacao(new BigDecimal(100.00),TipoMovimentacao.SAIDA, LocalDateTime.now().plusDays(1), "RJ",conta, Arrays.asList(c1,c2));
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(mov1);
		em.persist(mov2);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
