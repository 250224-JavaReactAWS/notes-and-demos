package com.revature.oop.abstraction;

public class Jeep extends Car{
    // Jeeps are gas powered so they differently from a tesla so they have a different implementation for drive

    @Override
    public void drive() {
        System.out.println("The gas powered jeep drove noisily");
    }
}
