package br.com.kohler.rafael.entity;

import java.util.ArrayList;

/**
 * Classe que representa uma empresa
 * @author Rafael Kohler
 *
 */
public class Empresa {

	private String nome;
	
	private String cnpj;
	
	private ArrayList<NotaFiscal> notasFiscais;
	
	private final static Boolean nota = false;

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
			return "Empresa: " + nome + "\nCNPJ: " + cnpj + "\n";
		}
}
