package lab11.ex1;

public class BubbleSort implements SortStrategy{

    @Override
    public void sort(Phone[] array, String attr) {
        System.out.println("Using Bubble Sort");
        for (Phone o : array){
            System.out.println(o);
        }
    }
    
}
