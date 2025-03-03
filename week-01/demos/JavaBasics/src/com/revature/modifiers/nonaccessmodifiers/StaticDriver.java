package com.revature.modifiers.nonaccessmodifiers;

public class StaticDriver {
    /*
    Non-Access modifiers are modifiers that can be applied that don't deal with accesibility.

    - Static
        - This brings members of classes to the Class level (methods and variables). Nothing belongs to a single
        instance
    - Final
        - This can be used on classes, methods, and variables
            - Final Classes cannot be extended
            - Final Methods cannot be overridden
            - Final variables cannot be reassigned
    - Abstract
        - This can apply to classes and methods
            - Method -> Only in abstract classes/ interfaces. The method does not currently require a method body
            - Class -> Class cannot be instantiated and can contain both abstract and concrete methods
     */

    public static void main(String[] args){
        Employee e1 = new Employee("John");
        Employee e2 = new Employee("Dana");
        Employee e3 = new Employee("Jimmy");

        // Let's check the values of their names and their company name
        // COMPANY NAME IS STATIC SO ALL INSTANCES SHARED THE VALUE
        System.out.println(e1.name);
        System.out.println(e1.companyName);
        System.out.println(e2.name);
        System.out.println(e2.companyName);
        System.out.println(e3.name);
        System.out.println(e3.companyName);

        // Change the company name it should change for all employees
        Employee.companyName = "Multivision LLC";

        System.out.println(e1.name);
        System.out.println(e1.companyName);
        System.out.println(e2.name);
        System.out.println(e2.companyName);
        System.out.println(e3.name);
        System.out.println(e3.companyName);

        e1.companyGreeting(); // Instance method
        Employee.companyGreeting(); // Static Method (accessed from the class itself)
    }
}
