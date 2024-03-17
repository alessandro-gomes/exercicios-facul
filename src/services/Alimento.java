package services;

public class Alimento extends Produto{

	private String dataValidade;

	public Alimento(String nome, String descricao, Double preco, String dataValidade) {
		super(nome, descricao, preco);
		this.dataValidade = dataValidade;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
}
