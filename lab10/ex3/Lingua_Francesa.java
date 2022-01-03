package lab10.ex3;

public class Lingua_Francesa extends Lingua{


    public Lingua_Francesa(Mediator m) {
        super(m);
    }


    @Override
    public String getType() {
        return "french";
    }
    public void enviarMensagem(String  a){
        this.getMediator().enviar_Message(a, this);
    }
    public String receberMensagem(){
        return this.getMediator().receber_Message(this);
    }
}
