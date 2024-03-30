import java.io.File;
import java.io.FileWriter;
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
        System.out.println("wciśnij enter aby zacząć");
        s.nextLine();

        int loop_n = 50000;

        System.out.println("generowanie danych..");

        int[] data = new int[loop_n];
        Random rand = new Random();
        for (int i = 0; i < loop_n; i++) {
            data[i] = rand.nextInt(1000);
        }
        sleep(1000);

        System.out.println("\ndodawianie..");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        int exc_time = measureTime(singleLinkedList,"add",data);
        System.out.println("listajednokierunkowa: "+exc_time+"ms");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        exc_time = measureTime(doubleLinkedList,"add",data);
        System.out.println("listadwukierunkowa: "+exc_time+"ms");

        ArrayList<Integer> arrayList = new ArrayList<>();
        exc_time = measureTime(arrayList, "add", data);
        System.out.println("ArrayList: "+exc_time+"ms");


        System.out.println("\nwyszukiwanie..");

        exc_time = measureTime(singleLinkedList,"search",data);
        System.out.println("listajednokierunkowa: "+exc_time+"ms");

        exc_time = measureTime(doubleLinkedList,"search",data);
        System.out.println("listadwukierunkowa: "+exc_time+"ms");

        exc_time = measureTime(arrayList, "contains", data);
        System.out.println("ArrayList: "+exc_time+"ms");



        System.out.println("\nusuwanie..");

        exc_time = measureTime(singleLinkedList,"remove",data);
        System.out.println("listajednokierunkowa: "+exc_time+"ms");

        exc_time = measureTime(doubleLinkedList,"remove",data);
        System.out.println("listadwukierunkowa: "+exc_time+"ms");

        exc_time = measureTime(arrayList, "remove", data);
        System.out.println("ArrayList: "+exc_time+"ms");
        
    }
    public static int measureTime(Object instance, String method_str, int[] data) {
        // znalezienie funkcji za pomocą stringa
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

        // wykonywanie podanej funkcji
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
