package lab06.ex2;

import java.io.File;

public class main {
    public static void main(String[] args) {
        ContactsStorageInterface storetext = new Txt_Storage(new File("contacts.txt"));
        ContactsStorageInterface storebin = new Binary_Storage(new File("ex2Binary"));

        ContactsInterface manager = new Agenda();

        manager.openAndLoad(storetext);
    
        System.out.println(manager.toString());
        System.out.println(manager.getByName("Maria"));

        manager.add(new Contact("Chicozitdsknfksfo",69696969));
        System.out.println(manager.toString());

        manager.saveAndClose(storebin);

    }
}
