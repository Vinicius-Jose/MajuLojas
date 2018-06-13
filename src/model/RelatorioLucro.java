package model;

import java.sql.Date;
import java.util.Iterator;
import java.util.Set;

public class RelatorioLucro {
	
	private int codigo;
	private Date mesAno;
	
	private float lucroMes;
	
	private Set<Venda> venda;
	
	private Set<Encomenda> encomenda;
	
	private Capital capital;

	public Capital getCapital() {
		return capital;
	}

	public void setCapital(Capital capital) {
		this.capital = capital;
	}

	public Date getMesAno() {
		return mesAno;
	}

	public void setMesAno(Date mesAno) {
		this.mesAno = mesAno;
	}

	public float getLucroMes() {
		if(lucroMes == 0){
	    Iterator<Venda> a = venda.iterator();
	    while(a.hasNext()){
	    	Venda b = a.next();
	    	lucroMes+=b.getValorTotal();
	    }
	    Iterator<Encomenda> c = encomenda.iterator();
	    while(c.hasNext()){
	    	Encomenda encomendas = c.next();
	    	lucroMes+=encomendas.getValorTotalEncomenda();
	    }
	    lucroMes-= capital.getValorCapital();
		}
		return lucroMes;
	}

	public void setLucroMes(float lucroMes) {
		this.lucroMes = lucroMes;
	}
	
	public Set<Venda> getVenda(){
		return venda;
	}
	
	public void setVenda(Set<Venda> venda) {
		this.venda = venda;
	}

	public Set<Encomenda> getEncomenda(){
		return encomenda;
	}
	
	public void setEncomenda(Set<Encomenda> encomenda) {
		this.encomenda = encomenda;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
