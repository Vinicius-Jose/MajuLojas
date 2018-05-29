package model;

import java.sql.Date;
import java.util.Iterator;
import java.util.Set;

public class Capital {
	
	private int codigo;
	
	private Date mesAno;
	
	private float valorCapital;
	
	private Set<Modelo> modelo;
	
	private Set<CorteCostura> corteCostura;
	
	private Set<Tecido> tecido;
	

	public Date getMesAno() {
		return mesAno;
	}

	public void setMesAno(Date mesAno) {
		this.mesAno = mesAno;
	}

	public float getValorCapital() {
		Iterator<Modelo> a = modelo.iterator();
		while(a.hasNext()){
			Modelo b = a.next();
			valorCapital+=b.getCustoConfeccao();
		}
		Iterator<CorteCostura> it = corteCostura.iterator();
		while(it.hasNext()){
			CorteCostura c = it.next();
			valorCapital+= (c.getValorCorte() * c.getQuantidadePecasCortadas());
			valorCapital+=(c.getValorCostura()*c.getQuantidadePecasCortadas());
		}
		Iterator<Tecido> itTec = tecido.iterator();
		while(itTec.hasNext()){
			Tecido tec = itTec.next();
			valorCapital+=tec.getValor();
		}
		return valorCapital;
	}

	public void setValorCapital(float valorCapital) {
		this.valorCapital = valorCapital;
	}
	
	public Set<Modelo> getModelo(){
		
		return modelo;
	}

	public void setModelo(Set<Modelo> modelo) {
		
		this.modelo = modelo;
	}
	
	public Set<CorteCostura> getCorteCostura(){
		
		return corteCostura;
	}
	
	public void setCorteCostura (Set<CorteCostura> corteCostura) {
		
		this.corteCostura = corteCostura;
	}

	public Set<Tecido> getTecido() {
		return tecido;
	}

	public void setTecido(Set<Tecido> tecido) {
		this.tecido = tecido;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
