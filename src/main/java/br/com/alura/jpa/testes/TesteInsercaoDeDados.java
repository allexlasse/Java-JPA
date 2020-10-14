package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TesteInsercaoDeDados {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();
	
	Conta conta = new Conta();
	conta.setAgencia(001);
	conta.setNumero(1234);
	conta.setTitular("Zé");
	
	em.getTransaction().begin();
	em.persist(conta);
	em.getTransaction().commit();
	emf.close();
	em.close();
}
}
