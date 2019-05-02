package br.com.kohler.rafael.uteis;

import java.util.ArrayList;

import br.com.kohler.rafael.entity.Empresa;
import br.com.kohler.rafael.entity.NotaFiscal;

/**
 * Classe responsável por excluir uma empresa.
 * @author Rafael Kohler
 *
 */
public class ExcluirEmpresa {

	/**
	 * Método responsável por excluir uma empresa.
	 * @param empresas
	 * @param cnpj
	 * @return A empresa excluida.
	 * @throws Exception
	 */
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
