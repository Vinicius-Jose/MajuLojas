package model;

public class ItemEncomenda {

	private int quantidade;

	private float valorItemEncomenda;
	
	private Modelo modelo;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorItemEncomenda() {
		if(valorItemEncomenda == 0){
		valorItemEncomenda = quantidade * modelo.getMargemCusto();
		}
		return valorItemEncomenda;
	}

	public void setValorItemEncomenda(float valorItemEncomenda) {
		this.valorItemEncomenda = valorItemEncomenda;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

}
