package br.com.alura.jpa.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@NamedQuery(name="SumQuery", query="select sum(m.valor) from Movimentacao m")
@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;

	private LocalDateTime data;
	private String descricao;

	@ManyToOne
	private Conta conta;

	@ManyToMany
	private List<Categoria> categorias;

	// Construtores

	public Movimentacao() {
	}

	public Movimentacao(BigDecimal valor, TipoMovimentacao tipoMovimentacao, LocalDateTime data, String descricao,
			Conta conta) {
		super();
		this.valor = valor;
		this.tipoMovimentacao = tipoMovimentacao;
		this.data = data;
		this.descricao = descricao;
		this.conta = conta;
	}

	
	
	public Movimentacao(BigDecimal valor, TipoMovimentacao tipoMovimentacao, LocalDateTime data, String descricao,
			Conta conta, List<Categoria> categorias) {
		this.valor = valor;
		this.tipoMovimentacao = tipoMovimentacao;
		this.data = data;
		this.descricao = descricao;
		this.conta = conta;
		this.categorias = categorias;
	}

	// **********Getters e Setters*******************//

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
