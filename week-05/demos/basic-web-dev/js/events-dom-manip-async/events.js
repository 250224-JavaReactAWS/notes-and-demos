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

createUserButton.addEventListener('click', registerNewUser)

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