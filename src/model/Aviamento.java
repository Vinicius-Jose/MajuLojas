/**
 * @author Suzana Portilho
 * 
 */


package model;

import java.sql.Date;

public class Aviamento {
	
	private int codigo;
	
	private String nome;
	
	private float valorCompra;
	
	private Date dataCompra;
	
	private Fornecedor fornecedor;

	
	public Aviamento() {
		this.codigo = 0;
		this.nome = "";
		this.valorCompra = 0;
		this.dataCompra = new java.sql.Date(00);
		this.fornecedor = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNome();
	}

}
