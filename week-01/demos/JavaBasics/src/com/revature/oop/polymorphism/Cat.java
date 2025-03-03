package com.revature.oop.polymorphism;

public class Cat extends Pet{

    @Override
    public void makeSound(){
        System.out.println("The cat meowed loudly");
    }

    @Override
    public void move(int distance){
        System.out.println("The cat gracefully moved "+ distance + " feet.");
    }
}
