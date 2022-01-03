package aula1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WSGenerator2 {
	
	private int puzzleSize;
	private List<String> words;
	private char[][] puzzle ;
	
	
	public WSGenerator2(int puzzlesize, List<String> words2) {
		this.puzzleSize = puzzlesize;
		this.words = words2;
		System.out.println(words);
		createPuzzle();
		boolean v=false ;
		int i = 0;
		
		for(String word : words) {
			word = word.toUpperCase();
			System.out.println("We're in boys!!");
			while (v==false) {
				System.out.println("Still in: Word nº "+ i);
				v = verification(word, puzzle);
			}
			i++;
			System.out.println("We're out!");
			v=false;
		}
		filler(puzzle);
		
		
		
		//Write answer in a file 
	    try {
			PrintWriter myObj = new PrintWriter(new File("filename.txt"));
			System.out.println("Cheguei aqui");
			for(int coluna= 0; coluna < puzzleSize; coluna++) {//Escrever cada linha da sopa
				System.out.println(puzzle[coluna]);
				myObj.println(puzzle[coluna]);
			}
			for(String word : words) {
				myObj.println(word);
			}
			myObj.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(Arrays.deepToString(puzzle).replace("], ", "\n").replace("[[", "[\n[").replace("[", "\n").replace(",", " "));

	}
	
	
	private char[][] createPuzzle() {
		puzzle = new char[puzzleSize][puzzleSize];
		for(int linha = 0; linha < puzzleSize; linha++) {
			for(int coluna = 0; coluna < puzzleSize ; coluna++) {
				puzzle[linha][coluna] = '.';
			}
		}
		return puzzle;
	}
	
	private boolean verification(String word, char[][] puzzle) {
		int x = ThreadLocalRandom.current().nextInt(1,puzzleSize); 
		int y = ThreadLocalRandom.current().nextInt(1,puzzleSize); 
		int dir = ThreadLocalRandom.current().nextInt(1,8+1);
		
		if (puzzle[x][y] == '.') {
			switch(dir) {
			case 1: //esquerda
				if(y-word.length() >= 0) {
					for (int i = 0;  i < word.length(); i++) {
						if (puzzle[x][y-i]!='.') { //se, ao tentar colocar, algum dos espeços, que nao o primeiro, estiver ocupado, nao coloca
							return false;
						}		
					} 
					//se chegarmos aqui é pq a palavra cabe no espaco puzzle e tem todas as casas livres para a sua inserçao
					
					for (int i = 0; i < word.length(); i++) {
						puzzle[x][y-i]=word.charAt(i);
						
					}	
				}
				else //quando a palavra nao cabe no puzzle
					return false;
				
				break;
				
			case 2: //direita
				if(y+word.length() <= puzzleSize-1) {
					for (int i = 0; i < word.length(); i++) {
						if (puzzle[x][y+i]!='.') { 
							return false;
						}		
					} 
							
					for (int i = 0; i < word.length(); i++) {
						puzzle[x][y+i]=word.charAt(i);
						
					}	
				}
				else //quando a palavra nao cabe no puzzle
					return false;
				
				break;
				
			case 3: //cima 
				if(x-word.length() >= 0) {
					for (int i = 0; i < word.length(); i++) {
						if (puzzle[x-i][y]!='.') { 
							return false;
						}
					}
				
					for (int i = 0; i < word.length(); i++) {
						puzzle[x-i][y]=word.charAt(i);
						
						
					}	
				}
				else 
					return false;
				
				break;
				
			case 4: //baixo
				if(x+word.length() <= puzzleSize-1) {
					for (int i = 0; i < word.length(); i++) {
						if (puzzle[x+i][y]!='.') { 
							return false;
						}		
					} 
					
					for (int i = 0; i < word.length(); i++) {
						puzzle[x+i][y]=word.charAt(i);
						
					}	
				
				}
				else 
					return false;
				
				break;
				
			case 5: // / para cima e para a direita
				if(y+word.length() <= puzzleSize && x-word.length() >= 0 ) {
					int k=0;
					for (int i = 0; i < word.length(); i++) {
						if (puzzle[x-i][y+k]!='.') { 
							return false;
						}
						k++;
						
					} 
						
					int j=0;
					for (int i = 0; i < word.length(); i++) {
						puzzle[x-i][y+j]=word.charAt(i);
						j++;
						}
					}	
				
				else
					return false;
				
				break;
				
			case 6:// / para baixo e para a esquerda
				if(y-word.length() >= 0 && x+word.length() <= puzzleSize ) {
					int k=0;
					for (int i = 0; i < word.length(); i++) {
						if (puzzle[x+i][y-k]!='.') { 
							return false;
						}
						k++;
						
					} 
						
					int j=0;
					for (int i = 0; i < word.length(); i++) {
						puzzle[x+i][y-j]=word.charAt(i);
						j++;
						}
					}	
				
				else
					return false;
				
				break;
				
			case 7: // para cima e para a esquerda
				if(y-word.length() >= 0 && x-word.length() >= 0 ) {
					int k=0;
					for (int i = 0; i < word.length(); i++) {
						if (puzzle[x-i][y-k]!='.') { 
							return false;
						}
						k++;
						
					} 
						
					int j=0;
					for (int i = 0; i < word.length(); i++) {
						puzzle[x-i][y-j]=word.charAt(i);
						j++;
						}
					}	
				
				else
					return false;
				
				break;
				
			case 8: // para baixo e para a direita
				if(y+word.length() <= puzzleSize && x+word.length() <= puzzleSize ) {
					int k=0;
					for (int i = 0; i < word.length(); i++) {
						if (puzzle[x+i][y+k]!='.') { 
							return false;
						}
						k++;
						
					} 
						
					int j=0;
					for (int i = 0; i < word.length(); i++) {
						puzzle[x+i][y+j]=word.charAt(i);
						j++;
						}
					}	
				
				else
					return false;
				
				break;
				
			default:
				return false;
			}
		}
		else {
			return false;
		}
			
		return true;
		
	}
	
	private char[][] filler(char[][] puzzle){
		for(int linha = 0; linha < puzzleSize; linha++) {
			for(int coluna = 0; coluna < puzzleSize ; coluna++) {
				if(puzzle[linha][coluna] == '.') {
					short minascii= 65;
					short maxascii= 90;
					int UpperCaseLetter = ThreadLocalRandom.current().nextInt(minascii,maxascii); 
					puzzle[linha][coluna] = (char) UpperCaseLetter;
				}
			}
		}
		
		return puzzle;
		
	}
	
}
