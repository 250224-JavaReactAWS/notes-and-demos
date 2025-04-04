import Counter from "../counter/Counter"
import SharedCounter from "../shared-counter/SharedCounter"
import { useState } from "react"


function CounterContainer() {
    /*
    Inside of this component we'll add in a couple of counters and talk about how to move and update state
    even from child components

    Each component that has a state variable is directly in charge of managing it own state

    What happens if I want to change this functionality so I have 2 elements holding the same value

    I need to lift the state to the highest parent between them
    */

    // If I want the sharedCounters to have the same value I need to hold it as a state variable in their common
    // ancestor
    const [sharedCounterValue, setSharedCounterValue] = useState(0)
    // If I want to pass these value to the child components I need to pass them as props

  return (
    <div>
        <h1>Non Shared State</h1>
        <Counter />
        <Counter />

        <h1>Shared State (Lifted to the parent component)</h1>
        <SharedCounter counterValue={sharedCounterValue} setCounterValue={setSharedCounterValue} />
        <SharedCounter counterValue={sharedCounterValue} setCounterValue={setSharedCounterValue} />
      
    </div>
  )
}

export default CounterContainer
