package aula1;

import java.io.*;
import java.util.*;

public class WSGeneratorlauncher {

	public static void main(String[] args) throws FileNotFoundException {
		int size = 12;
		
		
		List<String> words = new ArrayList<>();
		
		Scanner num = new Scanner(System.in);
		
		System.out.println("Qual o nome do ficheiro que deseja inserir (ficheiros .txt only)? ");
		String filename = num.nextLine();
		num.close();
		
		
		File file = new File(filename+".txt"); 
			    
				Scanner sc = new Scanner(file); 
			  
			    while (sc.hasNextLine()) {
			    	//System.out.println(sc.nextLine());
			    	words.add(sc.nextLine());	
			    }
			    new WSGenerator2(size, words);
			   // System.out.println(Arrays.deepToString(wordsoup).replace("], ", "\n").replace("[[", "[\n[").replace("[", "\n").replace(",", " "));
			    sc.close();
	}

}
