package com.revature.intro.accessmodifiers;

public class Sample {

    /*
    Access modifiers are another important topic that we need to cover before continuing OOP

    Access modifiers control where we can access different members (classes, variables, and methods)
    Everything has some sort of access modifier and it's usually the first word on the member

    There are 4 modifiers:
    Public -> Is visible anywhere in the program
    Protected -> Is visible in this package and all subclasses even outside the package
    Default -> Exists when no modifier is present, is visible within the same package
    Private -> Is visible within the same class only

    Public and Private the MOST important
     */

    public String A;

    protected String B;

    String C; // DEFAULT

    private String D;

    public void printD(){
        System.out.println(D);
    }
}
