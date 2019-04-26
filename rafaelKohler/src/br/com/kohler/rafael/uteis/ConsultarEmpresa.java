package br.com.kohler.rafael.uteis;

import java.util.ArrayList;

import br.com.kohler.rafael.entity.Empresa;

public class ConsultarEmpresa {

	public static Empresa consultarEmpresas(ArrayList<Empresa> empresas, String cnpj) {
		for (int i = 0; i < empresas.size(); i++) {
			if (empresas.get(i).getCnpj().equals(cnpj)) {
				return empresas.get(i);
			}
		}
		return null;
	}
	
}
