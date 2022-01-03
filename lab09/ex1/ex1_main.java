package lab09.ex1;

import java.util.Iterator;
import java.util.ListIterator;


public class ex1_main{
    public static void main(String[] args) {

        VectorGeneric<Integer> intVector = new VectorGeneric<>();
        for (int i = 0; i < 10; i++)
            intVector.addElem(i);


        System.out.println("------ ITERATOR ------");
        Iterator<Integer> normalIterator = intVector.iterator();
        while (normalIterator.hasNext())
            System.out.println(normalIterator.next());
        

        System.out.println("\n------ LIST ITERATOR ------");
        ListIterator<Integer> listIterator = intVector.listIterator();
        
        System.out.println("\nFORWARD");    
        while (listIterator.hasNext())
            System.out.printf("Index %d: %d\n",listIterator.nextIndex(),listIterator.next());
         
        System.out.println("\nBACKWARDS");
        while (listIterator.hasPrevious())
            System.out.printf("Index %d: %d\n",listIterator.previousIndex(),listIterator.previous());
 

        // list iterator w/ custom index
        System.out.println("\n------ LIST ITERATOR w/ custom index ------");
        ListIterator<Integer> listIteratorIndex = intVector.listIterator(5);
        
        System.out.println("\nFORWARD");
        ListIterator<Integer> listIteratorIndexx = intVector.listIterator(3);
        while (listIteratorIndexx.hasNext())
            System.out.printf("Index %d: %d\n",listIteratorIndexx.nextIndex(),listIteratorIndexx.next());

        System.out.println("\nBACKWARDS");
        while (listIteratorIndex.hasPrevious())
            System.out.printf("Index %d: %d\n",listIteratorIndex.previousIndex(),listIteratorIndex.previous());
    

        System.out.println("\n------ LIST ITERATOR starting index 2 + Iterator------");
        listIteratorIndex = intVector.listIterator(2);
        normalIterator = intVector.iterator();

        while (listIteratorIndex.hasNext()){
            System.out.println("List Iterator: " + listIteratorIndex.next());
            System.out.println("Iterator: "+ normalIterator.next());    
        }
        
    }

}