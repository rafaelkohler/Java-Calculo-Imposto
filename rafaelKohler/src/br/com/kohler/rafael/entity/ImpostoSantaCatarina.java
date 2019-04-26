package br.com.kohler.rafael.entity;

/**
 * Classe que representa o imposto do Estado de Santa Catarina
 * @author Rafael Kohler
 *
 */
public class ImpostoSantaCatarina extends Imposto {

	public ImpostoSantaCatarina(Double valor) {
		super(valor);
	}
	
	@Override
	public Double calcularImpostoEstadual() {
		return super.valor * 0.10;
	}

}
