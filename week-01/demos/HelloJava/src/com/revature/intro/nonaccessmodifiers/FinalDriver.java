package com.revature.intro.nonaccessmodifiers;

public class FinalDriver {
    /*
    One of the other non-access modifiers is going to be FINAL. Final can be applied to classes, methods and variables

    Class -> Class can no longer be extended
    Method -> Method can no longer be overridden
    Variable -> Value can no longer change
     */

    public static void main(String[] args){
        Final3 finalObject = new Final3(13);

        System.out.println(finalObject.cannotChange);

//        finalObject.cannotChange = 14;
        // Above doesn't work because the variable is final
    }
}
