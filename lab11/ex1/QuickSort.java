package lab11.ex1;

public class QuickSort implements SortStrategy{

    @Override
    public void sort(Phone[] array, String attr) {
        // TODO Auto-generated method stub
        System.out.println("Using Quick Sort");
        
        for (int i = array.length-1; i>=0; i--){
            System.out.println(array[i]);
        }
        
    }
    
}
