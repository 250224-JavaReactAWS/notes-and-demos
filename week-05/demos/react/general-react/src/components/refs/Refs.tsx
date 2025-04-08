import { useRef, useState } from "react";


function Refs() {
    /*
    What exactly are Refs? Refs (references) is a way to get your component to remember some information without 
    rerendering it like a state variable. This is useful for certain DOM operations as well as occasionally
    optimizing your code but it shouldn't always be used

    Think of refs like a variable that doesn't cause React to re-render the screen
    */

    // This is a simple basic variable
    let counter = 0;

    // If we want to rerender the component to show the current count we need to use State
    let [counterState, setCounterState] = useState(0)

    /*
    After adding in the state variable the line console.log(counter) is only ever printing 1 despite me
    clicking the button several times. WHY?
    Regular variables defined with let and const are reinitialized on re-render, meaning every time we
    update the state variable the value resets

    How do we change this functionality?
    Use the useRef hook
    */

    let counterRef = useRef(0)
    // This gets defined like a regular variable using the useRef function and its value will persist 
    // between rerenders but changing this will not force React to rerender


    let increment = () => {
        counter++;
        console.log("Basic counter: " + counter)

        // Increment the state variable as well
        setCounterState(counterState + 1)

        // To use a ref we can directly mutate its "current" value field and use that
        counterRef.current++

        console.log("Refs value: " + counterRef.current)
    }

    // While this example does show the updated value (because the state variable is forcing the rerender)
    // updating the value directly does not actually force a rerender
    let updateRef = () => {
        counterRef.current++
    }

    /*
    Other things we can do with refs
    Refs are a direct reference to the DOM and should only really be used if working with an external system
    or if you want to do something react doesn't have direct functionality for.
    Examples: Focusing on a DOM node, scrolling to the node or measuring its size or position
    */

    // Creating a ref for focusing on an input element
    const inputRef = useRef<any>(null)

    // I'm going to set up a function to handle a focus function
    let focusInputOnClick = () => {
        inputRef.current.focus();
    }


  return (
    <div>
      <p>The value of the counter variable is {counter}</p>
      <p>(Stateful) The value of the state counter variable is {counterState}</p>
      <p>(Using Refs) The value of the counter ref is {counterRef.current}</p>
      <button onClick={increment}>Increment the counter</button>
      <button onClick={updateRef}>Only increment the ref</button>

      <br />
      <br />
      <br />
      <br />

      <input placeholder="Click the button to focus on me" ref={inputRef}/>
      <button onClick={focusInputOnClick}>Focus on input</button>
    </div>
  )
}

export default Refs
