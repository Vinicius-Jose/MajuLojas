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
		valorTotalPeca= quantidade * modelo.getMargemCusto();
		return valorTotalPeca;
	}

	public void setValorTotalPeca(float valorTotalPeca) {
		this.valorTotalPeca = valorTotalPeca;
	}
	
	

}
