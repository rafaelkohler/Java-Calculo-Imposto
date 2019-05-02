package br.com.kohler.rafael.entity;

/**
 * Classe que representa Imposto para o estado do Amapa
 * @author Rafael Kohler
 *
 */
public class ImpostoAmapa extends Imposto {

	public ImpostoAmapa(Double valor) {
		super(valor);
	}
	
	/**
	 * Calcula o imposto do estado do Amapa
	 */
	@Override
	public Double calcularImpostoEstadual() {
		return super.valor * 0.215;
	}

}
