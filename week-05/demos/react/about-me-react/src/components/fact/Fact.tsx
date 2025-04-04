/*
The goal of this component will be to take in information from the Parent Component (TTAAL) and render a 
table row based off that info. How do we do this?

We need to take information fro the parent component in the form of PROPS

What are Props?
These are different properties passed from parent to child (THIS IS A ONE WAY DATA FLOW) used to initialize
or set data in the child component
*/

import { FactProps } from "../../interface/FactProps"

// Now whenever I call this object it's expecting to have a fact, id, and isTrue value

function Fact(props: FactProps) {
  return (
    // We can inject code directly into our TSX by wrapping it in {}
    <tr className={props.isTrue ? "truth" : "lie"}>
        <th>{props.id}</th>
        <td>{props.fact}</td>
    </tr>
  )
}

export default Fact
