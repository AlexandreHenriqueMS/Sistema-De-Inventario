package br.com.sistemaDeInventario.model.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Order implements Serializable{

	private static final long serialVersionUID = -8087299275695936741L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoTombamento;
	@Column(nullable = false)
	private Instant dataTombamento;
	@Column(nullable = false)
	private Integer quantidade;
	@Column(nullable = false)
	private String cliente;
	private String cep;
	@Column(nullable = false)
	private String nota;
	@Column(nullable = false)
	private Instant ultimaMovimentacao;
	@Column(nullable = false)
	private String tipo;
	@Column(nullable = false)
	private String marca;
	@Column(nullable = false)
	private String modelo;

	public Order() {
	}

	public Order(Long codigoTombamento, Instant dataTombamento, Integer quantidade, String cliente, String cep,
			String nota, Instant ultimaMovimentacao, String tipo, String marca, String modelo) {
		this.codigoTombamento = codigoTombamento;
		this.dataTombamento = dataTombamento;
		this.quantidade = quantidade;
		this.setCliente(cliente);
		this.cep = cep;
		this.nota = nota;
		this.ultimaMovimentacao = ultimaMovimentacao;
		this.setTipo(tipo);
		this.setMarca(marca);
		this.setModelo(modelo);
	}

	public Long getCodigoTombamento() {
		return codigoTombamento;
	}

	public void setCodigoTombamento(Long codigoTombamento) {
		this.codigoTombamento = codigoTombamento;
	}

	public Instant getDataTombamento() {
		return dataTombamento;
	}

	public void setDataTombamento(Instant dataTombamento) {
		this.dataTombamento = dataTombamento;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente.toUpperCase();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Instant getUltimaMovimentacao() {
		return ultimaMovimentacao;
	}

	public void setUltimaMovimentacao(Instant ultimaMovimentacao) {
		this.ultimaMovimentacao = ultimaMovimentacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo.toUpperCase();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca.toUpperCase();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo.toUpperCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoTombamento == null) ? 0 : codigoTombamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (codigoTombamento == null) {
			if (other.codigoTombamento != null)
				return false;
		} else if (!codigoTombamento.equals(other.codigoTombamento))
			return false;
		return true;
	}

}
