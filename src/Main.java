import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class
Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner s = new Scanner(System.in);
        System.out.println("wciśnij enter aby zacząć");
        s.nextLine();

        int loop_n = 100000;

        System.out.println("generowanie danych..");

        int[] data = new int[loop_n];
        Random rand = new Random();
        for (int i = 0; i < loop_n; i++) {
            data[i] = rand.nextInt(1000);
        }

        long end_time = System.currentTimeMillis();
        long start_time = System.currentTimeMillis();
        System.out.println(start_time);
        int exc_time = 0;
        System.out.println("\nWstawianie danych");

        SingleLinkedList list_1 = new SingleLinkedList();
        sleep(500);
        start_time = System.currentTimeMillis();
        for (int i = 0; i < loop_n; i++) {
            list_1.add(data[i]);
        }
        end_time = System.currentTimeMillis();
        exc_time= (int)(end_time-start_time);
        System.out.println("tablica jednokierunkowa: "+exc_time+"ms");


        DoubleLinkedList list_2 = new DoubleLinkedList();
        sleep(500);
        start_time = System.currentTimeMillis();
        for (int i = 0; i < loop_n; i++) {
            list_2.add(data[i]);
        }
        end_time = System.currentTimeMillis();
        exc_time= (int)(end_time-start_time);
        System.out.println("tablica dwukierunkowa: "+exc_time+"ms");

    }
}