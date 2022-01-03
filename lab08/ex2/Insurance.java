package ex2;
import java.util.*;


public class Insurance {
    private  List<Person> insurance_persons ;   


    public Insurance(){
        this.insurance_persons=new ArrayList();
    }

    public void regist (Person p){
        insurance_persons.add(p);
    }
}
