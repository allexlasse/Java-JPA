package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraDados {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();
	
	Conta procuraConta = em.find(Conta.class, 1L);
	System.out.println(procuraConta.getTitular());
	
	em.getTransaction().begin();
	procuraConta.setSaldo(100.00);
	em.getTransaction().commit();
}
}
