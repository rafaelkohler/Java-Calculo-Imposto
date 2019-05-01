package br.com.kohler.rafael.uteis;

import br.com.kohler.rafael.apresentacao.Console;
import br.com.kohler.rafael.entity.Empresa;
import br.com.kohler.rafael.entity.Imposto;
import br.com.kohler.rafael.entity.ImpostoParana;
import br.com.kohler.rafael.entity.ImpostoSantaCatarina;
import br.com.kohler.rafael.entity.ImpostoSaoPaulo;
import br.com.kohler.rafael.entity.NotaFiscal;
import br.com.kohler.rafael.enumerator.Estados;

public class EmissaoNotas {

	public static NotaFiscal criarNotaFiscal() {
		String numero = Console.recuperaTexto("Informe o número da nota:");
		String descricao = Console.recuperaTexto("Informe a descrição da nota");
		Double valor = Console.recuperaDecimal("Qual o valor da nota");
		Imposto imposto = escolherEstadoImposto(valor);
		return new NotaFiscal(numero, descricao, imposto, valor);
	}

	public static Imposto escolherEstadoImposto(Double valor) {
		System.out.println("Por favor escolha o Estado de emissão da nota: ");
		boolean cont = true;

		do {
			int menuEstados = Console.mostrarMenu(Estados.getEstados(), "Estados", null);

			switch (menuEstados) {
			case 1:
				ImpostoSantaCatarina santaCatarina = new ImpostoSantaCatarina(valor);
				return santaCatarina;

			case 2:
				ImpostoParana parana = new ImpostoParana(valor);
				return parana;

			case 3:
				ImpostoSaoPaulo saoPaulo = new ImpostoSaoPaulo(valor);
				return saoPaulo;

			case -1:
				cont = false;
			}

		} while (cont);

		return null;
	}
}
