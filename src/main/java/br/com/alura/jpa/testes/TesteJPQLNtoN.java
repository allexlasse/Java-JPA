package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLNtoN {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		
		Categoria c = new Categoria();
		c.setId(2L);
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class); 																	
		query.setParameter("pCategoria", c); 
		List<Movimentacao> resultList = query.getResultList();

		for (Movimentacao m : resultList) {
			System.out.println("***********************************************************************");
			System.out.println("Categorias: " + m.getCategorias());
			System.out.println("Descrição: " + m.getDescricao());
			System.out.println("Tipo: " + m.getTipoMovimentacao());
			System.out.println("***********************************************************************");
		}
	}
}
