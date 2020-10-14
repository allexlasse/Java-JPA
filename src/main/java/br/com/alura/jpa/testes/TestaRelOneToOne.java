package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

public class TestaRelOneToOne {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta c = new Conta();
		c.setId(1L);
		
		
		Cliente cli = new Cliente("Cliclano", "Dançarino", "Rua das Couves", c);
		

		
		em.getTransaction().begin();
		em.persist(cli);
		em.getTransaction().commit();
		em.close();

	}
}
