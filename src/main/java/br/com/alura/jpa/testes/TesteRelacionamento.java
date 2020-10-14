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

public class TesteRelacionamento {
public static void main(String[] args) {
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();
	
	Conta c = em.find(Conta.class, 3L);
	
	Categoria c1 = new Categoria("Viagem");
	Categoria c2 = new Categoria("Negocios");
	Movimentacao mov = new Movimentacao(new BigDecimal(500.00),TipoMovimentacao.SAIDA, LocalDateTime.now().plusDays(2), "SP",c, Arrays.asList(c1,c2));
	Movimentacao mov2 = new Movimentacao(new BigDecimal(300.00),TipoMovimentacao.ENTRADA, LocalDateTime.now(), "RJ",c, Arrays.asList(c1,c2));
	
	em.getTransaction().begin();
	em.persist(c1);
	em.persist(c2);
	em.persist(mov);
	em.persist(mov2);
	em.getTransaction().commit();
	em.close();
}
}
