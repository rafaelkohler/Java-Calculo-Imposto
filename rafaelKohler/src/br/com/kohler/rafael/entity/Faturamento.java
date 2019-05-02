package br.com.kohler.rafael.entity;

import java.util.ArrayList;

public class Faturamento  {

	public static Double contabilizarValoresNotas (ArrayList<NotaFiscal> notasFiscais) {
		Double soma = 0d;
		for (NotaFiscal notaFiscal : notasFiscais) {
			soma += notaFiscal.getValor();
		}
		return soma;
	}
	
	

}
