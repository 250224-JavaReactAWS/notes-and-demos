/*
Enums are just like enums in Java, they're an enumerated list of constants

These are usually used for when you have a series of values you need to access over and over
*/

// Number enums

enum Roles {
    // This may not look like it, but this is a numeric enum. Every constant is associated with a value,
    // by default it starts at 0 and increments from there
    Customer = 1,
    Teller, // 2
    Admin // 3
}

function printRoles(role: Roles){
    console.log(role)
}

// Test our function
printRoles(Roles.Customer)
printRoles(Roles.Admin)

// When might we want to use this?
enum StatusCodes {
    OK = 200,
    CREATED, // 201
    BAD_REQUEST = 400,
    UNAUTHORIZED, // 401
    PAYMENT_REQUIRED, //402
    FORBIDDEN, // 403
    NOT_FOUND // 404
}

function isErrorStatusCode(code: StatusCodes){
    if (code >= 400){
        return true;
    }
    return false;
}

console.log(`Is this an error code? ${isErrorStatusCode(StatusCodes.OK)}`)


// String enums
// I would argue are a little less useful
// These are enums associated with a string

enum Directions{
    NORTH = "UP",
    EAST = "RIGHT",
    SOUTH = "DOWN",
    WEST = "LEFT"
}