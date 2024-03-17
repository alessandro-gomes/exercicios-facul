package services;

import java.io.*;

public class Principal {

	public static void main(String[] args) {
		Estoque estoque = new Estoque("src/produtos.txt");
		Produto[] produtos = estoque.getProdutos();
		String gravaArquivo = "";

		gravaArquivo += "Informações do alimento mais caro:\n";
		int posicaoAlimentoMaisCaro = -1;

		// encontra a posicao do primeiro produto do tipo Alimento
		for (int i = 0; i < produtos.length; i++)
			if (produtos[i] instanceof Alimento) {
				posicaoAlimentoMaisCaro = i;
				break;
			}

		// procura o alimento mais caro
		if (posicaoAlimentoMaisCaro == -1)
			gravaArquivo += "[Não existem alimentos no estoque]\n";
		else {
			for (int i = posicaoAlimentoMaisCaro + 1; i < produtos.length; i++)
				if (produtos[i] instanceof Alimento)
					if (produtos[i].getPreco() > produtos[posicaoAlimentoMaisCaro].getPreco())
						posicaoAlimentoMaisCaro = i;
			gravaArquivo += produtos[posicaoAlimentoMaisCaro].getNome() + " | R$ " + produtos[posicaoAlimentoMaisCaro].getPreco() + "\n";
		}

		gravaArquivo += "\nInformações do eletrodoméstico mais barato:\n";
		int posicaoEletrodomesticoMaisBarato = -1;

		// encontra a posicao do primeiro produto do tipo Eletrodomestico
		for (int i = 0; i < produtos.length; i++)
			if (produtos[i] instanceof Eletrodomestico) {
				posicaoEletrodomesticoMaisBarato = i;
				break;
			}

		// procura o eletrodomestico mais barato
		if (posicaoEletrodomesticoMaisBarato == -1)
			gravaArquivo += "[Não existem eletrodomésticos no estoque]\n";
		else {
			for (int i = posicaoEletrodomesticoMaisBarato + 1; i < produtos.length; i++)
				if (produtos[i] instanceof Eletrodomestico)
					if (produtos[i].getPreco() < produtos[posicaoEletrodomesticoMaisBarato].getPreco())
						posicaoEletrodomesticoMaisBarato = i;
			gravaArquivo += produtos[posicaoEletrodomesticoMaisBarato].getNome() + " | R$ " + produtos[posicaoEletrodomesticoMaisBarato].getPreco() + "\n";
		}

		// o nome e a quantidade em estoque de todos os produtos de vestuário
		gravaArquivo += "\nNome e quantidade em estoque de todos os produtos de vestuário:\n";
		for (int i = 0; i < produtos.length; i++)
			if (produtos[i] instanceof Vestuario)
				gravaArquivo += produtos[i].getNome() + " | Quantidade em estoque: "
						+ ((Vestuario) produtos[i]).getEstoque() + "\n";

		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("src/info.txt");
			pw = new PrintWriter(fw);
			pw.write(gravaArquivo);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			pw.close();
		}

	}

}
