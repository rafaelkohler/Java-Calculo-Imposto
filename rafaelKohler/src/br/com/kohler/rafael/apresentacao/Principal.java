package br.com.kohler.rafael.apresentacao;

import java.util.ArrayList;

import br.com.kohler.rafael.entity.Empresa;
import br.com.kohler.rafael.uteis.ConsultarEmpresa;
import br.com.kohler.rafael.uteis.CriarEmpresa;
import br.com.kohler.rafael.uteis.ExcluirEmpresa;

public class Principal {

	public static void main(String[] args) throws Exception {
		ArrayList<Empresa> empresas = new ArrayList<>();

		String[] opcoes = { "Cadastrar empresa", "Pesquisar empresas", "Excluir empresa", "Listar todas as empresas",
				"Emitir nota fiscal", "Cancelar nota fiscal" };
		boolean continua = true;

		do {
			int opcao = Console.mostrarMenu(opcoes, null, null);

			switch (opcao) {
			case 1:
				try {
					Empresa nova = CriarEmpresa.criarEmpresa(empresas);
					empresas.add(nova);
					System.out.println("Empresa cadastrada!\n");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			case 2:
				System.out.println();
				String cnpj = Console.recuperaTexto("Informe o CNPJ da empresa a ser pesquisada");
				
				Empresa existente = null;
				try {
					existente = ConsultarEmpresa.consultarEmpresas(empresas, cnpj);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				if (existente != null) {
					System.out.println("Esta empresa já existe\n" + existente.toString());
				} else {
					String[] op2 = { "SIM", "NÃO" };

					boolean cont = true;

					do {
						int opEscolha = Console.mostrarMenu(op2, "Você gostaria de cadastrar uma nova empresa?", null);

						switch (opEscolha) {
						case 1:
							try {
								Empresa naoExistente = CriarEmpresa.criarEmpresa(empresas);
								empresas.add(naoExistente);
								System.out.println("Empresa cadastrada.\n");
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}

						case 2:
							cont = false;
							break;

						case -1:
							cont = false;
							System.out.println("Obrigado!\n");
							break;
						}
					} while (cont);
				}
				break;

			case 3:
				try {
					String cnpjExclusao = Console.recuperaTexto("Informe o CNPJ da empresa que deseja excluir");
					Empresa excluida = ExcluirEmpresa.excluirEmpresa(empresas, cnpjExclusao);
					if (excluida != null) {
						System.out.println("Empresa\n" + excluida.toString() + "\nFOI EXCLUIDA.");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				for (Empresa empresa : empresas) {
					System.out.println(empresa.toString());
				}
				break;

			case -1:
				continua = false;
				System.out.println("Saindo do sistema...");
			}
		} while (continua);

	}
}
