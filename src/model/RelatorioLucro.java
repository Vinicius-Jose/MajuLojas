package model;

import java.sql.Date;
import java.util.Iterator;
import java.util.Set;

public class RelatorioLucro {
	
	private Date mesAno;
	
	private float lucroMes;
	
	private Set<Venda> venda1;
	
	private Set<Encomenda> encomenda;
	
	private Capital capital;

	public Date getMesAno() {
		return mesAno;
	}

	public void setMesAno(Date mesAno) {
		this.mesAno = mesAno;
	}

	public float getLucroMes() {
	    Iterator<Venda> a = venda1.iterator();
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
		return lucroMes;
	}

	public void setLucroMes(float lucroMes) {
		this.lucroMes = lucroMes;
	}
	
	public Set<Venda> getVenda(){
		
		return venda1;
	}
	
	public void setVenda1(Set<Venda> venda1) {
		
		this.venda1 = venda1;
	}

	public Set<Encomenda> getEncomenda(){
		
		return encomenda;
	}
	
	public void setVenda(Set<Encomenda> encomenda) {
		
		this.encomenda = encomenda;
	}
}
