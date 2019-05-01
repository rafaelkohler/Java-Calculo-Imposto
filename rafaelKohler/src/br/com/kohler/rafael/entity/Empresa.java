package br.com.kohler.rafael.entity;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.text.MaskFormatter;

/**
 * Classe que representa uma empresa
 * 
 * @author Rafael Kohler
 *
 */
public class Empresa {

	private String nome;

	private String cnpj;

	private ArrayList<NotaFiscal> notasFiscais;

	public Empresa(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.notasFiscais = new ArrayList<NotaFiscal>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMaskCnpjStr(String cnpj) throws ParseException {
		MaskFormatter mf = new MaskFormatter("##.###.###/####-##");
		mf.setValueContainsLiteralCharacters(false);
		return mf.valueToString(cnpj);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void addNota(NotaFiscal nota) {
		notasFiscais.add(nota);
	}
	
	public ArrayList<NotaFiscal> getNotasFiscais() {
		return notasFiscais;
	}


	public ArrayList<NotaFiscal> getNotasFiscaisValidas() {
		ArrayList<NotaFiscal> notasValidas = new ArrayList<>();
		for (NotaFiscal notaFiscal : notasFiscais) {
			notasValidas.add(notaFiscal);
		}
		return notasValidas;
	}

	public ArrayList<NotaFiscal> getNotasFiscaisCanceladas() {
		ArrayList<NotaFiscal> notasCanceladas = new ArrayList<>();
		for (NotaFiscal notaFiscal : notasFiscais) {
			if (notaFiscal.isCancelada()) {
				notasCanceladas.add(notaFiscal);
			}
		}
		return notasCanceladas;
	}


	@Override
	public String toString() {
		try {
			return "\n" + "------------------------------------------------------------------------------------------"
					+ "\nEmpresa: " + nome.toUpperCase() + "\nCNPJ: " + getMaskCnpjStr(cnpj) + "\n\nNotas fiscais: "
					+ this.notasFiscais + "\n"
					+ "------------------------------------------------------------------------------------------" + "\n";
		} catch (ParseException e) {
			return e.getMessage();
		}
	}
}
