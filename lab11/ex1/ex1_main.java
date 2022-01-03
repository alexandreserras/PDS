package lab11.ex1;

import java.util.Scanner;

public class ex1_main {
    public static void main(String[] args) {
        int op=0;
        Scanner sc = new Scanner(System.in);
        
        Phone p1 = new Phone(4,64,32,406.8,"IPhone XS Max");
        Phone p2 = new Phone(2,32,20,200.0,"Samsung Galaxy");
        Phone p3 = new Phone(1,2,2,50,"Nokia 3310");
        Context c = new Context(new BubbleSort());
        
        Phone[] phone_array = {p1,p2,p3};
        for (Phone p : phone_array){
            System.out.println(p);
        }
        while(true){
            System.out.println("Ordenar por:\n 1- Processador\n2- Memória\n3- Câmara\n4- Preço");
            try {
                op = sc.nextInt();
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("int expected");
                System.exit(0);
            }
            
            switch (op){
                case 1:
                    c.setAlgorithm(new BubbleSort());
                    c.sort(phone_array, "Processador");
                    break;
                case 2:
                    c.setAlgorithm(new BubbleSort());
                    c.sort(phone_array, "Memória");
                    break;
                case 3:
                    c.setAlgorithm(new QuickSort());
                    c.sort(phone_array, "Câmara");
                    break;
                case 4:
                    c.setAlgorithm(new InsertionSort());
                    c.sort(phone_array, "Preço");
                    break;
                default:
                    System.out.println("Não existe");
                    System.exit(0);
            }
        }


    }
}
