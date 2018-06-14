package model;

public class Grade {
	
	private int codigo;
	
	private int numTamanhoMaximo;
	
	private int numTamanhoMinimo;
	
	private String letra;
	
	private Modelo modelo;

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public int getNumTamanhoMaximo() {
		return numTamanhoMaximo;
	}

	public void setNumTamanhoMaximo(int numTamanhoMaximo) {
		this.numTamanhoMaximo = numTamanhoMaximo;
	}

	public int getNumTamanhoMinimo() {
		return numTamanhoMinimo;
	}

	public void setNumTamanhoMinimo(int numTamanhoMinimo) {
		this.numTamanhoMinimo = numTamanhoMinimo;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
