import { useContext } from "react"
import { ChildProps } from "../ChildProps"
import "./GreatGrandchild.css"
import { nameValueContext } from "../parent/Parent"

function GreatGrandchild(props: ChildProps) {
    // Inside of here I can consume the context object and get the function and stateVariable I want
    const nameValueReference = useContext(nameValueContext)


  return (
    <div className="great-grandchild">
        <h4>Hello from the great grandchild component!</h4>
        <h4>I care about having the nameValue, it should be {props.nameValue}</h4>
        <button onClick={props.toggleName}>Toggle the nameValue!</button>
        <br />
        <h4>We consumed a name from the nameValueContext without passing through the other components 
            with props</h4>
        <h4>The value is {nameValueReference?.nameValue}</h4>
        <button onClick={nameValueReference?.toggleName}>Click to update the nameValueContext</button>
    </div>
  )
}

export default GreatGrandchild
