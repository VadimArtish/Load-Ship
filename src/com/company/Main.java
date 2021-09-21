package com.company;
import java.util.concurrent.Semaphore;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    static int RandomCargo(){
        return (int)Math.random()*100;
    }
    public static void main(String[] strings) {
        final int number = 3;
        final int numberShip = 5;
        Semaphore sem = new Semaphore(5);
        Tunnel obj = new Tunnel(5, sem, 3);

        for (int i = 0; i < numberShip; i++) {
            new Ship('b', RandomCargo(), obj).start();
            new Ship('c', RandomCargo(), obj).start();
            new Ship('d', RandomCargo(), obj).start();
        }
    }
}
