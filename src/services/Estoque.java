package services;

import java.io.*;

public class Estoque {

	private Produto[] produtos;
	private BufferedReader br;

	public Estoque(String fileName) {
		preencheEstoque(fileName);
	}

	public void preencheEstoque(String fileName) {
		try {
			int quantProdutos = 0;
			FileReader fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String line = br.readLine();

			//definir o tamanho do array de produtos.
			while (line != null) {
				quantProdutos++;
				line = br.readLine();
			}

			br.close();
			produtos = new Produto[quantProdutos - 1];

			// abrindo novamente para ler os produtos e prencher o estoque.
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			br.readLine();

			for (int i = 0; i < produtos.length; i++) {
				line = br.readLine();
				String[] arrayString = line.split("\\s\\*\\s");
				String nome = arrayString[0];
				String descricao = arrayString[1];
				Double preco = Double.parseDouble(arrayString[2]);
				if (arrayString[3].equalsIgnoreCase("Alimento")) {
					String dataValidade = arrayString[4];
					produtos[i] = new Alimento(nome, descricao, preco, dataValidade);
				} else if (arrayString[3].equalsIgnoreCase("Vestuario")) {
					int quantEstoque = Integer.parseInt(arrayString[4]);
					produtos[i] = new Vestuario(nome, descricao, preco, quantEstoque);
				} else if (arrayString[3].equalsIgnoreCase("Eletrodomestico")) {
					Double valorAdicionalIPI = Double.parseDouble(arrayString[4]);
					produtos[i] = new Eletrodomestico(nome, descricao, preco, valorAdicionalIPI);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo " + fileName);
		}
	}

	public void imprimeEstoque() throws IllegalArgumentException{
		if(produtos == null)
			throw new IllegalArgumentException();
		for(Produto p: produtos)
			System.out.println(p);
	} 

	public Produto[] getProdutos() {
		return produtos;
	}

}
