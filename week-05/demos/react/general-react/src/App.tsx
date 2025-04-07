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

function App() {

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
        </Routes>
      
      
      </BrowserRouter>
    </>
    
  )
}

export default App
