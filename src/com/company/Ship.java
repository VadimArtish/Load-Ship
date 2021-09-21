package com.company;

public class Ship extends Thread {
    private char typeShip;
    private int gruz;
    private Tunnel obj;

    Ship(char typeShip, int gruz, Tunnel obj) {
        super("name");
        this.typeShip = typeShip;
        this.gruz = gruz;
        this.obj = obj;
        run();
    }

    public char getTypeShip() {
        return typeShip;
    }

    public int getGruz() {
        return gruz;
    }

    public Tunnel getObj() {
        return this.obj;
    }

    public void run() {
        this.getObj().tunnelDog(this);
    }
}