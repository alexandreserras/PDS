package lab10.ex3;

public interface Mediator {
    public void enviar_Message(String message, Lingua l);
    public String receber_Message(Lingua l);
}
