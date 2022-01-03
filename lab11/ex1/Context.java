package lab11.ex1;

public class Context{
    private SortStrategy s;


    public Context(SortStrategy s) {
        this.s=s;
    }

    public void sort(Phone[] array, String attr) {
        this.s.sort(array, attr);
    }

    public void setAlgorithm(SortStrategy s){
        this.s=s;
    }

}