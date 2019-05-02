package br.com.kohler.rafael.entity;

/**
 * Classe que representa o Imposto do estado do Parana
 * @author Rafael Kohler
 *
 */
public class ImpostoParana extends Imposto {

	public ImpostoParana(Double valor) {
		super(valor);
	}
	
	/**
	 * Calcula o imposto do estado o Parana
	 */
	@Override
	public Double calcularImpostoEstadual() {
		return super.valor * 0.05;
	}

}
