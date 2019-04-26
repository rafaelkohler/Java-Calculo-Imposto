package br.com.kohler.rafael.uteis;

import java.util.ArrayList;

import br.com.kohler.rafael.apresentacao.Console;
import br.com.kohler.rafael.entity.Empresa;

public class CriarEmpresa {

	public static Empresa criarEmpresa(ArrayList<Empresa> empresas) throws Exception {
		String nome = Console.recuperaTexto("Favor informar o nome da Empresa");
		String cnpj = Console.recuperaTexto("Favor informar o seu CNPJ");

		if(cnpj.isEmpty() || cnpj == null || cnpj.length() == 0 || cnpj.length() > 14 || cnpj.length() > 0 && cnpj.length() < 14 ) {
			throw new Exception("CNPJ incorreto. Favor digitar novamente o CNPJ.\n");
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
