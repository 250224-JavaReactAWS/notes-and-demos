/*
Welcome to our first TypeScript file, notice the .ts extension instead of .js

Recall that TypeScript is a TYPED SUPERSET of JavaScript
    - It can do everything JS can do and more
    - It supports strong and typing for compile time safety
    - It's an OOP language focusing around classes/objects and was developed by Microsoft
*/

let sampleVariable : string = "Hello, World!"

// At this point the sample variable is ONLY a string so we can't convert it to another type very easily
// sampleVariable = 6
// sampleVariable = true

sampleVariable = "Another string!"

console.log(sampleVariable)

/*
Datatypes in TS

boolean -> true/false
number -> any number positive negative or decimal
string -> collection of characters defined in "", '', or ``
null -> intentional absence of a value
undefined -> a variable that has not been assigned a value

TS Specific types:
Any
Unknown
Void
Enums
Tuples
Union Types
Arrays
Never
Type Aliases
Interfaces
*/

// TS supports both explicit and implicit type declaration

// Explicit Type Declaration
let x : number = 5
console.log(x)
// x = "String"

// Implicit Type Declaration
let bool = true
console.log(bool)

// bool = "Something Else"

/*
Why do we care so much about type safety?

The main idea of TypeScript is to preserve the functionality of JS but add in strong/static type checking
    - Reduces the amount of "quirks" that JS has like type coercion 
    - Better for larger groups or larger code bases since it's harder to keep track of initial variable types
    - Better Intellisense, basically the IDE helping you autocomplete your code, with types it's easier

In general TS is a good choice if you have a large codebase, or a large team of developers who are used to OOP
languages like Java or C#
*/

// Any
// Any is a datatype you can use to make a variable behave like a JS variable
let y : any = true;

y = "String"

y = 6

// Unknown
// This behaves very simalarly to any but it's used when you don't know the type of the variable
let z : unknown = true

z = "String"

z = 6

/*
What exactly is the difference?

Unknown provides a little more safety than any. With any, any operation can be performed on the variable just
like in JS, but we'll see that TS prevents some bad called on unknown variables
*/
// y.someFunction();
// z.someFunction();
// We can't call a function on z until we cast it to a specific type that we know has that function


// Union Types
// A Union type is the middle road between a single datatype and any. 
// With a union type we declare that a variable can be type1 OR type2

let boolOrString: boolean | string = true;

// This variable can be a boolean OR a string
boolOrString = "String"

// boolOrString = 4;
// I'll leverage this later with Arrays for variables of multiple types

// First function
// Void
// Void is a datatype specific used with functions to denote the function does not return a value
function myFirstFunction(message: string) : void{
    // Notice we specify the message datatype and the function return type
    console.log(message)
}

myFirstFunction("Hello from inside a function")
// myFirstFunction(51) doesn't work because 51 is not a string

// Different Shapes of Data

function sendOfferLetter(emailObject : {email: string, salary: number, position: string}): void{
    // Whenever you receive an offer letter from a company it's usually templated but includes some 
    // inserted data

    console.log(`Hello ${emailObject.email}, we'd like to offer you the position of ${emailObject.position} 
        with a starting salary of ${emailObject.salary}`)
}

// To actually call this function I need to create an object that has the same "Shape" as the email object
let sampleObject = {
    email: "bryan.serfozo@revature.com",
    position: "Application Analyst",
    salary: 90000
}

// To use the function let's pass the entire object to it
sendOfferLetter(sampleObject);

// Let's try to make an object with the wrong data shape
let wrongEmailObject = {
    email: "ethan@revature.com",
    opportunity: "Java Full Stack Trainer",
    compensation: 10
}

// sendOfferLetter(wrongEmailObject);

// What happens if I need to use this shape of data over and over again
/*
The main solutions to this problem are Type Aliases and Interfaces

This will look almost identical in our demo but I think Interfaces have slightly better extensibility so 
we'll leverage those more often than not

We use these to define a shape of data
*/

type EmailType = {
    email: string,
    salary: number,
    position: string
}

// We can leverage this type alias to make variables of this type like so
let emailTypeAlias: EmailType = {
    email: "sample@example.com",
    salary: 15,
    position: "whatever"
}

// I can also leverage this in a function like this
function sendBetterOfferLetter(emailObject: EmailType): void {

}


// Interfaces
// These are also used to define the shape of pieces of data
interface Person {
    firstName: string,
    lastName: string,
    age ?: number, // This field is now OPTIONAL
    isMarried: boolean
}

let p1 : Person = {
    firstName: "John",
    lastName: "Smith",
    age: 37,
    isMarried: true
}

// When I was a child I was always told it's rude to ask someone's age so let's remove it as a required field
let p2: Person = {
    firstName: "Jane",
    lastName: "Doe",
    isMarried: false
}

// Interfaces and Type Aliases DO NOT GET TRANSPILED into JS at all


// Never
// Never is an interesting type, it represents a value that can NEVER occur

function neverFunction(): never{
    // This function would only ever be able to throw an exception
    throw new DOMException();
}

let numberOrString : number | string = 1;

if (typeof numberOrString === "number"){
    console.log("number")
} else if (typeof numberOrString === "string"){
    console.log("string")
} else{
    numberOrString;
}