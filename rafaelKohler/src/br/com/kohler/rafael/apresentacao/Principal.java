package br.com.kohler.rafael.apresentacao;

import java.util.ArrayList;
import java.util.Collections;

import br.com.kohler.rafael.entity.Empresa;
import br.com.kohler.rafael.entity.Faturamento;
import br.com.kohler.rafael.entity.NotaFiscal;
import br.com.kohler.rafael.uteis.ConsultaNotaFiscal;
import br.com.kohler.rafael.uteis.ConsultarEmpresa;
import br.com.kohler.rafael.uteis.CriarEmpresa;
import br.com.kohler.rafael.uteis.EmissaoNotas;
import br.com.kohler.rafael.uteis.ExcluirEmpresa;

/**
 * Classe principal do programa.
 * 
 * @author Rafael Kohler
 *
 */
public class Principal {

	static ArrayList<Empresa> empresas = new ArrayList<>();
	static ArrayList<NotaFiscal> notasFiscais = new ArrayList<>();

	public static void main(String[] args) {

		String[] opcoes = { "Cadastrar empresa", "Pesquisar empresas", "Excluir empresa",
				"Relatório de todas as empresas", "Emissão de nota fiscal", "Relatório de notas fiscais por empresa",
				"Relatório de notas fiscais cancelas", "Cancelar nota fiscal", "Total faturado por empresa",
				"Cancelar um lote de notas fiscais" };
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

					try {
						if (cancelar.getValor() <= 10000) {
							cancelar.setCancelada(true);
							System.out.println("Nota: " + cancelar.toString() + "CANCELADA.");
							cancelarNota.getNotasFiscaisCanceladas();
							System.out.println("Total de notas fiscais: " + cancelarNota.toString());
						} else {

						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 9:
				try {
					System.out.println("####    FATURAMENTO TOTAL DA EMPRESA    ####\n");
					Empresa faturamentoEmpresa = pesquisarEmpresa();
					Double faturamento = Faturamento.contabilizarValoresNotas(faturamentoEmpresa.getNotasFiscais());
					System.out.println(faturamentoEmpresa.toString());
					System.out.println("\nEste é o faturamento total da empresa: R$ " + faturamento + "\n\n");

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 10:
				try {
					System.out.println("####    CANCELAR LOTE DE NOTAS    ####\n");
					Empresa emp = pesquisarEmpresa();
					System.out.println("Os valores abaixo do informado, serão canceladas.");
					Double valor = Console.recuperaDecimal("Informe o valor: ");

					ArrayList<NotaFiscal> notas = cancelarLoteNotas(emp.getNotasFiscais(), valor);
					System.out.println("As notas com valor abaixo de R$ " + valor + " foram cancelas.\n\n");
					System.out.println("Estas foram as notas canceladas.\n");
					System.out.println(emp.getNotasFiscaisCanceladas().toString());

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

	/**
	 * Método para pesquisar uma empresa.
	 * 
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * Método para pesquisar uma nota Fiscal
	 * 
	 * @return
	 * @throws Exception
	 */
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

		if (existente.getValor() > 10000) {
			throw new Exception("Não é possível excluir esta nota, ela possui Valor maior que R$ 10.000,00\n\n");
		}

		if (existente != null) {
			return existente;
		}
		throw e;
	}

	public static ArrayList<NotaFiscal> cancelarLoteNotas(ArrayList<NotaFiscal> notas, Double valor) {
		ArrayList<NotaFiscal> auxiliar = new ArrayList<NotaFiscal>();
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getValor() < valor) {
				notas.get(i).setCancelada(true);
			}
		}
		return notas;
	}
}
