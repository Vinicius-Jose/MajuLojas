package model;

import java.sql.Date;

public class CorteCostura {
	
	private int codigo;
	
	private Date dataCorte;
	
	private float valorCorte;
	
	private float valorCostura;
	
	private int quantidadePecasCortadas;
	
	private Modelo modelo;
	
	private String letraGrade;

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String getletraGrade() {
		return letraGrade;
	}

	public void setletraGrade(String letraGrade) {
		this.letraGrade = letraGrade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDataCorte() {
		return dataCorte;
	}

	public void setDataCorte(Date dataCorte) {
		this.dataCorte = dataCorte;
	}

	public float getValorCorte() {
		return valorCorte;
	}

	public void setValorCorte(float valorCorte) {
		this.valorCorte = valorCorte;
	}

	public float getValorCostura() {
		return valorCostura;
	}

	public void setValorCostura(float valorCostura) {
		this.valorCostura = valorCostura;
	}

	public int getQuantidadePecasCortadas() {
		return quantidadePecasCortadas;
	}

	public void setQuantidadePecasCortadas(int quantidadePecasCortadas) {
		this.quantidadePecasCortadas = quantidadePecasCortadas;
	}

}
