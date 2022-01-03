package lab09.ex3;

public interface Command<T> {
    public boolean execute(T element);
    public boolean undo();
}
