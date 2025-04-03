"use strict";
/*
Arrays in TS

Arrays in TS are almost identical to the ones in JS (ordered/indexable, dynamic in length, allow duplicates)
The major difference is that you need to specify the datatype of the Array
*/
let numArray = [1, 2, 3, 4, 5];
// All of the same datatypes from before can be used here
let stringOrBoolArray = ["String 1", "String 2", false, true];
let anyArray = [1, "String", false, {}];
// We can also define them using Generics which behave just like they do in Java
let genericArray = [1, false, 2];
/*
Tuples
Tuples look very similar to Arrays, but they are NOT THE SAME THING
Tuples are FIXED LENGTH, and we specify the datatype at every specific point
*/
// Let's use an HTTP Response for an example
// An HTTP response is broken in 3 parts: status code, a series of headers, response body
let httpResponse;
// This creates a variable that holds EXACTLY 3 elements: number, a string array, and a regular string
httpResponse = [201, ["Content-Type=application/json"], "{'username':'johndoe'}"];
// This is pretty useful when returning multiple values out of a function
httpResponse[0] = 200;
console.log(httpResponse);
