
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import './App.css'
import Login from './components/login/Login'
import Nav from './components/nav/Nav'
import Enrollments from './components/enrollments/Enrollments'
import Courses from './components/courses/Courses'
import Register from './components/register/Register'
import { createContext, useEffect, useState } from 'react'
import axios from 'axios'
import { ThemeProvider } from '@emotion/react'
import { theme } from './theme'

/*
I plan to create an authContext object that holds all of the contextual information for a user that any class
might need
*/

export interface AuthContextType{
  role: "STUDENT" | "TEACHER" | "UNAUTHENTICATED",
  setRole: (role: "STUDENT" | "TEACHER" | "UNAUTHENTICATED") => void
}

export const authContext = createContext<AuthContextType | null>(null)

function App() {

  const [role, setRole] = useState<"STUDENT" | "TEACHER" | "UNAUTHENTICATED">("UNAUTHENTICATED")

  // Right now we're logged in but if I hard refresh all of the state variables disappear, I could just check
  // if the cookie exists and store a little more information inside of local storage (this is totally valid
  // and probably the easiest way to do this) but for consistency with the backend I will create an endpoint
  // that retrieves the current session info

  useEffect(() => {
    axios.get<"STUDENT" | "TEACHER">("http://localhost:8080/users/session", {withCredentials: true})
    .then(res => {
      setRole(res.data)
    })
    .catch(err => {
      setRole("UNAUTHENTICATED")
      console.log(err)
    })
  }, [])
  

  return (
    <>
    <ThemeProvider theme={theme}>
      <authContext.Provider value={{role, setRole}} >
        <BrowserRouter>
          <Nav />

          <Routes>
            <Route path='/' element={<Courses />} />
            <Route path='enrollments' element={<Enrollments />}/>
            <Route path='login' element={<Login />} />
            <Route path='register' element={<Register />} />
          </Routes>
        
        </BrowserRouter>
      
      </authContext.Provider>
      </ThemeProvider>
    </>
  )
}

export default App
