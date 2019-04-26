package br.com.kohler.rafael.uteis;

import java.util.ArrayList;

import br.com.kohler.rafael.entity.Empresa;

public class ExcluirEmpresa {

	public static Empresa excluirEmpresa(ArrayList<Empresa> empresas, String cnpj) throws Exception {
		Empresa excluir = null;
		
		try {
			excluir = ConsultarEmpresa.consultarEmpresas(empresas, cnpj);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		if (excluir.getNotasFiscaisValidas() == null || excluir.getNotasFiscaisValidas().isEmpty()) {
			empresas.remove(excluir);
			System.out.println("Empresa excluida!\n");
		}
		return null;
	}
}
