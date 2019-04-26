package br.com.kohler.rafael.apresentacao;

import java.util.ArrayList;

import br.com.kohler.rafael.entity.Empresa;
import br.com.kohler.rafael.uteis.ConsultarEmpresa;
import br.com.kohler.rafael.uteis.CriarEmpresa;

public class Principal {

	public static void main(String[] args) throws Exception {
		ArrayList<Empresa> empresas = new ArrayList<>();

		String[] opcoes = { "Cadastrar empresa", "Pesquisar empresas", "Excluir empresa",
				"Emitir nota fiscal", "Cancelar nota fiscal" };
		boolean continua = true;

		do {
			int opcao = Console.mostrarMenu(opcoes, null, null);

			switch (opcao) {
			case 1:
				Empresa nova = CriarEmpresa.criarEmpresa(empresas);
				empresas.add(nova);
				System.out.println("Empresa cadastrada!\n");
				break;

			case 2:
				System.out.println();
				String cnpj = Console.recuperaTexto("Informe o CNPJ da empresa a ser pesquisada");
				Empresa existente = ConsultarEmpresa.consultarEmpresas(empresas, cnpj) ;  
				
				if (existente != null) {
					System.out.println("Esta empresa já existe\n" + existente.toString());
				} else {
					String[] op2 = { "SIM", "NÃO" };

					boolean cont = true;

					do {
						int opEscolha = Console.mostrarMenu(op2, "Você gostaria de cadastrar uma nova empresa?", null);

						switch (opEscolha) {
						case 1:
							Empresa naoExistente = CriarEmpresa.criarEmpresa(empresas);
							empresas.add(naoExistente);
							System.out.println("Empresa cadastrada.");
							
						case 2:
							cont = false;
							System.out.println("Obrigado!");
							break;
							
						case -1:
							cont = false;
							System.out.println("Obrigado!");
							break;
						}
					} while (cont);

				}
				break;
			case -1:
				continua = false;
				System.out.println("Saindo do sistema...");
			}
		} while (continua);

	}
}
