package lab11.ex2;

public interface State {
    public boolean register(Livros l);
    public boolean giveBack(Livros l);
    public boolean canelReserve(Livros l);
    public boolean take(Livros l);
    public boolean reserve(Livros l);
}
