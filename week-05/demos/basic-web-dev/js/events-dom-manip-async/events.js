/*
Goal: Make something happen when we perform different events on the page

Eventually this will turn into an HTTP Request but we're not there yet
*/

// First thing we need to do is grab the elements from the DOM
// We can do this by using various Selectors (same ones as CSS actually) but the easiest one is Id

let firstNameInput = document.getElementById("firstNameInput")
let lastNameInput = document.getElementById("lastNameInput")
let usernameInput = document.getElementById("usernameInput")
let passwordInput = document.getElementById("passwordInput")
let createUserButton = document.getElementById("createUserButton")


// The next thing I want to do is create a function that I want executed when the button is clicked

function registerNewUser(){
    // Grab the current values from our input fields and add them to an object
    // This object will eventually be sent as an http request

    // If I want the current value of the input box I will grab the value property
    let firstNameValue = firstNameInput.value

    // We could grab this value from every field but let's just make an object for it
    let user = {
        firstName: firstNameInput.value,
        lastName: lastNameInput.value,
        username: usernameInput.value,
        password: passwordInput.value
    }

    // For now let's just print out the object
    console.log(user)
}

// We have the function at this point but nothing happens when we click the button 
// We need to register this function with the click event that happens when we click on the button
// This is done through an EVENT LISTENER which listens for specific events on specific elements
// If they occur the function is executed

// createUserButton.addEventListener('click', registerNewUser)

// createUserButton.removeEventListener('click', registerNewUser)

// Lets look at a more dubious use case and make a keylogger
// A Keylogger logs all the keys pressed

// Hoisting -> Functions and variable declarations get HOISTED or lifted to the top of their scope
// You can declare a function anywhere in the file and use it wherever you want

passwordInput.addEventListener('keydown', printPressed)

function printPressed(event){
    // This function is going to take the event object. This is passed implicitly when the event happens and
    // we only need to take it if we want information about the event that is occurring. Coordinates, element
    // or in our case the key that has been pressed
    // console.log("The key that pressed was " + event.key)

    // Template Literals
    // In JavaScript, we can inject in variables and code directly into strings by using template literals
    // Wrap text with `` and use ${} to inject a value

    console.log(`The key pressed was ${event.key}`)
}

// NOTE We should've been using email instead of password but it's not a big deal

/*
Async and Await

Also introduced in ES6 were the async and await keywords.
    - Async allows for a function to be treated asynchronously
    - Await is a keyword (only allowed inside async functions) that allows us to directly wait for the value of
    a promise

These were added in to help with handling async calls
*/

async function registerNewUserAPI(){

    let user = {
        firstName: firstNameInput.value,
        lastName: lastNameInput.value,
        email: usernameInput.value,
        password: passwordInput.value
    }

    // Let's construct a fetch request to handle send this info

    let data = await fetch("http://localhost:8080/users/register", {
        // The second thing the fetch request takes in is an initialization object which allows us to 
        // customize the request
        method: "POST",

        // The first time I send this request I had a 415 Unsupported Media Type error and this is because I
        // sent the data as text (this is the default) instead of JSON
        // We can fix this in the request headers
        headers : {
            // Inside of here we'll have various key pairs that help the server parse our request
            'Content-Type': 'application/json'
        },

        // We'll stringify our body by using JSON.stringify
        body: JSON.stringify(user)
    }).catch(err => console.log("Could not register"))

    // The await keyword will allow us to hold the function until a promise has been resolved
    // Convert the response into a JS object (this is also an async function)
    let res = await data.json()

    console.log(res)

    
}

// Add the new event listener
createUserButton.addEventListener('click', registerNewUserAPI)