
/*
An uncontrolled component uses refs and the DOM directly to keep track of the value
Benefits:
Dom is the source of truth, components only track their internal state whereas the DOM tracks the input value
Generally can be considered simpler for one-off inputs

Drawbacks:
Harder to test, since it's a little less explicit and React doesn't have to update when changing the value
Harder to do complex validation logic

Really should only use this if you have to, controlled input should be your first choice
*/

import { useRef } from "react";

function UncontrolledInput() {

    // Create a ref to hold the value for the component
    const inputRef = useRef<any>(null);

  return (
    <div>
      <input type="text" placeholder="Uncontrolled Input" ref={inputRef}/>
      <button onClick={() => console.log(inputRef.current.value)}>Print value</button>
    </div>
  )
}

export default UncontrolledInput
