package entity;

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
		return this.aliquotaFederal;
	}
	
	public Double calcularImpostoFederal() {
		return 0d;
	}
	
	public abstract Double calcularImpostoEstadual();

}
