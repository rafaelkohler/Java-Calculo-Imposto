package entity;

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
	
	public ArrayList<NotaFiscal> getNotasFiscaisValidas(){
		return null;
	}
	
	public ArrayList<NotaFiscal> getNotasFiscaisCanceladas(){
		return null;
	}
	
	
}
