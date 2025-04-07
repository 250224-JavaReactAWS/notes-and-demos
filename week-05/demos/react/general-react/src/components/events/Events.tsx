import { ChangeEvent, useState } from "react"

function Events() {

    const [stringState, setStringState] = useState('')

    /*
    Recall that in HTML/CSS/JS we had various different events that could be listened for and associated with
    a function. Examples: Clicks, entering data (change event), mouseOver, keyPress

    Let's do a basic example with a button click

    Let's see how we can take in user input
    I want to take in data and have a string variable match it
    */

    let changeString = (e: ChangeEvent<HTMLInputElement>) => {
        /*
        What is this ChangeEvent object? This is a SYNTHETIC EVENT held by React
        What is a Synthetic Event? A Synthetic Event is a wrapper around real DOM events that React uses to
        model different events. Why would it do this? First, it creates reliability across browsers and second,
        through the use of event pooling, if multiple updates are occuring using a sythentic event allows for
        React to effiecently update everything

        By taking in a synthetic event you can do most of the same things you could do with a normal event but
        here we also get type safety by explaining the type of element we're working on
        */
        // e.target directly references the element in question
        // Specifically since this is an input field it should have a value property
        setStringState(e.target.value)
    }


    


  return (
    <div>
        <button onClick={() => console.log("Button Clicked!")}>Click me to do something!</button>
      
        <br />
        <br />
        <br />
        <label>
            {/* Standard practice for these input fields is using value and onChange */}
            Text Field: <input type="text" id="text-field" value={stringState} onChange={changeString} />
        </label>
        <h2>The stored value in the text field is {stringState}</h2>
    </div>
  )
}

export default Events
