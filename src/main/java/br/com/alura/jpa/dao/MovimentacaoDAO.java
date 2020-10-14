package br.com.alura.jpa.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.Movimentacao;

public class MovimentacaoDAO {

	private EntityManager em;

	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}

	public BigDecimal somaDasMovimentacoes() {
		TypedQuery<BigDecimal> query = em.createNamedQuery("SumQuery", BigDecimal.class);
		return query.getSingleResult();
	}

	public Double mediaDasMovimentacoes() {
		String jpqlMedia = "select avg(m.valor) from Movimentacao m";
		TypedQuery<Double> queryAvg = em.createQuery(jpqlMedia, Double.class);
		return queryAvg.getSingleResult();
	}

	public List<Movimentacao> getMovimentacoesPorDia(Integer dia, Integer mes, Integer ano) {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);
		Root<Movimentacao> root = query.from(Movimentacao.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (dia != null) {
			//day(m.data)
			Predicate predicate = builder.equal(builder.function("day", Integer.class, root.get("data")), dia);
			predicates.add(predicate);
		}
		if (dia != null) {
			//day(m.data)
			Predicate predicate = builder.equal(builder.function("month", Integer.class, root.get("data")), mes);
			predicates.add(predicate);
		}
		if (dia != null) {
			//day(m.data)
			Predicate predicate = builder.equal(builder.function("year", Integer.class, root.get("data")), ano);
			predicates.add(predicate);
		}

		query.where((Predicate[]) predicates.toArray(new Predicate[0]));
		
		TypedQuery<Movimentacao> typedQuery = em.createQuery(query);
		return typedQuery.getResultList();
	}

}
