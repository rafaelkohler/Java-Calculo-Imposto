package br.com.kohler.rafael.entity;

import java.util.Date;

/**
 * Classe que representa uma Nota Fiscal
 * 
 * @author Rafael Kohler
 *
 */
public class NotaFiscal implements Comparable<NotaFiscal> {

	private String numero;
	
	private String descricao;
	
	private Date dataEmissao;
	
	private Imposto imposto;
	
	private Double valor;
	
	private Double valorComImposto;
	
	private boolean cancelada;

	public NotaFiscal(String numero, String descricao, Imposto imposto, Double valor) {
		this.numero = numero;
		this.descricao = descricao;
		this.imposto = imposto;
		this.valor = valor;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Imposto getImposto() {
		return imposto;
	}

	public void setImposto(Imposto imposto) {
		this.imposto = imposto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorComImposto() {
		return valorComImposto;
	}

	public void setValorComImposto(Double valorComImposto) {
		valorComImposto = imposto.calcularImpostoTotal();
		this.valorComImposto = valorComImposto;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	@Override
		public String toString() {
			return super.toString();
		}

	@Override
	public int compareTo(NotaFiscal notaFiscal) {
		return 0;
	}

}
