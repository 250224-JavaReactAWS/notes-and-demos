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
populateCourses(courses)