package model;

import java.sql.Date;

public class Modelagem {
	
	private int codigo;
	
	private float valor = 0;
	
	private Date dataModelagem;
	
	private Modelo modelo;
	
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getDataModelagem() {
		return dataModelagem;
	}

	public void setDataModelagem(Date dataModelagem) {
		this.dataModelagem = dataModelagem;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	

	
	

}
