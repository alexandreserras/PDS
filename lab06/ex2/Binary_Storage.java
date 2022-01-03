package lab06.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Binary_Storage implements ContactsStorageInterface{
    private File textFile;

    public Binary_Storage(File textFile) {
        this.textFile = textFile;
    }

    public List<Contact> loadContacts(){
        List<Contact> listContact = new ArrayList<>();
        try{
            Scanner fileScanner = new Scanner(textFile);
            while (fileScanner.hasNextLine()) {
                String line[] = fileScanner.nextLine().split("\t");
                listContact.add(new Contact(line[0], Integer.parseInt(line[1])));
            }
            fileScanner.close();
            return listContact;
         
        } catch(Exception e){
            System.out.println("[Error] " + e.toString());
        }
        return null;

    }

    public boolean saveContacts(List<Contact> list){
        try {
            FileWriter writer = new FileWriter(textFile.getName());
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            
            for (Contact contact : list) {    
                bufferedWriter.write(contact.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("[Error]: " + e.toString());
            return false;
        }
        return true;
    
    }
}
