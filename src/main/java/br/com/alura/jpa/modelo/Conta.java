package br.com.alura.jpa.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta {

	public Conta() {
		
	}
	
	public Conta(Integer agencia, Integer numero, String titular, Double saldo) {
		this.agencia = agencia;
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private Integer agencia;
	private Integer numero;
	private String titular;
	private Double saldo;

	@OneToMany(mappedBy = "conta", fetch = FetchType.EAGER)//Carregamento ansioso -> carrega ANTES do carregamento (isso fez algum sentido)
	private List<Movimentacao> movimentacoes;
	
	//Metodos da classe -> Getters e Setters <-
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

}
