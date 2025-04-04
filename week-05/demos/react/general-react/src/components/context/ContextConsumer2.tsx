import { useContext } from "react"
import { stringContext } from "./ContextProvider"


function ContextConsumer2() {
   // In this class I'll consume the value in the context by using the useContext hook
  
      const stringValueReference = useContext(stringContext)
  
  
    return (
      <div>
        <h1>The value from the stringContext is {stringValueReference}</h1>
      </div>
    )
}

export default ContextConsumer2
