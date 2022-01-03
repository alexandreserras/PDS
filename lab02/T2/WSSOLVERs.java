package aula1;

import java.io.*;
import java.util.*;
import java.io.File;  // Import the File class
public class WSSOLVER {

	public static void main(String[] args) {
		List<String> puzzle = new ArrayList<>();
		String[] palavras_separadas = null; // contem as palavras com split
		List<String> lista_palavras = new ArrayList<>(); // contem a lista de pala
		char [][] solucao, sopadeletras;
		String palavra;
		
		int maxsize = 40;
		try {
			Scanner ficheiro = new Scanner(new File("sdl_01.txt"));
			String data = ficheiro.nextLine();
			int FirstLen = data.length();
			for (int i = 0; i < FirstLen-1; i++) {
				if(Character.isLetter(data.charAt(i))){
					continue;
				}
				else {
					System.out.println("Character in first line, column "+ i + " is not an alphabetical character.");
					System.exit(0);//exit
				}
			}
			
/*		O bloco abaixo verifica se o puzzle respeita as condicionantes necessárias */	
			if( data.toUpperCase().equals(data) && FirstLen <= maxsize ) {
				puzzle.add(data);//adding 1st word if it's uppercase and is smaller than the maximum size
			}
			else {
				System.out.println("1st line not uppercase");
				System.exit(0);//exit
			}
			for(int i = 2; i < FirstLen+1;i++) {//Uso este ciclo for para verificar se o puzzle é quadrado
				
				String data2 = ficheiro.nextLine();
				if(data2.toUpperCase().equals(data2) && data2.length() == FirstLen) {
					for (int j = 0; j < FirstLen-1; j++) {
						if(Character.isLetter(data.charAt(j))){
							continue;
						}
						else {
							System.out.println("Character in first line, column "+ i + " is not an alphabetical character.");
							System.exit(0);//exit
						}
					}
					puzzle.add(data2);
				}
				else {
					System.out.println("Len 1st line: "+ FirstLen);
					System.out.println("Len line "+ i + ": "+ data2.length());
					System.out.println(i + " line not uppercase or has incorrect length");
					System.exit(0);//exit
				}
				
			}
			/*if (ficheiro.nextLine()) {
				System.out.println(puzzle);
				System.out.println("Puzzle is not square");
				System.exit(0);//exit
			}*/
			
/* O bloco acima verifica se o puzzle respeita as condicionantes necessárias */		
			
			
/* O bloco abaixo extrai as palavras para achar na WS e verifica se respeitam as condições */				
			while (ficheiro.hasNext()) {
				palavra = ficheiro.next();
				palavras_separadas = palavra.split(",|\\ |\\;");
				for (int j = 0; j < palavras_separadas.length; j++) {
					lista_palavras.add(palavras_separadas[j].toUpperCase());
				}
			}
/* O bloco acima extrai as palavras para achar na WS e verifica se respeitam as condições */			
			
			//System.out.println(lista_palavras);
			//System.out.println(puzzle);
			maxsize = FirstLen; // a este ponto já verifiquei que a WS é funcional, logo sei que FirstLen é a dimensão de puzzle
			ficheiro.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("Ficheiro nao existente. ");
		}
/* O bloco abaixo forma dois arrays bidimensionais do tamanho de puzzle  
 * 					sopadeletras que conterá o puzzle
 * 					solucao que conterá . (eventualmente será preenchido com as palavras encontradas)
 */
		solucao= new char[maxsize][maxsize];
		sopadeletras= new char[maxsize][maxsize];
		
		
		for(int j=0; j < puzzle.size() ; j++) {
			sopadeletras[j] = puzzle.get(j).toCharArray();
		}
		
		

		for(int linha = 0; linha < maxsize ; linha++) {
			for(int coluna=0; coluna < maxsize ; coluna++) {
				solucao[linha][coluna] = '.';//formar um array bidimensional do tamanho de puzzle apenas com . para dps preencher
			}
		}
		
		//System.out.println(Arrays.deepToString(solucao).replace("], ", "]\n"));
		//System.out.println(Arrays.deepToString(sopadeletras).replace("], ", "]\n"));
		
// Procurar as palavras na sopa de letras
		procurar(sopadeletras, solucao, lista_palavras, maxsize);
				
	}

	private static void procurar(char[][] sopadeletras, char[][] solucao, List<String> lista_palavras, int maxsize) {
		List<String> palavrasFound = new ArrayList<>();
		char primeira = 0;
		for (String palavra : lista_palavras) {
			 //System.out.println(palavra);
			primeira = palavra.charAt(0);// selecionar primeiro carater da palavra
			 //System.out.println(primeira);
			for (int linha = 0; linha < sopadeletras.length; linha++) {
				for (int coluna = 0; coluna < sopadeletras[linha].length; coluna++) {
					if (primeira == sopadeletras[linha][coluna]) { //quando encontro a letra inicials
						
						//procurar para tras e para cima caso haja espaço
						if(coluna+1 - palavra.length() >= 0 && linha+1 - palavra.length() >= 0) {
							searchupleft( linha,  coluna, palavrasFound, solucao, sopadeletras, palavra);
						}
						
						//procurar para tras caso haja espaço
						if(coluna+1 - palavra.length() >= 0) {
							searchleft(linha, coluna, palavrasFound, solucao, sopadeletras, palavra);
						}
						
						//procurar para tras e para baixo caso haja espaço
						if(coluna+1 - palavra.length() >= 0 && linha+1 + palavra.length() <= maxsize) {
							searchdownleft(linha, coluna, palavrasFound, solucao, sopadeletras, palavra);
						}
						
						//procurar para baixo caso haja espaço
						if(linha-1 + palavra.length() <= maxsize) {
							searchdown(linha, coluna, palavrasFound, solucao, sopadeletras, palavra);
						}
						
						
						//procurar para baixo e para a direita caso haja espaço
						if(linha-1 + palavra.length() <= maxsize && coluna-1 + palavra.length() <= maxsize) {
							searchdownright(linha, coluna, palavrasFound, solucao, sopadeletras, palavra);
						}
						
						//procurar para a direita caso haja espaço
						if(coluna-1 + palavra.length() <= maxsize) {
							searchright(linha, coluna, palavrasFound, solucao, sopadeletras, palavra);
						}
						
						
						//procurar para a direita e para cima caso haja espaço
						if(coluna-1 + palavra.length() <= maxsize && linha+1 - palavra.length() >= 0) {
							searchupright(linha, coluna, palavrasFound, solucao, sopadeletras, palavra);
						}
						
						
						
						//procurar para cima caso haja espaço
						if(linha+1 - palavra.length() >= 0) {
							searchup(linha, coluna, palavrasFound, solucao, sopadeletras, palavra);
						}
						
						
						
						
					}
				}
			}
		}
		System.out.println(Arrays.deepToString(solucao).replace("], ", "\n").replace("[[", "[\n[").replace("[", "\n").replace(",", " "));
	}
	
	
	
	private static void searchupleft(int linha, int coluna, List<String> palavrasFound, char[][] solucao, char[][] sopadeletras, String palavra) {
		int foundline = linha + 1;
		int foundcolumn = coluna+1;
		for(int i=1; i<palavra.length();i++) {
			if(sopadeletras[linha-i][coluna-i] == palavra.charAt(i) && i == palavra.length()-1 && !palavrasFound.contains(palavra)) {//verificação caso esteja na ultima letra
				palavrasFound.add(palavra);
				for(int j=0; j<palavra.length();j++) {
					solucao[linha-j][coluna-j] = sopadeletras[linha-j][coluna-j];//Escrever a solução
					//System.out.println("success");
				}
				System.out.println(palavra + "\t" + palavra.length() + "\t" + foundline + "," + foundcolumn + "\tup and left");
				//System.out.println(Arrays.deepToString(solucao).replace("], ", "]\n"));
			}else if(sopadeletras[linha-i][coluna-i] == palavra.charAt(i)) {
				continue;
			}else {
				break;
			}
		}
		
	}
	
	
	private static void searchleft(int linha, int coluna, List<String> palavrasFound, char[][] solucao, char[][] sopadeletras, String palavra) {
		int foundline = linha + 1;
		int foundcolumn = coluna+1;
		for(int i=1; i<palavra.length();i++) {
			if(sopadeletras[linha][coluna-i] == palavra.charAt(i) && i == palavra.length()-1 && !palavrasFound.contains(palavra)) {//verificação caso esteja na ultima letra
				palavrasFound.add(palavra);
				for(int j=0; j<palavra.length();j++) {
					solucao[linha][coluna-j] = sopadeletras[linha][coluna-j];//Escrever a solução
					//System.out.println("success");
				}
				System.out.println(palavra + "\t" + palavra.length() + "\t" + foundline + "," + foundcolumn + "\tleft");
				//System.out.println(Arrays.deepToString(solucao).replace("], ", "]\n"));
			}else if(sopadeletras[linha][coluna-i] == palavra.charAt(i)) {
				continue;
			}else {
				break;
			}
		}
	}
	
	
	private static void searchdownleft(int linha, int coluna, List<String> palavrasFound, char[][] solucao, char[][] sopadeletras, String palavra) {
		int foundline = linha + 1;
		int foundcolumn = coluna+1;
		for(int i=1; i<palavra.length();i++) {
			if(sopadeletras[linha+i][coluna-i] == palavra.charAt(i) && i == palavra.length()-1 && !palavrasFound.contains(palavra)) {//verificação caso esteja na ultima letra
				palavrasFound.add(palavra);
				for(int j=0; j<palavra.length();j++) {
					solucao[linha+i][coluna-j] = sopadeletras[linha+i][coluna-j];//Escrever a solução
					//System.out.println("success");
				}
				System.out.println(palavra + "\t" + palavra.length() + "\t" + foundline + "," + foundcolumn + "\tdown and left");
				//System.out.println(Arrays.deepToString(solucao).replace("], ", "]\n"));
			}else if(sopadeletras[linha+i][coluna-i] == palavra.charAt(i)) {
				continue;
			}else {
				break;
			}
		}
	}
		
		private static void searchdown(int linha, int coluna, List<String> palavrasFound, char[][] solucao, char[][] sopadeletras, String palavra) {
			int foundline = linha + 1;
			int foundcolumn = coluna+1;
			for(int i=1; i<palavra.length();i++) {
				if(sopadeletras[linha+i][coluna] == palavra.charAt(i) && i == palavra.length()-1 && !palavrasFound.contains(palavra)) {//verificação caso esteja na ultima letra
					palavrasFound.add(palavra);
					for(int j=0; j<palavra.length();j++) {
						solucao[linha+j][coluna] = sopadeletras[linha+j][coluna];//Escrever a solução
						//System.out.println("success");
					}
					System.out.println(palavra + "\t" + palavra.length() + "\t" + foundline + "," + foundcolumn + "\tdown");
					//System.out.println(Arrays.deepToString(solucao).replace("], ", "]\n"));
				}else if(sopadeletras[linha+i][coluna] == palavra.charAt(i)) {
					continue;
				}else {
					break;
				}
			}
		}
	
		private static void searchdownright(int linha, int coluna, List<String> palavrasFound, char[][] solucao, char[][] sopadeletras, String palavra) {
			int foundline = linha + 1;
			int foundcolumn = coluna+1;
			for(int i=1; i<palavra.length();i++) {
				if(sopadeletras[linha+i][coluna+i] == palavra.charAt(i) && i == palavra.length()-1 && !palavrasFound.contains(palavra)) {//verificação caso esteja na ultima letra
					palavrasFound.add(palavra);
					for(int j=0; j<palavra.length();j++) {
						solucao[linha+j][coluna+j] = sopadeletras[linha+j][coluna+j];//Escrever a solução
						//System.out.println("success");
					}
					System.out.println(palavra + "\t" + palavra.length() + "\t" + foundline + "," + foundcolumn + "\tdown and right");
					//System.out.println(Arrays.deepToString(solucao).replace("], ", "]\n"));
				}else if(sopadeletras[linha+i][coluna+i] == palavra.charAt(i)) {
					continue;
				}else {
					break;
				}
			}
		}
		private static void searchright(int linha, int coluna, List<String> palavrasFound, char[][] solucao, char[][] sopadeletras, String palavra) {
			int foundline = linha + 1;
			int foundcolumn = coluna+1;
			for(int i=1; i<palavra.length();i++) {
				if(sopadeletras[linha][coluna+i] == palavra.charAt(i) && i == palavra.length()-1 && !palavrasFound.contains(palavra)) {//verificação caso esteja na ultima letra
					palavrasFound.add(palavra);
					for(int j=0; j<palavra.length();j++) {
						solucao[linha][coluna+j] = sopadeletras[linha][coluna+j];//Escrever a solução
						//System.out.println("success");
					}
					System.out.println(palavra + "\t" + palavra.length() + "\t" + foundline + "," + foundcolumn + "\tright");
					//System.out.println(Arrays.deepToString(solucao).replace("], ", "]\n"));
				}else if(sopadeletras[linha][coluna+i] == palavra.charAt(i)) {
					continue;
				}else {
					break;
				}
			}
		}
		private static void searchupright(int linha, int coluna, List<String> palavrasFound, char[][] solucao, char[][] sopadeletras, String palavra) {
			int foundline = linha + 1;
			int foundcolumn = coluna+1;
			for(int i=1; i<palavra.length();i++) {
				if(sopadeletras[linha-i][coluna+i] == palavra.charAt(i) && i == palavra.length()-1 && !palavrasFound.contains(palavra)) {//verificação caso esteja na ultima letra
					palavrasFound.add(palavra);
					for(int j=0; j<palavra.length();j++) {
						solucao[linha-j][coluna+j] = sopadeletras[linha-j][coluna+j];//Escrever a solução
						System.out.println("success");
					}
					System.out.println(palavra + "\t" + palavra.length() + "\t" + foundline + "," + foundcolumn + "\tup and right");
					//System.out.println(Arrays.deepToString(solucao).replace("], ", "]\n"));
				}else if(sopadeletras[linha-i][coluna+i] == palavra.charAt(i)) {
					continue;
				}else {
					break;
				}
			}
		}
		
		private static void searchup(int linha, int coluna, List<String> palavrasFound, char[][] solucao, char[][] sopadeletras, String palavra) {
			int foundline = linha + 1;
			int foundcolumn = coluna+1;
			for(int i=1; i<palavra.length();i++) {
				if(sopadeletras[linha-i][coluna] == palavra.charAt(i) && i == palavra.length()-1 && !palavrasFound.contains(palavra)) {//verificação caso esteja na ultima letra
					palavrasFound.add(palavra);
					for(int j=0; j<palavra.length();j++) {
						solucao[linha-j][coluna] = sopadeletras[linha-j][coluna];//Escrever a solução
					}
					System.out.println(palavra + "\t" + palavra.length() + "\t" +  foundline + "," + foundcolumn + "\tup");
					//System.out.println(Arrays.deepToString(solucao).replace("], ", "]\n"));
				}else if(sopadeletras[linha-i][coluna] == palavra.charAt(i)) {
					continue;
				}else {
					break;
				}
			}
		}
	
}
