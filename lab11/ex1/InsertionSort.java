package lab11.ex1;

public class InsertionSort implements SortStrategy{

    @Override
    public void sort(Phone[] array, String attr) {
        System.out.println("Using Insetion Sort");
        for (Phone o : array){
            System.out.println(o);
        }
    }
    
}
