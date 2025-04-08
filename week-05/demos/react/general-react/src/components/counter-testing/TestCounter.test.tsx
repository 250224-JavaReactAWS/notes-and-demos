/*
Testing
Let's talk testing in frontend applications. 

Testing in React uses 2 different things: Jest and the RTL (react testing library)
Jest is a unit testing framework designed for javascript applications, you can do a lot of different things
with it and it's the test runner used for testing React applications
RTL (React Testing Library) is a library containing useful tools for rendering React components in a test DOM
allowing you to validate their functionality and ability to do what you want

We can do all kinds of testing include faking API calls or just testing unit logic, we'll focus on the latter
*/

import { fireEvent, render, screen } from "@testing-library/react"
import '@testing-library/jest-dom' // This adds in helpful methods for assestions and things like that
import TestCounter from "./TestCounter"

test('renders initial count (This is the description of what we want to test)', ()=> {

    // AAA
    // Arrange
    // Setup
    render(<TestCounter />) // This renders the component to the test DOM

    // Act
    // There are no actions for this one we just want an inital render

    // Assert
    // Let's retrive the count from the component
    const count = screen.getByTestId('count') // This retrieves the element with data-testid=count
    expect(count).toHaveTextContent('0')
})

// Clearly I'm missing something that needs to be added in
test('clicking increment should increase counter', () => {
    // Arrange
    render(<TestCounter />)

    // Act
    // So here we need to retrieve the button and click it
    const button = screen.getByText("Increment")
    fireEvent.click(button) // This simulates a click event on the button itself

    // Assert
    const count = screen.getByTestId('count')
    expect(count).toHaveTextContent('1')
})

test('clicking decrement should decrease counter', () => {
    // Arrange
    render(<TestCounter />)

    // Act
    // So here we need to retrieve the button and click it
    const button = screen.getByText("Decrement")
    fireEvent.click(button) // This simulates a click event on the button itself

    // Assert
    const count = screen.getByTestId('count')
    expect(count).toHaveTextContent('-1')
})