package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
	// /home/gustavo/Documentos/teste.csv

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> votos = new LinkedHashMap<>();

		System.out.print("Caminho da pasta:");

		String pasta = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(pasta))) {
			String linha = br.readLine();
			while (linha != null) {
				
				String[] arquivo = linha.split(",");
				String nome = arquivo[0];
				int soma = Integer.parseInt(arquivo[1]);
				
				if (votos.containsKey(nome)) {
					int totalVotos = votos.get(nome);
					System.out.println("Valor de :"+totalVotos);
					System.out.println();
					votos.put(nome, soma + totalVotos);
					
				} 
				
				else {
					votos.put(nome, soma);
				}
				linha = br.readLine();
			}
			for (String k : votos.keySet()) {
				System.out.println(k + ": " + votos.get(k));
			}
		} catch (IOException e) {
			System.out.println("Erro" + e.getMessage());
		}

		sc.close();
	}

}
