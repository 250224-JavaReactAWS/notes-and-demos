
/*
Controlled vs uncontrolled components
So in React now that we know about Refs we can consider other ways to keep track of user input

Normal way:
Define state variables, update them as they change and keep everything rendered with the current state value
This is called a Controlled Input or Component
Benefits of doing this is that everything stays in line with STATE, basically the value held by the component is
the single source of truth and used to render anything needed on the screen
*/

import { ChangeEvent, useState } from "react"

function ControlledInput() {

    // UseState to hold some input value
    const [inputValue, setInputValue] = useState('')

    let handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        setInputValue(e.target.value)
    }

  return (
    <div>
      <input type="text" placeholder="Controlled Input" value={inputValue} onChange={handleChange}/>
      <button onClick={()=>console.log(inputValue)}>Print value</button>
    </div>
  )
}

export default ControlledInput
