/*
Functions in JS are very similar to how they are in Java
Basically just a repeatable block of code we can sometimes call with parameters
*/

function simpleFunction(){
    // Notice that unlike java I don't have to declare any datatypes or return information for the function
    // I basically just need the name and parameters
    console.log("I'm in a function!")
}

// To execute a function we call it just like Java
simpleFunction();

// Let's take in a parameter now
function isEven(num){
    if (num % 2 == 0){
        return "Even"
    } else {
        return "Odd"
    }
}

console.log(isEven(7))
console.log(isEven(4))

// Default Values
// Similar to an overloaded method in Java, but we can provide default parameter values for our function
// in the case they are not provided
function multiply(x, y = 2){
    // In the event they do not add in a y value, we just use 2
    return x * y;
}

console.log(multiply(3,4)) // 12
console.log(multiply(8)) // 8*2=16

// Fun Quirks of JS
// Truthy/Falsy and Type Coercion

let str = ""

if (str){
    console.log("String is true")
} else {
    console.log("String is false")
}

/*
What exactly is happening here?
JS is attempting to convert whatever value we have into true/false
1. If the value is not falsy, it's truthy

Falsy Values (All of these will convert into false, ANY other value will be true):
    false
    null
    undefined
    empty string,
    0,
    NaN

Any value that is NOT THESE will evaluate to true
*/