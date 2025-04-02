/*
Arrays are the most common datastructure inside of JS
They are very similar to Lists in Java

Arrays in Java are fixed length, ordered/indexable, and allow duplicates
Lists in Java are dynamically sized, ordered/indexable, and allow duplicates

Arrays in JS are dynamically sized, ordered/indexable, and allow duplicates
Main difference is that a JS array can hold many types of object
*/

let simpleArray = [1, "true", false, {property: "value"}, 1]

// We saw earlier that we can iterate over this structure using a for-of loop

// To add new items use the push method
simpleArray.push(2)

console.log(simpleArray)

// We can insert at a specific index by splicing
// This takes 3 args: start index, number of elements to delete, inserted object
simpleArray.splice(1, 0, "Spliced In")

console.log(simpleArray)

// Removal of elements
// To remove from the beginning you shift
// To remove from the end you pop
let x = simpleArray.shift()
let y = simpleArray.pop()

console.log(x)
console.log(y)
console.log(simpleArray)

// There are several other functions we can use like map, filter or foreach
// The foreach method takes in something called a callback function, which is basically a function passed to 
// another function

simpleArray.forEach(function(x){
    // This is specifically called an anonymous function since it does not have a name
    console.log(x)
})

// Arrow functions
// These were introduced in ES6 and are very very similar to lambdas in Java
// Arrows functions are commonly used for callback functions

simpleArray = simpleArray.filter(x => {
    return !!(x); // This is a simple conversion to a boolean value
})

console.log(simpleArray)
