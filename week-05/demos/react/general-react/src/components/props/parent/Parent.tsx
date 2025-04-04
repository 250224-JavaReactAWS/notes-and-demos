import { createContext, useState } from "react"
import "./Parent.css"
import Child from "../child/Child"
import { ChildProps } from "../ChildProps"

// Let's create a context to hold all of the info
export const nameValueContext = createContext<ChildProps | null>(null)
// This context will hold a ChildProps object or be null -> Child props holds a nameValue and togglename function


function Parent() {

    /*
    In this component we have the Parent > Child > Grandchild > GreatGrandchild

    Only the Parent component and the GreatGranchild want to have the nameValue variable
    The problem is the GreatGrandchild is nested in the Grandchild which is nested in the Child which is nested
    in the Parent.

    So to get the info down we needed to perform something called PROP DRILLING. Prop drilling is the process
    of passing props through components that don't need them only because a component further down the heirarchy
    needs the value

    THIS IS BAD PRACTICE, not only are we passing props we don't need it can quickly become confusing
    */

    const [nameValue, setNameValue] = useState("Bryan")

    let toggleName = () => {
        // All this function will do is toggle the name stored in the state variable
        setNameValue(nameValue === "Bryan" ? "John" : "Bryan")
    }


  return (
    <nameValueContext.Provider value={{nameValue, toggleName}}>
        <div className="parent">
        <h1>Hello from our Parent component!</h1>
        <h1>The value stored in our nameValue is {nameValue}</h1>
        <button onClick={toggleName}>Toggle Name!</button>
        <Child nameValue={nameValue} toggleName={toggleName}/>
        </div>
    </nameValueContext.Provider>
  )
}

export default Parent
