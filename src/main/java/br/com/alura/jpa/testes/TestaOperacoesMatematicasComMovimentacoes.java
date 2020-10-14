package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@NamedQuery(name="SumQuery", query="select sum(m.valor) from Movimentacao m")

public class TestaOperacoesMatematicasComMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		//Soma
		String jpql = "select sum(m.valor) from Movimentacao m";		
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal ResultSum = query.getSingleResult();
		
		//Media
		
		String jpqlMedia = "select avg(m.valor) from Movimentacao m";		
		TypedQuery<Double> queryAvg = em.createQuery(jpqlMedia, Double.class);
		Double resultadoMedia = queryAvg.getSingleResult();
		
		System.out.println("A soma das movimentações é: " + ResultSum);
		System.out.println("A media das movimentações é: " + String.format("%.2f",resultadoMedia ));
		
		
//		JPQL possui os tipico funções de agregação do mundo SQL
//		Exemplos são SUM, AVG, MIN, MAX ou COUNT
//		JPQL também possui a cláusula group by que pode ser usado em combinação com as funções de agregação
	}

}
