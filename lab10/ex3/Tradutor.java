package lab10.ex3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tradutor implements Mediator {

    private HashMap<String, String> dic_pt;
    private HashMap<String, String> dic_fr;
    private HashMap<Lingua,String> clientes;
    private String ult_message;
    private String lingua_msg;
    private Lingua pessoa;
    private String mensagem_traduzida;
    public Tradutor() {
        this.dic_pt = new HashMap<>();
        this.dic_fr=new HashMap<>();
        this.clientes = new HashMap<>();
        dic_pt.put("Olá", "Bonjour");
        dic_pt.put("Adeus", "Au revoir");
        dic_pt.put("eu", "je");
        dic_pt.put("sou","suis");
        dic_pt.put("o", "le");
        dic_pt.put("e", "et");
        dic_pt.put("tenho", "ai");
        dic_pt.put("anos", "ans");
        dic_fr.put("Bonjour", "Olá");
        dic_fr.put("Au_revoir", "Adeus");
        dic_fr.put("je", "eu");
        dic_fr.put("suis","sou");
        dic_fr.put("le", "o");
        dic_fr.put("et", "e");
        dic_fr.put("ai", "tenho");
        dic_fr.put("ans", "anos");
      
        
    }

    
    
    @Override
    public void enviar_Message(String message, Lingua l) {
        if (!this.clientes.containsKey(l)){
            this.clientes.put(l,l.getType());
        }
        
        this.ult_message=message;
  
        this.pessoa=l;
        this.mensagem_traduzida="";
        String [] partes =ult_message.split(" ") ;
        if (l.getType().equals("french")){
            
            this.lingua_msg="french";
            for (String a : partes){
                if (dic_fr.containsKey(a)){
                    
                    this.mensagem_traduzida+=dic_fr.get(a)+" ";
                   
                }
                else{
                    
                    this.mensagem_traduzida+=a+" ";
                }
            }
        }
        else{
            for (String a : partes){
                if (dic_pt.containsKey(a)){
                    this.mensagem_traduzida+=dic_pt.get(a)+" ";
                }
                else{
                    this.mensagem_traduzida+=a+" ";
                }
            }
            this.lingua_msg="portuguese";
        }
        
        //enviar para todos
    }

    @Override
    public String receber_Message(Lingua l) {
       
        if (!this.clientes.containsKey(l)){
            this.clientes.put(l,l.getType());
        }
           // System.out.println(a.getType());
               
        if (l.getType()==this.lingua_msg){
                return this.ult_message;
        }
        else{
            return this.mensagem_traduzida;
        }

        
    }
    
}
