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
	
	@Override
	public Double calcularImpostoEstadual() {
		return super.valor * 0.05;
	}

}
