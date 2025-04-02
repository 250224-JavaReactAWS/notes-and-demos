/*
What exactly is DOM Manipulation?

As mentioned previously we can access certain elements from the DOM and add on event listeners to them
but we can do even more than that and add on different elements and attributes as needed

GOAL: Hook into the DOM and add some elements to the screen
*/

let courses = [
    {
        courseId: 1,
        name: "Intro to Java"
    },
    {
        courseId: 2,
        name: "Icefishing"
    },
    {
        courseId: 3,
        name: "Finance"
    }
]

// Normally all of this information would come from an API but for now we're hard coding
// To add this to the screen we need to highlight our container element
let courseContainer = document.getElementById("courseContainer")

// Let's create a function to populate the courses
function populateCourses(courses){
    // So we want to iterate over our list of courses and append them to the screen

    for (let course of courses){
        // What do I want to do?

        // I will create a div for each course

        let cDiv = document.createElement('div')

        // I will add on the necessary info
        // Let's use some template literals
        // To target the div and add in child elements we'll affect the innerHTML property
        cDiv.innerHTML = `
        <h2>${course.name}</h2>
        <p>Course Id: ${course.courseId} </p>
        `

        // Before appending I might add on some attributes that I can use for styling later
        cDiv.setAttribute('class', 'course')
        cDiv.setAttribute('id', `course-${course.courseId}`)


        // I will add the div to the courseContainer
        courseContainer.append(cDiv)
    } 
}

// Normally this call would happen after an HTTP Request 
// populateCourses(courses)

/*
PROMISES IN JS

A Promise is a special kind of JS object that represents the promise of a future value
Since JS is single-thread it had certain operations that are performed asynchronously to the rest of the
code via the event loop. The event loop is a special api held by the browser that will execute our code in
the background and once a result has been reached it will finishing the executing the desired code

HTTP Calls take time so we need to use a promise to hold a value for them until they actually return


Since promises are the promise of a future value we need handle both successful and unsucessful results
*/

let promise = new Promise(function(resolve, reject) {
    // The Promise Constructor takes a function consisting of 2 callbacks functions
    // The resolve is executed if the promise is successful
    // The reject is executed if the promise fails

    // This would typically be an api call
    let x = 2
    let y = 3

    if (x >= y){
        resolve(x)
    } else{
        reject(x)
    }
})

// Once a promise has been created, it's handed off the the event loop to handle the waiting portion
// Once that has ended we can view the result of the promise through consumer functions
// .then follows the resolve trail
// .catch handles the reject trail

// promise
//     .then(x => x = x * 2)
//     .then(num => console.log(num))
//     .catch(err => console.log("Handling the error!"))
//     .finally(() => console.log("The finally block executes no matter what"))

promise
    .then((x) => console.log("This is like receiving a 200 level HTTP response code"))
    .catch((err) => console.log("This is like running into a 400 or 500 level status code"))
    .finally(() => console.log("This happens regardless of the result"))


// Why is this important?
// Well whenever we make API calls using the Fetch API, they implicitly return a promise which can then
// be chained

/*
Fetch API

The Fetch API is built in JS and is a function designed to allow you to make fully customizable HTTP requests

We plan to use this to get our courses from our backend
The default request for a fetch request is a GET request
*/

let data = fetch("http://localhost:8080/courses")
// This will return a promise so we'll chain some consumer functions off of it

data
    .then((data) => data.json()) // This parses in the JSON string and turns it into a JS object
    .then(res => populateCourses(res)) // Once we have the data fill in the courses with the above function
    .catch(err => console.log(err))

/*
We just ran into our first CORS error. CORS (Cross Origin Resource Sharing) is a security mechanism designed
to help authenticate where your requests are going and the expected destination. The destination of your 
request needs to be ready to accept HTTP calls from your origin/location. We need to do 2 things to resolve this

    - The current origin is null (this is because we're sending the request from a file), we need to host this
    somehow. We'll use the live server extension for this.
    - The backend needs to be ready to accept a request from this resource
*/