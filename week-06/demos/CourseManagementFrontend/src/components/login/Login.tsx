import axios from "axios"
import { ChangeEvent, useState } from "react"
import { IUser } from "../../interfaces/IUser"
import { useNavigate } from "react-router-dom"


function Login() {
    // State variables to track the logged in person
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [error, setError] = useState(false)

    // To naivgate users to another page we'll use a useNavigate hook
    const navigate = useNavigate();

    let login = async () =>{
        // Let's make sure they have entered a email and a password
        if (!email){
            alert("Please enter an email!")
            return;
        }

        if (!password){
            alert("Please enter a password")
            return;
        }

        // We need to send an axios post request
        try{
            let res = await axios.post<IUser>('http://localhost:8080/users/login', 
                {email, password}, // This is the body of our request
                {withCredentials: true}
                // We don't need to add on the Content-Type=application/json since axios implicitly works with json
                // We can add "withCredentials:true" => This allows use to keep track of the JSESSIONID which holds
                // the logged in user
            )

            console.log(res)
            // On successful login we should redirect to the courses page (for now) 

            if (res.status === 200 ){
            // This indicates a successful login
                navigate('/') // Courses route
                return
            }
        } catch (error){
            // If we're down here that means the username or password was incorrect
            setError(true)
        }
    }

  return (
    <div>
        <h1>Login</h1>

        <div id="loginForm">
            {error && <p style={{color:'red'}}>Username or Password is incorrect</p>}
            <label>
                Email: 
                <input type="email" value={email} 
                onChange={(e:ChangeEvent<HTMLInputElement>) => setEmail(e.target.value)}/>
            </label>
            <br />
            <label>
                Password: <input type="password" value={password}
                onChange={(e:ChangeEvent<HTMLInputElement>) => setPassword(e.target.value)} />
            </label>

            <br />
            <button onClick={login}>Login!</button>
        </div>
      
    </div>
  )
}

export default Login
