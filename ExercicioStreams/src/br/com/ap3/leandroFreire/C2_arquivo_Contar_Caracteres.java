package br.com.ap3.leandroFreire;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class C2_arquivo_Contar_Caracteres {
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Sintaxe: ContadorCaracteresArquivo arq [arq ...]");
			System.exit(1);
		}
		
		for(int i = 0; i < args.length; i++) {
			try {
				int qntCaracteres = contaCaracteres(args[i]);
				System.out.println(args[i] + ": " + qntCaracteres + " caracteres.");
				gravarArquivo(qntCaracteres);
			}catch (IOException e) {
				System.err.println(args[i] + ": Erro: " + e.getMessage());
			}
		}
	}

	private static void gravarArquivo(int qntCaracteres) throws IOException {
		FileWriter arq = new FileWriter("quntCaracteres.txt");
		BufferedWriter escreveArq = new BufferedWriter(arq);
		
		escreveArq.write(Integer.toString(qntCaracteres));
		escreveArq.newLine();
		
		arq.close();
		escreveArq.close();
	}

	private static int contaCaracteres(String nomeArquivo) throws IOException{
		FileReader arq = new FileReader(nomeArquivo);
		BufferedReader lerArq = new BufferedReader(arq);
		
		int contadorCaracteres = 0;
		
		try {
			while (lerArq.read() >= 0)
				contadorCaracteres++;
		}finally {
			arq.close();
			lerArq.close();
		}
		return contadorCaracteres;
	}

}
