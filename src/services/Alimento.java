package services;

import java.util.Date;

public class Alimento extends Produto{

	private Date dataValidade;

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
}
