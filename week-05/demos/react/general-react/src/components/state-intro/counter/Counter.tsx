import { useState } from "react";

function Counter() {

    /*
    How do I use a state variable? I set it up using the useState HOOK. What is a hook? A hook is a special 
    method that starts with "use..." and allows you to "hook" into different method inside the component 
    lifecycle

    We'll use useState to create a state variable and a setter
    */

    const [counterValue, setCounterValue] = useState(0);

    /*
    What is happening here? So we're creating two different variables here, the first is the state variable
    itself and the second is a setter for the state variable. The initial value of the variable is whatever
    goes into useState(), and we use the setter to update the value as needed

    There is a immutability with state meaning you should never change it directly
    counterValue = 5
    This can cause problems with optimization and can create buggy components so use the setter instead
    setCounterValue(5)

    How are we unpackaging the useState into 2 variables? this is call destructuring and it's a way to unpackage
    the variable and its setter


    One other thing we should talk about is the Virtual DOM
    How does React decide what to rerender and how can it do it efficiently?
    React holds a virtual version of the DOM and when components update their state or the path changes
    or something else that would cause a rerender occurs, the operation is first performed against the virtual dom
    after it has been completed the real DOM is reconciled with the virtual one
    */




    /*
    Goal for this component: I want to have a button that increments a counter and I want to see the live
    value as I increment the counter over and over
    */

    let counter = 0;

    // I'll define a function that increments the counter and prints out the value
    let doSomething = () => {
        console.log("Did something!")
        counter++; // counter += 1
        console.log(counter)

        // Let's use the setter to update the value
        // Increments the counter by one
        setCounterValue(counterValue + 1)
    }
    /*
    What's going on here? Why is the value not rerendering on the screen? Counter is being updated
    every time we click the button but the value on the screen remains at 0. How do we fix this? We use STATE

    What is STATE?
    State is a representation of a component's internal data, it can be used to dynamically rerender a 
    component
    */

  return (
    <div>
      {/* <p>The button has been clicked {counter} times</p> */}
      <p>(Stateful) The button has been clicked {counterValue} times</p>

      {/* Before when we used just JS we set up our event listen by adding in the JS script, we can 
      actually do that on the HTML side as well and this is how we do it. It'll follow the "on..." pattern
      where the stuff after on is the event
      */}
      <button onClick={doSomething}>Click me to do something!</button>
    </div>
  )
}

export default Counter
