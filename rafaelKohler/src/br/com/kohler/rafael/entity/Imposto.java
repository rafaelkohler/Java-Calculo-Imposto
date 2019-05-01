package br.com.kohler.rafael.entity;

/** 
 * Classe que representa Impostos
 * @author Rafael Kohler
 *
 */
public abstract class Imposto {
	
	/**
	 * O valor da Aliquota Federal é de 15% do valor da nota.
	 */
	private static Double aliquotaFederal = 0.15;
	
	protected Double valor;
	
	public Imposto(Double valor) {
		this.valor = valor;
	}
	
	public Double calcularImpostoTotal() {
		return calcularImpostoFederal() + calcularImpostoEstadual();
	}
	
	public Double calcularImpostoFederal() {
		return this.valor * aliquotaFederal;
	}
	
	public abstract Double calcularImpostoEstadual();
	
	@Override
	public String toString() {
		return String.valueOf(calcularImpostoTotal());
	}

}
