package services;

public class Eletrodomestico extends Produto {
	
	private Double valorAdicionalIPI;

	public Eletrodomestico(String nome, String descricao, Double preco, Double valorAdicionalIPI) {
		super(nome, descricao, preco);
		this.valorAdicionalIPI = valorAdicionalIPI;
	}

	public Double getValorAdicionalIPI() {
		return valorAdicionalIPI;
	}

	public void setValorAdicionalIPI(Double valorAdicionalIPI) {
		this.valorAdicionalIPI = valorAdicionalIPI;
	}
}
