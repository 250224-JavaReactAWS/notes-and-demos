import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import Courses from './components/courses/Courses'
import Nav from './components/nav/Nav'
import Login from './components/login/Login'

function App() {
  
  return (
    <>
      <BrowserRouter>
      <Nav />

      <Routes> 
        <Route path='/' element={<Courses />}/>
        <Route path='/login' element={<Login />} />
      </Routes>
      
      
      </BrowserRouter>
    </>
  )
}

export default App
