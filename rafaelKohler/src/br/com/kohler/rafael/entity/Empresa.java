package br.com.kohler.rafael.entity;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.text.MaskFormatter;

/**
 * Classe que representa uma empresa
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
		this.notasFiscais =new ArrayList<NotaFiscal>();
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
	
	public ArrayList<NotaFiscal> getNotasFiscaisValidas(){
		ArrayList<NotaFiscal> notasValidas = new ArrayList<>();
		
		for (int i = 0; i < notasFiscais.size(); i++) {
			if (notasValidas.get(i) == this.notasFiscais.get(i)) {
				notasFiscais.add(notasValidas.get(i));
			}
		}
		return notasFiscais;
	}
	
	public ArrayList<NotaFiscal> getNotasFiscaisCanceladas(){
		ArrayList<NotaFiscal> notasCanceladas = new ArrayList<>();
		return notasCanceladas;
	}
	
	@Override
		public String toString() {
			try {
				return "Empresa: " + nome.toUpperCase() + "\nCNPJ: " + getMaskCnpjStr(cnpj) + "\n";
			} catch (ParseException e) {
				return e.getMessage();
			}
		}
}
