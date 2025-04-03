"use strict";
/*
Enums are just like enums in Java, they're an enumerated list of constants

These are usually used for when you have a series of values you need to access over and over
*/
// Number enums
var Roles;
(function (Roles) {
    // This may not look like it, but this is a numeric enum. Every constant is associated with a value,
    // by default it starts at 0 and increments from there
    Roles[Roles["Customer"] = 1] = "Customer";
    Roles[Roles["Teller"] = 2] = "Teller";
    Roles[Roles["Admin"] = 3] = "Admin"; // 3
})(Roles || (Roles = {}));
function printRoles(role) {
    console.log(role);
}
// Test our function
printRoles(Roles.Customer);
printRoles(Roles.Admin);
// When might we want to use this?
var StatusCodes;
(function (StatusCodes) {
    StatusCodes[StatusCodes["OK"] = 200] = "OK";
    StatusCodes[StatusCodes["CREATED"] = 201] = "CREATED";
    StatusCodes[StatusCodes["BAD_REQUEST"] = 400] = "BAD_REQUEST";
    StatusCodes[StatusCodes["UNAUTHORIZED"] = 401] = "UNAUTHORIZED";
    StatusCodes[StatusCodes["PAYMENT_REQUIRED"] = 402] = "PAYMENT_REQUIRED";
    StatusCodes[StatusCodes["FORBIDDEN"] = 403] = "FORBIDDEN";
    StatusCodes[StatusCodes["NOT_FOUND"] = 404] = "NOT_FOUND"; // 404
})(StatusCodes || (StatusCodes = {}));
function isErrorStatusCode(code) {
    if (code >= 400) {
        return true;
    }
    return false;
}
console.log(`Is this an error code? ${isErrorStatusCode(StatusCodes.OK)}`);
// String enums
// I would argue are a little less useful
// These are enums associated with a string
var Directions;
(function (Directions) {
    Directions["NORTH"] = "UP";
    Directions["EAST"] = "RIGHT";
    Directions["SOUTH"] = "DOWN";
    Directions["WEST"] = "LEFT";
})(Directions || (Directions = {}));
