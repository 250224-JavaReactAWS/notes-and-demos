import { useState } from "react"


function ConditionalRendering() {

    /*
    What is conditional rendering?

    So we've sometimes seen this before but I wanted to highlight it explicitly, conditional rendering is
    the ability to render something on the screen based off certain conditions. We technically see this with
    the different routes that are available but we can also do this with a state variable. Typically the
    ternary operator is used here
    */    

    const [isLoggedIn, setIsLoggedIn] = useState(false);


    /*
    Interative Rendering
    We can render multiple copies of an element(s) based off the data inside of an array by mapping
    We take the value from the array and map it to a series of elements

    When doing iterative rendering you should always add a Key prop to the elements to help react in the event
    any updates need to occur. Keys should be unique within sibling elements but need not be unique globally
    */

    let groceryList : string[] = ['milk', 'bread', 'eggs', 'chicken']

  return (
    <div>
        <h2>Conditional Rendering</h2>
        {/* We'll conditinally render components based off of state, remember we wrap TS/JS code is {} */}
        {
            isLoggedIn ?
            <p>Welcome back user!</p>
            :
            <p>Please log in</p>
        }
        <button onClick={()=>{setIsLoggedIn(!isLoggedIn)}}>
            {isLoggedIn ? 'Logout': 'Login'}
        </button>


        {/* What if I only want to show something if they are logged in, but not otherwise */}
        {
            isLoggedIn ?
            <p>Some hidden info we can only see if logged in</p>
            :
            <></> 
            // The blank react fragment will allow us to not show anything when not logged in
        }

        {
            isLoggedIn && <p>Hidden Info</p>
            // This is done using truthy/false and the logical AND operator
            // In this the HTML element always returns true
        }

        {/* Print out all of the items in our grocery list, let's update to only show when logged in */}
        {isLoggedIn && <div id="grocery-list">
            <h3>Grocery List</h3>
            {groceryList.map((item) => {
                return (<p key={'item-'+ (groceryList.indexOf(item) + 1)}>{item}</p>)
            })}
        </div>}
      
    </div>
  )
}

export default ConditionalRendering
