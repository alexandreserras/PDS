package ex2;

import java.util.*;

public class SocialSecurity {
    private  List<Person> ss_persons; 


    public SocialSecurity() {
        this.ss_persons=  new ArrayList<>();  
    }

    public void regist (Person p){
        ss_persons.add(p);
    }


}
