package ex2;

import java.util.*;

public class Park {
    private  List<Person> persons; 


    public Park() {
        this.persons=  new ArrayList<>();  
    }

    public void allow (Person p){
        persons.add(p);
    }

}
