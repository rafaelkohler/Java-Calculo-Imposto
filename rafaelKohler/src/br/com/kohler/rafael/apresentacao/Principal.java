package br.com.kohler.rafael.apresentacao;

import java.util.ArrayList;
import java.util.Collections;

import br.com.kohler.rafael.entity.Empresa;
import br.com.kohler.rafael.entity.NotaFiscal;
import br.com.kohler.rafael.uteis.ConsultaNotaFiscal;
import br.com.kohler.rafael.uteis.ConsultarEmpresa;
import br.com.kohler.rafael.uteis.CriarEmpresa;
import br.com.kohler.rafael.uteis.EmissaoNotas;
import br.com.kohler.rafael.uteis.ExcluirEmpresa;

public class Principal {

	static ArrayList<Empresa> empresas = new ArrayList<>();
	static ArrayList<NotaFiscal> notasFiscais = new ArrayList<>();

	public static void main(String[] args) {

		String[] opcoes = { "Cadastrar empresa", "Pesquisar empresas", "Excluir empresa", "Listar todas as empresas",
				"Emitir nota fiscal", "Listar notas fiscais por empresa",
				"Cancelar nota fiscal" };
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
				try {
					Empresa pesquisada = pesquisarEmpresa();
					System.out.println(pesquisada.toString());
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
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

				
			case 5:
				try {
					Empresa novaEmpresa = pesquisarEmpresa();
					NotaFiscal nf = EmissaoNotas.criarNotaFiscal();
					notasFiscais.add(nf);
					novaEmpresa.addNota(nf);
					empresas.add(novaEmpresa);
					System.out.println(novaEmpresa.toString());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

				
			case 6:
				try {
					Empresa novaEmpresa = pesquisarEmpresa();
					Collections.sort(novaEmpresa.getNotasFiscais());
					System.out.println(novaEmpresa.toString());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

				
			case 7:
				try {
					Empresa cancelarNota = pesquisarEmpresa();
					cancelarNota.getNotasFiscaisCanceladas();
					System.out.println(cancelarNota.toString());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case -1:
				continua = false;
				System.out.println("Saindo do sistema...");
			}
		} while (continua);

	}

	public static Empresa pesquisarEmpresa() throws Exception {
		System.out.println();
		String cnpj = Console.recuperaTexto("Informe o CNPJ da empresa a ser pesquisada");
		Exception e = null;
		Empresa existente = null;
		try {
			existente = ConsultarEmpresa.consultarEmpresas(empresas, cnpj);
		} catch (Exception arg) {
			System.out.println(arg.getMessage());
			e = arg;
		}

		if (existente != null) {
			return existente;
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
						return naoExistente;
					} catch (Exception arg2) {
						System.out.println(arg2.getMessage());
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
		throw e;
	}

	public static NotaFiscal pesquisarNotaFiscal() throws Exception {
		System.out.println();
		String numero = Console.recuperaTexto("Informe o número da nota a ser pesquisada");
		Exception e = null;
		NotaFiscal existente = null;

		try {
			existente = ConsultaNotaFiscal.consultarNotasFiscais(notasFiscais, numero);
		} catch (Exception arg) {
			System.out.println(arg.getMessage());
			e = arg;
		}

		if (existente != null) {
			return existente;
		}
		throw e;
	}
}
