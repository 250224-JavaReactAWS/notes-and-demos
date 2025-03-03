package com.revature.oop.abstraction;

public abstract class Car {

    /*
    What is an abstract class?

    An abstract class is a class that can contain both abstract methods (methods with no body) and concrete methods
    (methods that contain a method body).

    You will still need an implementing class for you abstract class and you cannot make an instance of an abstract
    class. It's also good to note that you can't extend more than one class so you may have to use interfaces as well
     */

    public abstract void drive();
    // This method is marked as abstract, there is no method body

    public void honkHorn(){
        System.out.println("BEEEEEEEEEP!");
    }

}
