import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import Nav from './components/nav/Nav'
import Counter from './components/state-intro/counter/Counter'
import CounterContainer from './components/state-intro/counter-container/CounterContainer'
import Parent from './components/props/parent/Parent'
import ContextProvider from './components/context/ContextProvider'
import Events from './components/events/Events'
import ConditionalRendering from './components/conditional-rendering/ConditionalRendering'
import AxiosFetch from './components/axios-fetch/AxiosFetch'
import Refs from './components/refs/Refs'
import FormContainer from './components/controlled-uncontrolled/FormContainer'
import withLoading from './components/hoc/WithLoading'
import DataComponent from './components/hoc/DataComponent'
import TestCounter from './components/counter-testing/TestCounter'

function App() {

  // Inside of here I'm going to add in my HOC (Higher Order Component) which wraps around the other component
  // The idea is that the function will get called on the Component itself and from there it will render one
  // of two things depending on the "isLoading" value. If isLoading is true it'll just say "Loading..." otherwise
  // it shows the component itself
  

  return (
    // What is this empty tag here?
    // Because of the way React renders our TSX/JSX it requires that only one element is returned from our 
    // method. This blank element is called a React Fragment and it's used to wrap around multiple elements
    // to give it a single parent element
    <>
      <BrowserRouter>
      {/* We'll add in a nav component and look at a couple of options for React */}
        <Nav />
        <Routes>
          <Route path='/' element={<Counter />}/>
          <Route path='/shared-counter' element={<CounterContainer />}/>
          <Route path='/props' element={<Parent />} />
          <Route path='/context' element={<ContextProvider />} />
          <Route path='/events' element={<Events />}/>
          <Route path='/conditional-rendering' element={<ConditionalRendering />}/>
          <Route path='/axios-fetch' element={<AxiosFetch />}/>
          <Route path='/refs' element={<Refs />}/>
          <Route path='/controlled-uncontrolled' element={<FormContainer/>}/>
          <Route path='/testing' element={<TestCounter/>}/>
        </Routes>
      
      
      </BrowserRouter>
    </>
    
  )
}

export default App
