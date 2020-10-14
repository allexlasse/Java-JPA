package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo{
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();
	
	Conta conta = new Conta();
	conta.setAgencia(002);
	conta.setNumero(1235);
	conta.setTitular("Judas");
	conta.setSaldo(500.00);
	
	em.getTransaction().begin();
	em.persist(conta);
	em.getTransaction().commit();
	emf.close();
	em.close();
}
}
