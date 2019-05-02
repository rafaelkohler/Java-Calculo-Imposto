package br.com.kohler.rafael.uteis;

import java.util.ArrayList;

import br.com.kohler.rafael.apresentacao.Console;
import br.com.kohler.rafael.entity.Empresa;

/**
 * Classe responsável por criar uma empresa.
 * @author Rafael Kohler
 *
 */
public class CriarEmpresa {

	/**
	 * Método que cria uma empresa.
	 * @param empresas
	 * @return A empresa criada.
	 * @throws Exception
	 */
	public static Empresa criarEmpresa(ArrayList<Empresa> empresas) throws Exception {
		String nome = Console.recuperaTexto("Favor informar o nome da Empresa");
		String cnpj = Console.recuperaTexto("Favor informar o seu CNPJ");

		if(cnpj.isEmpty() || cnpj == null || cnpj.length() == 0 || cnpj.length() > 14 || cnpj.length() > 0 && cnpj.length() < 14 ) {
			throw new Exception("Valor do CNPJ incorreto, deve conter 14 números. Favor digitar novamente.\n");
		}
		
		for (int i = 0; i < empresas.size(); i++) {
			if (empresas.get(i).getCnpj().equals(cnpj)) {
				throw new Exception("Esta empresa já existe!\n");
			}
		}
		
		Empresa empresa = new Empresa(nome, cnpj);
		return empresa;
	}
}
