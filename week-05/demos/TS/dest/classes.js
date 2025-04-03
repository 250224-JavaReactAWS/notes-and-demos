"use strict";
/*
As mentioned previously TS is an OOP language, so it focuses on classes and object and it provides support
for different class related things that JS does not have

NOTE: JS does have classes and some OOP functionality but it's not as robust as the solutions provided by TS
*/
class Animal {
    // Constructor
    // A constructor is a special method that allows us to create an object and assign values
    constructor(name, species) {
        this._name = name;
        this._species = species;
    }
    // Getters and Setters
    // These use the get and set keyword and are accessed like variables
    get species() {
        return this._species;
    }
    set species(species) {
        this._species = species;
    }
    get name() {
        return this._name;
    }
    // Methods
    move(feet) {
        console.log(`${this._name} moved a total of ${feet} feet`);
    }
}
// Static Variables
// Static variables belong to the class and not any specific instance
Animal.sampleVariable = 3;
// Let's create an object of that type
let perry = new Animal("Perry", "Platypus");
// Check the values of our variables
console.log(perry.name);
console.log(perry.species); // This is actually calling the getter for the method rather than the variable 
// itself
perry.species = "Turtle"; // This is using the setter
console.log(perry);
perry.move(10);
// Calling static members from the class itself
console.log(Animal.sampleVariable);
Animal.sampleVariable = 4;
console.log(Animal.sampleVariable);
// Pillars of OOP
// INHERITANCE
// The Dog class extends the Animal Class
class Dog extends Animal {
    // Dogs are Animals so they have access to certain fields and methods in the Animal class
    bark() {
        console.log("ARF ARF ARF");
    }
    // POLYMORPHISM
    // Generally this happens in extended classes
    // Overriding
    move(feet) {
        console.log(`The dog ${this.name} moved a total of ${feet} feet. What a good boy!`);
    }
    someMethod(a, b, c, d) {
        // To overload a method you provide all of the possible signatures and then finally a signature at
        // the end which can match any of the others
        // NOTE: The final signature is NOT considered one of the overloaded methods
    }
}
let cash = new Dog("Cash", "Pit Bull");
cash.bark();
cash.move(0);
cash.someMethod("a");
// Abstraction
// Creating a simplified interface for our classes to inherit
class Car {
    // Since this method is abstract, extending classes need to implement it
    alarm() {
        console.log("BEEP BEEP BEEP");
    }
}
// Implementing classes
class Jeep extends Car {
    drive() {
        console.log("Fuel Burns, Pistons Turn, exhaust is created, and the Jeep moves forward");
    }
}
class Tesla extends Car {
    drive() {
        console.log("Drain electricity from the battery, and the Tesla moves forward");
    }
}
let car = new Jeep();
// abstract class = new ImplentingClass()
car.drive();
car.alarm();
// We can switch this to another implementation easily
car = new Tesla();
car.drive();
car.alarm();
