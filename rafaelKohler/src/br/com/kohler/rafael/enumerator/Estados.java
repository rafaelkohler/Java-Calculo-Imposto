package br.com.kohler.rafael.enumerator;

/**
 * Enum para representar todos os Estados que precisam calcular um imposto.
 * @author Rafael Kohler
 *
 */
public enum Estados {

	SC("Santa Catarina", 1), 
	PR("Paraná", 2), 
	SP("São Paulo", 3),
	AP("Amapá", 4);

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

	/**
	 * Método para selecionar um estado.
	 * @return Um estado.
	 */
	public static String[] getEstados() {
		String[] estados = new String[Estados.values().length];
		for (int i = 0; i < Estados.values().length; i++) {
			estados[i] = Estados.values()[i].getEstado();
		}
		return estados;
	}

}
