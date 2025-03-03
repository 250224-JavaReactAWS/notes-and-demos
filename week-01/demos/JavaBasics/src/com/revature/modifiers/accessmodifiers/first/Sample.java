package com.revature.modifiers.accessmodifiers.first;

public class Sample {
    /*
    Access Modifiers are modifiers that can be applied to classes, methods and variables and they control where things
    are visible/accessible.

    4 Types
        - Public
            - Accessible EVERYWHERE in the code, this is the least restrictive
        - Protected
            - Accessible within the package and within subclasses outside the package
        - Default
            - This is no access modifier and it's only visible within the same package
        - Private
            - Accessible only within the same class, this is the MOST restrictive

    The most important takeaways from this are PUBLIC and PRIVATE. Public is the least restrictive and accessible
    EVERYWHERE, private is the most restrictive and only accessible inside the same class it's declared.
     */

    public String A;
    protected String B;
    String C;
    private String D;

    public void sampleMethod(){
        this.A = "First";
        this.B = "Second";
        this.C = "Third";
        this.D = "Fourth";
    }
}
