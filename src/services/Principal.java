package services;

import java.io.*;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		String fileName = "src/produtos.txt";
		Scanner ler = new Scanner(System.in);

		// String fileName = "src/";
		// System.out.print("Qual o nome do arquivo? ");
		// fileName += ler.next();
		// fileName += ".txt";

		Estoque estoque = new Estoque(fileName);

		try {
			File file = new File("src/info.txt");
			FileWriter fr = new FileWriter(file);
			PrintWriter out = new PrintWriter(fr);
			out.println("Alimento mais caro: " + estoque.getAlimentoMaisCaro());
			out.println("Eletrodomestico mais barato: " + estoque.getEletrodomesticoMaisBarato());
			out.close();
		} catch (IOException e) {
			System.out.println("Erro ao escrever arquivo.");
		}
	}

}
