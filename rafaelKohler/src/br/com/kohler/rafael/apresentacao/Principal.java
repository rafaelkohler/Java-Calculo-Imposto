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

		String[] opcoes = { "Cadastrar empresa", "Pesquisar empresas", "Excluir empresa", "Relatório de todas as empresas",
				"Emissão de nota fiscal", "Relatório de notas fiscais por empresa", "Relatório de notas fiscais cancelas", "Cancelar nota fiscal" };
		boolean continua = true;

		do {
			int opcao = Console.mostrarMenu(opcoes, null, null);

			switch (opcao) {
			case 1:
				try {
					System.out.println("####    CADASTRAR UMA NOVA EMPRESA    ####\n");
					Empresa nova = CriarEmpresa.criarEmpresa(empresas);
					empresas.add(nova);
					System.out.println("Empresa cadastrada!\n");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

				
			case 2:
				try {
					System.out.println("####    PESQUISAR EMPRESA    ####");
					Empresa pesquisada = pesquisarEmpresa();
					System.out.println(pesquisada.toString());
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				break;

				
			case 3:
				try {
					System.out.println("####    EXCLUSÃO DE EMPRESA    ####");
					String cnpjExclusao = Console.recuperaTexto("Informe o CNPJ da empresa que deseja excluir");
					Empresa excluida = ExcluirEmpresa.excluirEmpresa(empresas, cnpjExclusao);
					if (excluida != null) {
						System.out.println("Empresa\n" + excluida.toString() + "FOI EXCLUIDA.\n\n");
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

				
			case 4:
				System.out.println("####    RELATÓRIO DE TODAS AS EMPRESAS    ####");
				for (Empresa empresa : empresas) {
					Collections.sort(empresa.getNotasFiscais());
					System.out.println(empresa.toString());
				}
				break;

				
			case 5:
				try {
					System.out.println("####    EMISSÃO DE NOTA FISCAL    ####");
					Empresa novaEmpresa = pesquisarEmpresa();
					NotaFiscal nf = EmissaoNotas.criarNotaFiscal();
					notasFiscais.add(nf);
					novaEmpresa.addNota(nf);
					novaEmpresa.getNotasFiscaisValidas();
					System.out.println(novaEmpresa.toString());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

				
			case 6:
				try {
					System.out.println("####    RELATÓRIO DE NOTAS FISCAIS POR EMPRESA    ####\n");
					Empresa novaEmpresa = pesquisarEmpresa();
					Collections.sort(novaEmpresa.getNotasFiscais());
					System.out.println(novaEmpresa.toString());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

				
			case 7:
				try {
					System.out.println("####    RELATÓRIO DE NOTAS FISCAIS CANCELADAS    ####\n");
					Empresa empNotasCanceladas = pesquisarEmpresa();
					Collections.sort(empNotasCanceladas.getNotasFiscaisCanceladas());
					System.out.println(empNotasCanceladas.getNotasFiscaisCanceladas().toString());
					System.out.println();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				
				
			case 8:
				try {
					System.out.println("####    CANCELAMENTO DE NOTA FISCAL    ####\n");
					Empresa cancelarNota = pesquisarEmpresa();
					System.out.println("Qual nota você gostaria de cancelar?");
					System.out.println(cancelarNota.getNotasFiscais().toString());
					NotaFiscal cancelar = pesquisarNotaFiscal();
					cancelar.setCancelada(true);
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
		String numero = Console.recuperaTexto("Informe o número da nota: ");
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
