package br.com.kohler.rafael.uteis;

import java.util.ArrayList;

import br.com.kohler.rafael.entity.Empresa;
import br.com.kohler.rafael.entity.NotaFiscal;

public class ExcluirEmpresa {

	public static Empresa excluirEmpresa(ArrayList<Empresa> empresas, String cnpj) throws Exception {
		Empresa excluir = null;

		try {
			excluir = ConsultarEmpresa.consultarEmpresas(empresas, cnpj);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (excluir.getNotasFiscais().isEmpty()
				|| excluir.getNotasFiscaisCanceladas().size() == excluir.getNotasFiscais().size()) {
			empresas.remove(excluir);
		} else {
			throw new Exception("Não foi possível excluir essa empresa. Ela possui Notas Fiscais válidas.\n\n");
		}
		return excluir;
	}
}
