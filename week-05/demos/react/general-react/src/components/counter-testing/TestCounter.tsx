import { useState } from "react"


function TestCounter() {

    const [count, setCount] = useState(0)

  return (
    <div>
        <h1 data-testid="count">{count}</h1>
        <button onClick={() => setCount(count + 1)}>Increment</button>
        <button onClick={() => setCount(count - 1)}>Decrement</button>
    </div>
  )
}

export default TestCounter
