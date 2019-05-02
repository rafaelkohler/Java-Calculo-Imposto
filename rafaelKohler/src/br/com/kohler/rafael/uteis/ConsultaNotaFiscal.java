package br.com.kohler.rafael.uteis;

import java.util.ArrayList;

import br.com.kohler.rafael.entity.Empresa;
import br.com.kohler.rafael.entity.NotaFiscal;

/**
 * Classe responsável por consultar uma nota fiscal.
 * @author Rafael Kohler
 *
 */
public class ConsultaNotaFiscal {

	
	/**
	 * Método que consulta uma nota Fiscal.
	 * @param notasFiscais
	 * @param numero
	 * @return A nota consultada.
	 * @throws Exception
	 */
	public static NotaFiscal consultarNotasFiscais(ArrayList<NotaFiscal> notasFiscais, String numero) throws Exception {
		for (int i = 0; i < notasFiscais.size(); i++) {
			if (notasFiscais.get(i).getNumero().equals(numero)) {
				return notasFiscais.get(i);
			}
		}
		throw new Exception("Esta nota fiscal não existe.\n");
	}
	
}
