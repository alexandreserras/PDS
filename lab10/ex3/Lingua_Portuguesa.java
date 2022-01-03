package lab10.ex3;

public class Lingua_Portuguesa extends Lingua{



    @Override
    public String getType() {
        return "portuguese";
    }
    



    public Lingua_Portuguesa(Mediator m) {
        super(m);
    }
    
    public void enviarMensagem(String  a){
        this.getMediator().enviar_Message(a, this);
    }
    public String receberMensagem(){
        return this.getMediator().receber_Message(this);
    }
}
