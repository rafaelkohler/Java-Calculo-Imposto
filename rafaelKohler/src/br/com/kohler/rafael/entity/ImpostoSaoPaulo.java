package br.com.kohler.rafael.entity;

/**
 * Classe que representa Imposto para o estado de Sao Paulo
 * @author Rafael Kohler
 *
 */
public class ImpostoSaoPaulo extends Imposto {

	public ImpostoSaoPaulo(Double valor) {
		super(valor);
	}
	
	/**
	 * Calcula o imposto do estado de Sao Paulo
	 */
	@Override
	public Double calcularImpostoEstadual() {
		return super.valor * 0.18;
	}

}
