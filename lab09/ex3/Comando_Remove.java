package lab09.ex3;
import java.util.Collection;
import java.util.Stack;

public class Comando_Remove<T> implements Command<T>{

    private Collection<T> collection;
    private Stack<T> pilha;

    public Comando_Remove(Collection<T> collection){
        this.collection = collection;
        pilha = new Stack<T>();
    }

    @Override
    public boolean execute(T element) {
        // TODO Auto-generated method stub
        

        try {
            collection.remove(element);
            pilha.push(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean undo() {
        // TODO Auto-generated method stub
       
        if (pilha.isEmpty()){
            return false;
        }
        T element = pilha.pop();
        collection.add(element);
        return true;
    }

}
    