package lab06.ex2;
import java.util.*;
import java.io.File;


public class Agenda implements ContactsInterface{
    private List<Contact> contacts ;
    private ContactsStorageInterface store;
    
    public void openAndLoad(ContactsStorageInterface store){
        this.contacts = store.loadContacts();
        this.store = store;
    }
    
    public void saveAndClose(){
        this.store.saveContacts(contacts);
    }
    
    public void saveAndClose(ContactsStorageInterface store){
        this.store = store;
        this.store.saveContacts(contacts);
    }
    
    public boolean exist(Contact contact){
        if(contacts.contains(contact)){
            return true;
        }
        return false;
    }
    
    public Contact getByName(String name){
        for (Contact ct : contacts){
            if (ct.getName().equals(name)){
                return ct;
            }
        }
        return null;
    }
    
    public boolean add(Contact contact){
        if (!contacts.contains(contact)){
            contacts.add(contact);
            return true;
        }
        return false;
    }
    public boolean remove(Contact contact){
        if (contacts.contains(contact)){
            contacts.remove(contact);
            return true;
        }
        return false;
    }


    public Agenda() {
        this.contacts = new ArrayList<>();
    }


    
    public String toString() {
        for(int i = 0; i < contacts.size(); i++){
            System.out.println(contacts.get(i));
        }
        return "";
    }

    
}
