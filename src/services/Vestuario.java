package services;

public class Vestuario extends Produto{

	private int estoque;

	public Vestuario(String nome, String descricao, Double preco, int estoque) {
		super(nome, descricao, preco);
		this.estoque = estoque;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	
}
