package com.company;

import java.util.concurrent.Semaphore;

public class DockShip {
    private int numberTime;
    private Semaphore sem;
    private char typeDock;

    DockShip(Semaphore sem, int numberTime, char TypeDock) {
        this.sem = sem;
        this.numberTime = numberTime;
        this.typeDock = TypeDock;
    }

    public boolean check(Ship obj) {
        if (this.typeDock == obj.getTypeShip()) return true;
        else return false;
    }

    public void loading(Ship shipObj) {
        try {
            sem.acquire();
            int cargo = 0;
            while (shipObj.getGruz() < cargo) {
                cargo += 10;
            }
            System.out.println("Корабль заполнен! " + shipObj.getTypeShip());
            sem.release();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}