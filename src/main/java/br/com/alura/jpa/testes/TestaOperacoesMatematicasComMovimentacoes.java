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
		
		System.out.println("A soma das movimenta��es �: " + ResultSum);
		System.out.println("A media das movimenta��es �: " + String.format("%.2f",resultadoMedia ));
		
		
//		JPQL possui os tipico fun��es de agrega��o do mundo SQL
//		Exemplos s�o SUM, AVG, MIN, MAX ou COUNT
//		JPQL tamb�m possui a cl�usula group by que pode ser usado em combina��o com as fun��es de agrega��o
	}

}
