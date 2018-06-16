/**
 * @author Suzana Portilho
 * 
 */



package model;

public class ItemVenda {
	
	private int quantidade;
	
	private float valorTotalPeca;

	private Modelo modelo;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorTotalPeca() {
		if(valorTotalPeca == 0){
			valorTotalPeca*=quantidade;
		}
		return valorTotalPeca;
	}

	public void setValorTotalPeca(float valorTotalPeca) {
		this.valorTotalPeca = valorTotalPeca;
	}
	
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

}
