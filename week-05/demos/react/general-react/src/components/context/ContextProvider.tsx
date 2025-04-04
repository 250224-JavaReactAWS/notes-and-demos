/*
Before we use the useContext hook we need to perform prop drilling which passed data through extra components 
who did not want that data

To resolve this we're going to use the useContext hook
*/

import { createContext } from "react"
import ContextConsumer1 from "./ContextConsumer1"
import ContextConsumer2 from "./ContextConsumer2"

// The first thing we need to do is create a context, this behaves like a shared variable
export const stringContext = createContext("defaultString")

function ContextProvider() {
    // We can take the context and provide it to all the components in a hierarchy by using a Provider
  return (
    <div>
        <stringContext.Provider value="First String">
            {/* This Provider wraps around all components that want to use this context 
                Note: The value is NOT being passed as a prop
            */}
            <ContextConsumer1 />
            <ContextConsumer2 />
        </stringContext.Provider>
    </div>
  )
}

export default ContextProvider
