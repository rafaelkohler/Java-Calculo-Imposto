package br.com.kohler.rafael.uteis;

import java.util.ArrayList;

import br.com.kohler.rafael.entity.Empresa;

/**
 * Classe responsável por consultar uma empresa.
 * @author Rafael Kohler
 *
 */
public class ConsultarEmpresa {

	public static Empresa consultarEmpresas(ArrayList<Empresa> empresas, String cnpj) throws Exception {
		for (int i = 0; i < empresas.size(); i++) {
			if (empresas.get(i).getCnpj().equals(cnpj)) {
				return empresas.get(i);
			}
		}
		throw new Exception("Esta empresa não existe.\n");
	}
	
}
