import { AppBar, Button, Toolbar, Typography } from "@mui/material"
import { useContext } from "react"
import { useNavigate } from "react-router-dom"
import { authContext } from "../../App"
import axios from "axios"


function Nav() {
    /*
    I could set this navbar up the way I did before with the Link tag but another thing I can do is the 
    useNavigate hook which allows you to redirect to different pages as needed

    In this class we need should know if the user is logged in so we can control whether or not they see specific
    options
    */
   const navigate = useNavigate()

   // We can use the value for the logged in user to control what values they see
   const roleReference = useContext(authContext)

   let logout = () => {
    roleReference?.setRole("UNAUTHENTICATED")
    navigate("/login")
    // Let's create a logout endpoint
    axios.post('http://localhost:8080/users/logout', {}, {withCredentials: true})
   }

  return (
    <>
        <AppBar position="fixed">
        <Toolbar>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            CMS
          </Typography>
          <Button color="inherit" onClick={() => navigate('/')}>Courses</Button>
          {roleReference?.role === "STUDENT" && 
          <Button color="inherit" onClick={() => navigate('/enrollments')}>Enrollments</Button>}
          {
            roleReference?.role === "UNAUTHENTICATED" ? 
            <>
                <Button color="inherit" onClick={() => navigate('/login')}>Login</Button>
                <Button color="inherit" onClick={() => navigate('/register')}>Register</Button>
            </>
            :
            <Button color='inherit' onClick={logout}>Logout</Button>
          }
        </Toolbar>
        
      </AppBar>
      <Toolbar />
    </>
  )
}

export default Nav
