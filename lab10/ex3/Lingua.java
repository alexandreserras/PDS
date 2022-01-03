package lab10.ex3;

public abstract class Lingua {
    public abstract String getType();

    private Mediator m;

    public Lingua(Mediator m) {
        this.m = m;
    }
    public abstract void  enviarMensagem(String a);
    public abstract  String receberMensagem();
    public Mediator getMediator(){
        return m;
    }
}