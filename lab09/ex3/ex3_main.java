package lab09.ex3;

import java.util.ArrayList;

public class ex3_main {
    public static void main(String[] args) {
        ArrayList<String> ourList = new ArrayList<>();
        Comando_Add<String> addCommand = new Comando_Add<>(ourList);
        Comando_Remove <String> removeCommand = new Comando_Remove<>(ourList);

        addCommand.execute("Hello");
        addCommand.execute("World");

        System.out.println("Size: "+ourList.size());
        if(ourList.size()>1){
            System.out.println("index 0: " + ourList.get(0));
            System.out.println("index 1: " + ourList.get(1));
        }

        addCommand.undo();
        System.out.println("index 0: " + ourList.get(0));

        removeCommand.execute("Hello");
        System.out.println("Size: " + ourList.size());

        removeCommand.undo();
        System.out.println("index 0: " + ourList.get(0));
    }
}