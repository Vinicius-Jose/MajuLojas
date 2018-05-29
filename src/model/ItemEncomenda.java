package model;

public class ItemEncomenda {

	private int quantidade;

	private float valorItemEncomenda;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorItemEncomenda() {
		valorItemEncomenda*=quantidade;
		return valorItemEncomenda;
	}

	public void setValorItemEncomenda(float valorItemEncomenda) {
		this.valorItemEncomenda = valorItemEncomenda;
	}

}
