package model;

import java.sql.Date;
import java.util.List;

public class Venda {

	private int codigo;

	private float valorTotal;

	private Date dtVenda;

	private List<ItemVenda> item;

	public float getValorTotal() {
		if (valorTotal == 0) {
			for (ItemVenda a : item) {
				valorTotal += a.getValorTotalPeca();
			}
		}
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getDtVenda() {
		return dtVenda;
	}

	public void setDtVenda(Date dtVenda) {
		this.dtVenda = dtVenda;
	}

	public List<ItemVenda> getItemVenda() {
		return item;
	}

	public void setItemVenda(List<ItemVenda> item) {

		this.item = item;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
