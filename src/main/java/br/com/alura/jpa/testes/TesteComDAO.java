package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDAO;
import br.com.alura.jpa.modelo.Movimentacao;


public class TesteComDAO {

	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		//Primeiros testes com criteria
		
//		CriteriaBuilder builder = em.getCriteriaBuilder();
//		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
//		
//		Root<Movimentacao> root = query.from(Movimentacao.class);// 3 - from Movimentacao
//		
//		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));//2 - sum(valor)
//		
//		query.select(sum); //1 - select
//		
//		TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
//				
//		System.out.println("A soma das movimentações é: " + typedQuery.getSingleResult());
		
		MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO(em);
		
		List<Movimentacao> movs = movimentacaoDao.getMovimentacoesPorDia(26, null, null);
		for (Movimentacao movimentacao : movs) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("------------------------------------------");
		}
		

	}

}
