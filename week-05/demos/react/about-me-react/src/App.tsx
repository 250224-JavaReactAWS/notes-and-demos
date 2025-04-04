import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import Footer from './components/footer/Footer'
import Header from './components/header/Header'
import Home from './components/home/Home'
import TTAAL from './components/ttaal/TTAAL'
import Nav from './components/nav/Nav'

/*
This is our very first React Component, call the App Component. This is a functional component and it 
controls everything that gets rendered directly on the screen. Right now it starts with some basic filler
information which we will clear out but lets answer some questions

What is the file extension tsx?
TSX and JSX are combination of TypeScript or JavaScript with XML. Basically it is a combination of TS and HTML
or JS and HTML and allows you to write code and directly inject it into your HTML like you would using JS

What is React?
React is a component based frontend LIBRARY used to create production quality SPAs (Single Page Applications). 
They can be used in a variety of use cases and even some versions of React can be used for mobile development
(React Native). Why is this a library and not a framework? Libraries are generally lighter weight and 
have limitied functionality compared to Frameworks. Frameworks include a lot of functionality right out of the
box but can often be bloated if you don't need everything. Libraries are used *at will* so you can use as much
or as little React as you want but frameworks you generally have to adhere to their syntax entirely

Other files we should know:
Index.html -> This is the SINGLE HTML page throughout the entire application. Everything gets mounted to
this html page and that will be only one rendered at runtime

Why would we want a single page application?
If you have a large number of shared components there's no need to rerender them everytime we switch pages
and additionally it becomes faster (after the initial load) to swap between pages as needed
*/

function App() {
  return (
    <>
      {/* If I want to use my component, I'll call it just like an HTML element but I need to
      use a capital letter to define it */}
      <Header></Header>

        {/* Our functional components render the same way as a class component */}
        {/* At this point we have our two components but we only want to render one of them at a time. 
          How do we do this? ROUTING
          Routing refers to setting up different frontend endpoint associated with different component
          / -> Home
          /ttaal -> TTAAL

          How do we add in routing to our application?
          Routing is not part of the functionality for react out of the box so we need to add it in

          Now that we've added in the React Router DOM we'll leverage the browser router component to 
          navigate between different view
        
        */}
      <BrowserRouter>
          {/* Since the path gets updated when I use the Nav component I need to render it inside of the 
            browser router
          */}
          <Nav />

      {/* Inside of here I'll define my routes and the components that are rendered on them */}
          <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/ttaal' element={<TTAAL />} />
          </Routes>
      </BrowserRouter>


      {/* <Home></Home>
      <TTAAL></TTAAL> */}
      
      <Footer></Footer>
    </>
  )
}

export default App
