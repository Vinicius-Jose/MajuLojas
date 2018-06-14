package model;

import java.sql.Date;

public class Piloto {
	
	private int codigo;
	
	private float valorPiloto = 0;
	
	private Date dataPiloto;
	

	public float getValorPiloto() {
		return valorPiloto;
	}

	public void setValorPiloto(float valorPiloto) {
		this.valorPiloto = valorPiloto;
	}

	public Date getDataPiloto() {
		return dataPiloto;
	}

	public void setDataPiloto(Date dataPiloto) {
		this.dataPiloto = dataPiloto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	

}
