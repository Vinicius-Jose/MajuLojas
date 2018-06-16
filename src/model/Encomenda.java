/**
 * @author Suzana Portilho
 * 
 */


package model;

import java.sql.Date;
import java.util.Iterator;
import java.util.Set;

public class Encomenda {
	
	private int codigo;

	private Date dataEncomenda;

	private Date dataRetirada;

	private float valorTotalEncomenda;

	private Status status;
	
	private Motorista motorista;
	
	private Cliente cliente;
	
	private Set<ItemEncomenda> itemEncomenda;

	public Date getDataEncomenda() {
		return dataEncomenda;
	}

	public void setDataEncomenda(Date dataEncomenda) {
		this.dataEncomenda = dataEncomenda;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public float getValorTotalEncomenda() {
		if(valorTotalEncomenda == 0){
		Iterator<ItemEncomenda> a = itemEncomenda.iterator();
		while(a.hasNext()){
			ItemEncomenda item = a.next();
			valorTotalEncomenda+=item.getValorItemEncomenda();
		}
		}
		return valorTotalEncomenda;
		
	}

	public void setValorTotalEncomenda(float valorTotalEncomenda) {
		this.valorTotalEncomenda = valorTotalEncomenda;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<ItemEncomenda> getItemEncomenda() {
		return itemEncomenda;
	}

	public void setItemEncomenda(Set<ItemEncomenda> itemEncomenda) {
		this.itemEncomenda = itemEncomenda;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
