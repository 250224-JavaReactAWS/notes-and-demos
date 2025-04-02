/*
This is a multiline comment in JavaScript


What is JavaScript (JS)?
If HTML is the structure and content of the webpages and CSS is the styling, JS is in charge of the functionality
    - Click a button
    - Drag something across the screen
    - Make an HTTP Call

Notes About JS:
- High Leveled
    This means it has automatic memory management and garbage collection, it's futher away from machine code
    and closer to human readable syntax
- Dynamic and Weak typing
    - Static vs Dynamic Typing: In a statically typed language like Java, datatypes are determined at compile 
    time, meaning we need to declare our datatype. In a dynamically typed language the datatype can change
    at runtime.
    - Strong vs Weak Typing: In a strongly typed language, you'd expect the datatype of a variable to NOT change
    during operations unless explicitly told to (casting).
- Single-Threaded
    - There's only one execution thread so it cannot acheive multithreading like Java.
- Multi-paradigmed
    - Supports several different types of programming including OOP, functional, and procedural programming
- Interpreted
    - Compiled vs Interpreted: A compiled language like java compiles the entire project before executing and 
    checks for syntax errors throughout the code. Interpreted languages compile the code one line at a time as 
    needed.
- Use Cases
    Typically the primary use case for JS is providing functionality to webpages, but it can also be used in 
    a server environment thanks to the NodeJS runtime
- Is JavaScript related to Java?
    While the syntax may seem similar they are not directly related, JS actually called itself JavaScript to 
    take advantage of the popularity of Java.
*/

// Whenever learning a new language, we want to quickly double back through the basics to make sure we 
// know how to do them (declaring variables, control flow)

var x = 10;
// Notice that I don't have to declare a datatype or anything like that
x = "Ten"
x = false
x = true
x = {
    name: "Bryan"
}
x = 10;

// Since the datatype can change at runtime, all of these values are valid
// How would I go about printing this information
console.log(x)
console.log("Hello, World!")

// Since the browser is the main runtime for the code (for now), we need to check the browser's console to see
// the information print out

/*
Let and Const

What are let and const? These are keywords that were introduced as a different way to declare variables in ES6
    - Let is basically the same thing as var
    - Const allows for a constant variable (note the object can still change if the variable is an object)
Why are there different ways to declare variables?
    This was a problem with the var keyword, all variables declared with it were globally scoped which can 
    create a problem for various namespaces so let and const were introduced to remedy this by using local scope.
What is ES6?
    The standards for JavaScript are derived from ECMAScript, ES6 was a version of ECMAScript that included this
    feature along with several other
*/

let y = 5;

y = "five";

const z = 6;

// z = "six"

console.log(y)
console.log(z)

/*
Datatypes

Just because we're not declaring a datatype doesn't mean that JS doesn't have them. There are a couple of main
ones we'll need to remember

Primitives:
    Boolean: True or False
    Number: Any number, positive or negative and decimals as well
    String: A string of text defined with "", '', ``
    Undefined: This is for variables that have been declared but not initialized with a value
    Null: Intentional absence of a value
    BigInt: Skipping for now
    Symbol: Skipping for now

Objects:
    Objects in JavaScript are created using key-value pairs and should look familiar to JSON
    JSON Stands for JavaScript Object Notation so it's a string that matches how we declare objects in JavaScript
*/

let sampleObject = {
    username:"BryanSerfozo",
    password: "Password",
    empId: 51,
    isMarried: false
}

// Control Flow
// Always important to know control flow for your programming languages

// If-Else Statements

let a = 0;

if (a > 0){
    console.log("A is positive!")
} else if (a < 0){
    console.log("A is negative!")
} else {
    console.log("A is zero")
}

// For Loops
for(let i = 1; i<=5; i++){
    console.log("The value of i is " + i)
}

// While Loops
// Execute until a condition is false
let day = "Saturday"

while (day != "Friday"){
    console.log("The current day is " + day)
    if (day == "Monday"){
        day = "Tuesday"
    } else if (day == "Tuesday"){
        day = "Wednesday"
    } else if (day == "Wednesday"){
        day = "Thursday"
    } else if (day == "Thursday"){
        day = "Friday"
    } else if (day == "Friday"){
        day = "Saturday"
    } else if (day == "Saturday"){
        day = "Sunday"
    } else {
        day = "Monday"
    }
}

console.log("The day is now Friday, enjoy your weekend!")

console.log('-----------------------------')

// Do While Loops
do{
    console.log("The day is not friday!")
    // This executes even though the day is in fact friday
} while (day != "Friday")

// Special For Loops
// For-of loop
// These are used for iterable objects like Arrays in JS
let simpleArray = [1,2,3,4,5,15]

// For of loops allow us to interact with every value in the array
for(let num of simpleArray){
    console.log(num)
}

// For-in loop
// Used to iterate over the properties of an object
let person = {
    name: "Kaitlyn",
    age: 25,
    isMarried: false
}

// I can iterate over this using the for-in loop
for (let prop in person){
    console.log(prop + ": " + person[prop])
}