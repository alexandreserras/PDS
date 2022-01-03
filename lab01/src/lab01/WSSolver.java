import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.*;

class WSSolver {
    private HashMap<String, Resposta> solucao; 
    private Character [][] tabela;
    public WSSolver(int tamanhoLinha) {
      this.solucao=new HashMap<String, Resposta> ();
      this.tabela=new Character [tamanhoLinha][tamanhoLinha];
    }
    public  Direcoes atribuirDirecao(int numero){
      switch(numero){
          case 1:
              return Direcoes.UP;
              
          case 2:
              return Direcoes.DOWN;
             
          case 3:
              return Direcoes.RIGHT;
              
          case 4:
              return Direcoes.LEFT;
              
          case 5:
              return Direcoes.UPRIGHT;
             
          case 6:
              return Direcoes.UPLEFT;
              
          case 7:
              return Direcoes.DOWNRIGHT;
            
          case 8:
              return Direcoes.DOWNLEFT;
              
          default:
            return null;
         }
      
    }
   //metodos
   public void encontraPalavra(String word,Character [][] tabuleiro, int sizeTabuleiro){
      String palavra= word.toUpperCase();
      int tamanho=sizeTabuleiro;
      boolean controlo=false;
      for (int i= 0; i < tamanho; i++){  //COLUNA
        for (int j=0; j< tamanho;j++){   //LINHA
          //condicao iniciante ver se a primeira letra coincide 
          if (tabuleiro[i][j] == palavra.charAt(0)){
            int retorno= verificaDireções(palavra,tabuleiro,i,j,tamanho);
            //colocar um if para ver se retorna diferente de 0
            if (retorno != 0) {
              Coordenadas posicao = new Coordenadas(i+1,j+1);  //TABULEIRO ENCONTRA-SE EM 1,1 E NAO 0,0 
              Direcoes direcao= atribuirDirecao(retorno);
              Resposta res=new Resposta(posicao,direcao);
              if (!this.solucao.containsValue(res) ){
                  this.solucao.put(word, res);
                  controlo=true;
                  break;
              }
            }
          }
        }
        if (controlo){
          break;
        }
      }
      if( ! controlo){
        System.out.println("Nao encontrada a palavra logo puzzle impossivel");  
        System.exit(0);
      }
   }
   // para entrar nesta função significa que a primeira letra da palavra já é igual logo 
   public int verificaDireções(String palavra,Character [] [] tabuleiro,int altura , int comprimento,int sizeTabuleiro){
     // ORDEM UP DOWN RIGHT LEFT UPRIGHT UPLEFT DOWNRIGHT DOWNLEFT
     int [] movY = new int[]{ 0 , 0 , 1 , -1 , 1 , -1 , 1 , -1 }; 
     int [] movX = new int[]{ -1, 1 , 0 , 0 , -1 , -1 , 1 , 1  };
     int sizeWord= palavra.length();
     //direcoes
     for ( int i=0; i < 8; i++){
        //iterar sobre a palavra 
        int posX =altura;
        int posY=comprimento; //Começa no valor inicial e so precisamos de verificar a partir da segunda letra
        int letra;
        for ( letra= 1; letra < sizeWord; letra++){
            posX+=movX[i];
            posY+=movY[i];
            if (posX <0 || posX >= sizeTabuleiro || posY >= sizeTabuleiro || posY <0 )
              break; // FORA DO TAMANHO
            
            if (tabuleiro [posX][posY] != palavra.charAt(letra))
              break;
              //letra diferente
        }
        if (letra == sizeWord){
          //se entrar aqui começar a encher o tabuleiro
          boolean validar=adicionarTabela(palavra,altura,comprimento,movX[i],movY[i],tabuleiro);
          if (validar ){
            return i+1; //SOMA-SE 1 POIS VAI DE 1 a 8 as direçoes
          }
        }
     }
     return 0; // OU SEJA NAO ACHOU NENHUMA CORRESPONDECIA
     //NO FINAL INCREMENTAR 1 AO RETORNO para dar a direcao correta
            
   }
   private boolean adicionarTabela(String palavra, int altura, int comprimento,int alturaS, int comprimentoS,Character [][] tabuleiro ) {
     //funcao que vai escrever na tabela caso todas as letras ja se encontrem na tabela, significa que a palavra
     // esta dentro de outra e por isso nao pode ficar aqui
     boolean controlo=false;//caso escreva pelo menos 1 fez implica que nao esteja contida
    for(int i=0; i < palavra.length(); i++){
        if (this.tabela [altura][comprimento] == null){
          this.tabela [altura][comprimento]=tabuleiro[altura][comprimento];
          controlo=true;
        }
        altura+=alturaS;
        comprimento+=comprimentoS;
    }
     return controlo;





  }
  //função que verifica se existem palavras repetidas na solução 
   public static  boolean palavrasRepetidas (String word, ArrayList solucao) {
        if (solucao.contains(word)){
            return false;
        }
        return true;
  }
  public static boolean verificarPalavra(String word){
      //verificação do topico 4
      for (int i= 0; i< word.length(); i++){
        if( Character.isDigit(word.charAt(i)) ){
            return false;
        }
      }
      //verificao do topico 3
      if(word.equals(word.toUpperCase())){
        return false;
      }
      return true;
  }
 // public static void validarPalavras(String word, ArrayList solucao)
    public static void main(String[] args) {
      // codigo para receber argumentos do terminal
     String fname="./";
      if(args.length == 1){
        fname+=args[0];
      }
      else{
        System.out.println("Tem que dar 1 argumento apenas e deve ser o nome do file com a sopa de letras. "); 
        System.exit(0);
      }
        int tamanhoLinha=0; 
        boolean controlo=true;
      ArrayList<String> lista  = new ArrayList<String>();

     Scanner myReader =null;
      try {
           
           File myObj = new File(fname);
             myReader = new Scanner(myObj);
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          String linha = myReader.nextLine();
          tamanhoLinha=linha.length();
          if (tamanhoLinha > 40){
            System.out.println("Dimensões incorretas");  //Ficheiro não cumpre os requisitos
            System.exit(0);
          }
          Character [][] tabuleiro = new Character[tamanhoLinha][tamanhoLinha];
          for (int i=0; i< tamanhoLinha; i++){
            if (linha.equals(linha.toUpperCase()) == false){
              System.out.println("Todas as letras do puzzle tem que  ser maiusculas!"); 
              System.exit(0);
            }
             for(int j=0; j< tamanhoLinha ; j++){
               tabuleiro[i][j]=linha.charAt(j);
             }
             linha=myReader.nextLine();
             if (i != tamanhoLinha -1 ){ // para garantir que cumpre todos os requisitos necessarios ao nivel do tamanho
               if (linha.length() != tamanhoLinha){
                System.out.println("Inconsistência do tamanho!"); 
                System.exit(0);
               }
             }
             else {
               break;
             }
          }
          linha=linha.strip();
          String [] arrOfStr = linha.split("[;, ]");
          if(!linha.isEmpty()){
            
            for (String a : arrOfStr){
              if (!a.isEmpty()){
                if (palavrasRepetidas(a,lista)){
                    lista.add(a);
                }
                else{
                  controlo=false;
                  System.out.println("Palavras repetidas!"); //Palavras repetidas logo ficheiro nao cumpre requisitos
                  System.exit(0);
                }
              }
              } 
              //se for linha vazia crasha?
            }
            while (myReader.hasNextLine()  ) {
              linha = myReader.nextLine().strip();
              if(!linha.isEmpty()){
                arrOfStr = linha.split("[;, ]");  
                for (String a : arrOfStr){
                  if (!a.isEmpty()){
                    if (palavrasRepetidas(a,lista)){
                        lista.add(a);
                    }
                    else{
                        controlo=false;
                        System.out.println("Palavras repetidas!"); //Palavras repetidas logo ficheiro nao cumpre requisitos
                        System.exit(0);
                    }
                  }
                } 
              }    
              }
            myReader.close();
           
            for (String a: lista){
              if(!verificarPalavra(a)){
                System.out.println("Palavras inválidas!"); //Palavras invalidas logo ficheiro nao cumpre requisitos
                System.exit(0);
              }
            }
            //CODIGO PARA ORDENAR A LISTA POR TAMANHO 
            ArrayList<String>listaOrdenada=new ArrayList<String>(lista);
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
            WSSolver resolve=new WSSolver(tamanhoLinha); 
            
            for (String a: listaOrdenada){
              resolve.encontraPalavra(a, tabuleiro, tamanhoLinha);
            }
            for (String name: lista){
                Resposta dados=resolve.solucao.get(name);
                 System.out.printf("%-15s %-4d %-7s %-13s \n",name,name.length(),dados.getValores(), dados.getDirecao());
              } 
            for (Character [] a : resolve.tabela){
              for (Character b : a){
                if (b == null){
                  System.out.print(". ");
                }
                else{
                System.out.print(b+" ");
                }
              }
              System.out.println();
            }
            
  


}
}
