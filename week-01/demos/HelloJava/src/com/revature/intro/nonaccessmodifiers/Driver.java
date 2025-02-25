package com.revature.intro.nonaccessmodifiers;

public class Driver {

    public static void main(String[] args){
        // Before when we made a calculator we needed a whole object
        // We might not NEED to do this because a calculator has no instance fields and operates the
        // same way every time

        // Before using static we needed an object before we could call any methods, Now the method belongs to the
        // class itself and we no longer need an object
        System.out.println(Calculator.add(1,2));

        // No object was created we just used the static method from the class

        Employee e1 = new Employee("Bob", "Engineer", 20000);
        Employee e2 = new Employee("Helen", "HR Rep", 10000);

        // Both of these employees will have the same value for the companyName
        System.out.println(e1.companyName);
        System.out.println(e2.companyName);

        // Update the value of the static variable
        Employee.companyName = "Multivision LLC";
        // Notice we're calling on the class itself not on any single variable

        System.out.println(e1.companyName);
        System.out.println(e2.companyName);
    }
}
