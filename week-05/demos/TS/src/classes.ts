/*
As mentioned previously TS is an OOP language, so it focuses on classes and object and it provides support
for different class related things that JS does not have

NOTE: JS does have classes and some OOP functionality but it's not as robust as the solutions provided by TS
*/


class Animal {
    // A Class is a blueprint for an object
    // A class contains several things but typically fields/attributes and methods/behaviors/functions

    // ENCAPSULATION
    // To properly encapsulate our class, we'll leverage access modifiers and getter/setter methods
    // In TS there are 3 access modifiers: public, private, and protected (this means available with this 
    // class and child classes)

    // Instance Variables
    // Variables marked with only a getter or with the readonly keyword are readonly
    // This is basically the same as a final variable in Java, set it and forget it
    readonly _name: string
    private _species: string

    // Static Variables
    // Static variables belong to the class and not any specific instance
    static sampleVariable = 3

    // Constructor
    // A constructor is a special method that allows us to create an object and assign values
    constructor(name: string, species:string){
        this._name = name;
        this._species = species;
    }


    // Getters and Setters
    // These use the get and set keyword and are accessed like variables

    get species(){
        return this._species
    }

    set species(species:string){
        this._species = species
    }

    get name(){
        return this._name
    }

    // Methods
    move(feet: number){
        console.log(`${this._name} moved a total of ${feet} feet`)
    }
    

}

// Let's create an object of that type
let perry = new Animal("Perry", "Platypus")

// Check the values of our variables
console.log(perry.name)
console.log(perry.species) // This is actually calling the getter for the method rather than the variable 
// itself

perry.species = "Turtle" // This is using the setter

console.log(perry)

perry.move(10)

// Calling static members from the class itself
console.log(Animal.sampleVariable)

Animal.sampleVariable = 4

console.log(Animal.sampleVariable)

// Pillars of OOP

// INHERITANCE
// The Dog class extends the Animal Class
class Dog extends Animal{
    // Dogs are Animals so they have access to certain fields and methods in the Animal class

    bark(): void{
        console.log("ARF ARF ARF")
    }

    // POLYMORPHISM
    // Generally this happens in extended classes
    // Overriding
    move(feet: number){
        console.log(`The dog ${this.name} moved a total of ${feet} feet. What a good boy!`)
    }

    // Overloading
    // To overload a method you need to provide different signatures and one final implementing signature
    // that includes all of the other signatures
    // Overloaded methods have different parameters vie types or amounts
    someMethod(a: string): void
    someMethod(a: number): void
    someMethod(a: string, b: string): void
    someMethod(a: string, b: boolean): void
    someMethod(a: number, b: number, c: number, d: number): void
    someMethod(a: string | number, b ?:string | boolean | number, c?:number, d?: number):void{
        // To overload a method you provide all of the possible signatures and then finally a signature at
        // the end which can match any of the others

        // NOTE: The final signature is NOT considered one of the overloaded methods
    }
}

let cash = new Dog("Cash", "Pit Bull")
cash.bark()
cash.move(0)

cash.someMethod("a")


// Abstraction
// Creating a simplified interface for our classes to inherit
abstract class Car{
    // This is an abstract class, we can both abstract and concrete methods
    abstract drive(): void;
    // Since this method is abstract, extending classes need to implement it

    alarm(): void{
        console.log("BEEP BEEP BEEP")
    }
}

// Implementing classes
class Jeep extends Car{
    drive(): void {
        console.log("Fuel Burns, Pistons Turn, exhaust is created, and the Jeep moves forward")
    }
    
}

class Tesla extends Car{
    drive(): void {
        console.log("Drain electricity from the battery, and the Tesla moves forward")
    }
}

let car : Car = new Jeep();
// abstract class = new ImplentingClass()
car.drive();
car.alarm();

// We can switch this to another implementation easily
car = new Tesla()

car.drive()
car.alarm();
