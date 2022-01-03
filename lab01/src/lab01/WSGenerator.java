import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class WSGenerator{
    private Character [][] tabuleiro;
    // ORDEM 0=UP 1=DOWN 2=RIGHT 3=LEFT 4=UPRIGHT 5=UPLEFT 6=DOWNRIGHT 7=DOWNLEFT
    private int [] movY = new int[]{ 0 , 0 , 1 , -1 , 1 , -1 , 1 , -1 }; 
    private int [] movX = new int[]{ -1, 1 , 0 , 0 , -1 , -1 , 1 , 1  };
    public WSGenerator(int tamanho){
        this.tabuleiro=new Character[tamanho][tamanho];
    }
    public static char letra(Random gerador){
        int x= gerador.nextInt(26)+65;
        char convertedChar = (char)x;
        return convertedChar;
    }
    public void colocarPalavra(String palavra,int altura,int comprimento,int direcao){
        for (int i =0 ; i<palavra.length();i++){
            if(this.tabuleiro[altura][comprimento] == null ){
                //correu bem  logo letra pode ser colocada
                this.tabuleiro[altura][comprimento]=palavra.charAt(i);
            }
            altura+=this.movX[direcao];
            comprimento+=this.movY[direcao];
        }
    }
    public boolean verificaColocacao(String palavra,int altura,int comprimento,int direcao){
       boolean controlo=false;
       
        for (int i=0; i<palavra.length();i++){
           
            if(this.tabuleiro[altura][comprimento] == null ){
                //correu bem  logo letra pode ser colocada
                controlo=true;
            }
            else if( this.tabuleiro[altura][comprimento] == palavra.charAt(i)){
                continue;
            }
            else{
                return false;
            }
            altura+=this.movX[direcao];
            comprimento+=this.movY[direcao];
            if(altura > this.tabuleiro[0].length-1 || comprimento > this.tabuleiro[0].length-1 || altura < 0 || comprimento <0){
                return false;
            }
        }
        return controlo;
    }


    public static void main(String[]args){
        //ARGUMENTOS VALORES
        int tamanho=0;

        String fileSaida="",fileEntrada="";
        if (args.length !=6){
            System.err.println("A sintaxe dos argumentos deve ser -i fileEntrada -s size -o fileSaida");
            System.exit(0);
        }
        for (int i=0 ; i< args.length ; i++){
            if (args[i].equals("-i")) {
                if (i+1 < args.length)
                    fileEntrada=args[i+1];
                else
                    System.err.println("Associado ao -i deve vir um ficheiro");
            }
            
            if (args[i].equals("-o")) {
                if (i+1 < args.length)
                    fileSaida=args[i+1];
                else
                    System.err.println("Associado ao -o deve vir um ficheiro");
            }
            if (args[i].equals("-s")) {
                if (i+1 < args.length){
                    try {
                        tamanho=Integer.parseInt(args[i+1]);
                        if (tamanho > 40 || tamanho< 1){
                            System.err.println("TABULEIRO NO MAXIMO É 40 POR 40");
                            System.exit(0);
                        }
                    }
                    catch(NumberFormatException e){
                        System.err.println("TEM QUE SER UM INTEIRO");
                        System.exit(0);
                    }
                }
                else
                    System.err.println("Associado ao -s deve vir um inteiro com o máximo de 40");
            }
        }
        //FIM DA PARTE DOS ARGUMENTOS
      
        ArrayList<String> lista= new ArrayList<>();
        ArrayList<String> listaInicial= new ArrayList<>();
        Scanner myReader =null;
        try {
             File myObj = new File(fileEntrada);
             myReader = new Scanner(myObj);
            } catch (FileNotFoundException e) {
              System.out.println("ERROR: Ficheiro não encontrado.");
              System.exit(0);
            }
            while(myReader.hasNextLine()){
                String linha = myReader.nextLine();
                String [] arrOfStr = linha.split("[;, ]");
                listaInicial.add(linha);
                for (String palavra : arrOfStr){
                    if (!palavra.isEmpty()){
                        if (palavra.equals(palavra.toUpperCase())){
                            palavra=palavra.toLowerCase();
                        }
                        lista.add(palavra);
                    }
                }
            }
            //ordena a lista
            ArrayList<String>listaOrdenada=new ArrayList<>(lista);
            for (int i=1 ;i<listaOrdenada.size(); i++)
            {
                String temp = listaOrdenada.get(i);
                int j = i - 1;
                while (j >= 0 && temp.length() >listaOrdenada.get(j).length())
                {
                  listaOrdenada.set(j+1, listaOrdenada.get(j));
                    j--;
                }
                listaOrdenada.set(j+1, temp);
                   }
            ///
            
            WSGenerator criador= new WSGenerator(tamanho);
            //IR A CADA PALAVRA SORTEAR UMA DIMENSAO DE ALTURA E UMA DE Y 
            // SORTEAR UMA DIREÇAO, VER SE CABE 
            //VAMOS TER QUE IR LETRA A LETRA LOGO NAO SE DEVIA COMEÇAR A ESCREVER LOGO
            // primeiro era melhor verificar se é possivel começar naquela direção  e posicao
            //para colocar aquele palavra
            //DIREÇÕES
            boolean colocado=false;
            int altura=-1, comprimento=-1, direcao=-1;
            Random gerador= new Random();
            for (String word : listaOrdenada){
                String palavra=word.toUpperCase();
                for (int i =0; i< 10; i++){
                    altura=gerador.nextInt(tamanho);  
                    comprimento=gerador.nextInt(tamanho);
                    direcao =gerador.nextInt(8); //gera numeros entre 0 e 7 para entrar em conformidade fazemos de 1 a 8
                    colocado=criador.verificaColocacao(palavra,altura, comprimento, direcao);
                    if (colocado){

                        break;
                    }
                }
                if (!colocado){
                    System.out.println("ERRO AO COLOCAR AS PALAVRAS NO TABULEIRO, TENTE UM VALOR DE S MAIOR");
                    System.exit(0);
                }
                criador.colocarPalavra(palavra, altura, comprimento, direcao);
                //agora ja podemos escrever
            }
            
            try {
                FileWriter myWriter = new FileWriter(fileSaida);
                int i=0,j=0;
                for (Character [] a : criador.tabuleiro){
                    for (Character b : a){
                    if (b == null){
                        char valor=letra(gerador);
                        criador.tabuleiro[i][j]=valor;
                        myWriter.write(valor);
                    }
                    else{
                        myWriter.write(b);
                    }
                    j++;
                    }
                    j=0;
                    i++;
                    myWriter.write("\n");
                }
                for (String linha: listaInicial){
                    myWriter.write(linha+"\n");
                }
                myWriter.close();
            }
              catch (IOException exception) {
                System.err.println("Error creating file!");
                System.exit(0);
            }

    }


    


}