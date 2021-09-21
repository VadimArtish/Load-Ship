package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Tunnel {
    private int size;
    private int number;
    Semaphore sem;
    private ArrayList<DockShip> dockList;
    private Semaphore semaph;

    Tunnel(int size, Semaphore sem, int number) {

        semaph = new Semaphore(number);
        number = 0;
        this.size = size;
        this.sem = sem;

        dockList = new ArrayList<DockShip>(
                Arrays.asList(
                        (new DockShip(semaph, 10, 'b')),
                        (new DockShip(semaph, 10, 'c')),
                        (new DockShip(semaph, 10, 'd')))
        );
    }

    public int getNumber() {
        return this.number;
    }

    public void tunnelDog(Ship objShip) {
        try {
            sem.acquire();
            if (number <= 5) {
                number++;
                System.out.println("Корабль зашел в порт " + objShip.getTypeShip());
                for (int i = 0; i < 3; i++) {
                    if (dockList.get(i).check(objShip)) dockList.get(i).loading(objShip);
                }
                number--;
                System.out.println("Корабль покинут порт с грузом! " + objShip.getTypeShip());
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        sem.release();
    }
}