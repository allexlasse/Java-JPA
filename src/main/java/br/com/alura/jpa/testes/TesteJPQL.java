package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta c = new Conta();
		c.setId(1L);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta"; //Define que a conta terá o valor de um parametro pConta
		
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class); //TypedQuery para especificar tipos de objetos
		query.setParameter("pConta", c); //Define que pConta tem o valor da conta c
		List<Movimentacao> resultList = query.getResultList();
		
		for (Movimentacao m : resultList) {
			System.out.println("Descrição: " + m.getDescricao());
			System.out.println("Tipo: " + m.getTipoMovimentacao());
		}
	}
}
