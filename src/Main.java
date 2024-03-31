import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Thread.sleep;
import java.lang.reflect.Method;

public class
Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        int[] data = null;
        while(data==null){
            System.out.println("\n-- Super mega java tester 2000 --");

            File file = new File("data.txt");

            System.out.println("1) Wygeneruj nowe dane");
            if (file.exists())
                System.out.println("2) Wczytaj z data.txt");

            int choice = s.nextInt();
            switch (choice){

                // nowe dane
                case 1:
                    System.out.print("Ile danych wygenerować: ");
                    int loop_n = s.nextInt();

                    System.out.println("Generowanie..");
                    data = new int[loop_n];
                    Random rand = new Random();
                    for (int i = 0; i < loop_n; i++) {
                        data[i] = rand.nextInt(100000);
                    }

                    try{
                        FileWriter writer = new FileWriter("data.txt");
                        for (int i = 0; i < loop_n; i++) {
                            writer.write(data[i] + "\n");
                        }
                        writer.close();
                        System.out.println("Zapisano do data.txt");
                    } catch (Exception e){
                        System.out.println("Nie udało się zapisać danych");
                        data=null;
                    }
                    break;

                // odczyt z pliku
                case 2:
                    if(!file.exists()){break;}

                    try{
                        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
                        int i = 0;
                        while (reader.readLine() != null) i++;

                        reader = new BufferedReader(new FileReader("data.txt"));
                        data = new int[i];

                        i=0;
                        String line;
                        while ((line = reader.readLine()) != null){
                            data[i]=Integer.parseInt(line);
                            i++;
                        };
                        System.out.println("Wczytano dane z pliku: "+i+" linijek");

                    } catch (Exception e) {
                        System.out.println("Nie udało się wczytać danych");
                        data=null;
                    }
            }

        }

        System.out.println("\nWciśnij enter aby rozpocząć testy");
        s.nextLine();
        s.nextLine();


        System.out.println("\ndodawianie..");
        String out="DODAWANIE\n";

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        int exc_time = measureTime(singleLinkedList,"add",data);
        out+=dataStr("lista jednokierunkowa",exc_time);

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        exc_time = measureTime(doubleLinkedList,"add",data);
        out+=dataStr("lista dwukierunkowa",exc_time);

        ArrayList<Integer> arrayList = new ArrayList<>();
        exc_time = measureTime(arrayList, "add", data);
        out+=dataStr("ArrayList",exc_time);


        System.out.println("\nwyszukiwanie..");
        out+="\nWYSZUKIWANIE\n";

        exc_time = measureTime(singleLinkedList,"search",data);
        out+=dataStr("lista jednokierunkowa",exc_time);

        exc_time = measureTime(doubleLinkedList,"search",data);
        out+=dataStr("lista dwukierunkowa",exc_time);

        exc_time = measureTime(arrayList, "contains", data);
        out+=dataStr("ArrayList",exc_time);


        System.out.println("\nusuwanie..");
        out+="\nUSUWANIE\n";

        exc_time = measureTime(singleLinkedList,"remove",data);
        out+=dataStr("lista jednokierunkowa",exc_time);

        exc_time = measureTime(doubleLinkedList,"remove",data);
        out+=dataStr("lista dwukierunkowa",exc_time);

        exc_time = measureTime(arrayList, "remove", data);
        out+=dataStr("ArrayList",exc_time);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));
            writer.write(out);
            writer.close();
            System.out.println("\nZapisano wyniki do results.txt");
        } catch (Exception e) {
            System.out.println("\nNie udało się zapisać wyników.");
        }

    }
    public static String dataStr(String name, int time){
        System.out.println(name+": "+time+"ms");
        return name+": "+String.valueOf(time)+"ms\n";
    }
    public static int measureTime(Object instance, String method_str, int[] data) {
        // finding function with string reference
        Method method;
        try {
            Class<?> clazz = instance.getClass();
            try{
                method = clazz.getMethod(method_str, Object.class);
            } catch (NoSuchMethodException e){
                method = clazz.getDeclaredMethod(method_str, int.class);
            }
        } catch (NoSuchMethodException e){
            System.out.println("Funkcja \""+method_str+"\" nie istnieje");
            return 0;
        }

        // performing finded function
        long start_time = System.currentTimeMillis();
        try{
            for (int d: data) {
                method.invoke(instance, d);
            }
        }catch (Exception e){
            return 0;
        }
        long end_time = System.currentTimeMillis();
        return (int) (end_time - start_time);
    }
}
