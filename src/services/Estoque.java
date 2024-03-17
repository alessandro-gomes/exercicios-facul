package services;

import java.io.*;

public class Estoque {

	private String[] produto;
	private Produto[] produtos;
	private String alimentoMaisCaro;
	private String eletrodomesticoMaisBarato;
	private Double maiorValorAlimento = -1D;
	private Double menorValorEletrodomestico = 99999999999999999999999999999999999999D;
	
	public Estoque(String fileName) {
		preencheEstoque(fileName);
	}

	public void preencheEstoque(String fileName) {
		try {
			Double valorAtual;
			int count = 0;
			FileReader fr = new FileReader(fileName);
			BufferedReader in = new BufferedReader(fr);
			String line = in.readLine();
			line = in.readLine();
			
			while (line != null) {
				produto = line.split("\\s\\*\\s");
				
				if (produto[3].equalsIgnoreCase("Alimento")) {
					valorAtual = Double.parseDouble(produto[2]);
					calculoAlimentoMaisCaro(line, valorAtual);
				} else if (produto[3].equalsIgnoreCase("Eletrodomestico")) {
					valorAtual = Double.parseDouble(produto[2]);
					calculoEletrodomesticoMaisBarato(line, valorAtual);
				} else if (produto[3].equalsIgnoreCase("Vestuario")) {
					
				}
				
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo " + fileName);
		}
	}
	
	public void calculoEletrodomesticoMaisBarato(String line, Double valorAtual) {
		if (this.menorValorEletrodomestico > valorAtual) {
			this.menorValorEletrodomestico = valorAtual;
			this.eletrodomesticoMaisBarato = line;
		}
	}

	public void calculoAlimentoMaisCaro(String line, Double valorAtual) {
		if (this.maiorValorAlimento  < valorAtual) {
			this.maiorValorAlimento = valorAtual;
			this.alimentoMaisCaro = line;
		}
	}

	public Double getMaiorValorAlimento() {
		return maiorValorAlimento;
	}
	
	public void setMaiorValorAlimento(Double maiorValorAlimento) {
		this.maiorValorAlimento = maiorValorAlimento;
	}
	
	public String getAlimentoMaisCaro() {
		return alimentoMaisCaro;
	}

	public void setAlimentoMaisCaro(String alimentoMaisCaro) {
		this.alimentoMaisCaro = alimentoMaisCaro;
	}

	public String getEletrodomesticoMaisBarato() {
		return eletrodomesticoMaisBarato;
	}

	public void setEletrodomesticoMaisBarato(String eletrodomesticoMaisBarato) {
		this.eletrodomesticoMaisBarato = eletrodomesticoMaisBarato;
	}

	public Double getMenorValorEletrodomestico() {
		return menorValorEletrodomestico;
	}

	public void setMenorValorEletrodomestico(Double menorValorEletrodomestico) {
		this.menorValorEletrodomestico = menorValorEletrodomestico;
	}

	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}
	
	
	
	
}
