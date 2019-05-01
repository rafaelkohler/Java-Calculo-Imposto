package br.com.kohler.rafael.enumerator;

public enum Estados {

	SC("Santa Catarina", 1), 
	PR("Paraná", 2), 
	SP("São Paulo", 3);

	private String estado;
	private int key;

	private Estados(String estado, int key){
		this.estado = estado;
		this.key = key;
	}

	public String getEstado() {
		return this.estado;
	}

	public Integer getKey() {
		return this.key;
	}

	public static String[] getEstados() {
		String[] estados = new String[Estados.values().length];
		for (int i = 0; i < Estados.values().length; i++) {
			estados[i] = Estados.values()[i].getEstado();
		}
		return estados;
	}

}
