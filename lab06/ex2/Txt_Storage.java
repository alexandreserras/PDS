package lab06.ex2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Txt_Storage implements ContactsStorageInterface{
    private File textFile;

    public Txt_Storage(File textFile) {
        this.textFile = textFile;
    }
    
    public List<Contact> loadContacts(){
        List<Contact> listContact = new ArrayList<>();
        try {
            File myObj = new File(textFile.getName());
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
              String[] data = myReader.nextLine().split("\t");
              Contact c = new Contact(data[0], Integer.parseInt(data[1]));
              listContact.add(c);
            }
            myReader.close();
            
          } catch (FileNotFoundException e) {
            System.err.println("An error occurred.");
            System.exit(1);
          }
          return listContact;
    }



    public boolean saveContacts(List<Contact> list){
        try {
            FileWriter fileWriter = new FileWriter(textFile.getName());
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Contact ct : list){
                printWriter.printf(ct.toString());
            }
            printWriter.close();
            return true;
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            return false;
        }
    }
}
