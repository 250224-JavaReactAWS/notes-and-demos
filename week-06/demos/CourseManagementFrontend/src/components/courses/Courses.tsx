import { useEffect, useState } from "react"
import { ICourse } from "../../interfaces/ICourse"
import axios from "axios"
import "./Courses.css"


function Courses() {
    /*
    This will be our first page for our application, its goal is to get all of the course objects
    */
    const [courses, setCourses] = useState<ICourse[]>([])


    // What we want to do is make a call to our backend to get all of our courses

    // I don't want to have to click the button everytime I load the page it should automatically load all of
    // the courses

    // ENTER useEffect Hook
    /*
    The useEffect hook is a special function that allows you to create side effect functions that take place
    when the component mounts or a dependencies (state variable) gets changed

    When the component is rendered on the screen it MOUNTS to the dom (in dev mode this happens twice do not
    be alarmed)

    It's important to note that the useEffect can be called on certain dependencies when adding them to the 
    final array. It should be noted that this is a very quick way to create an infinite loop so be careful
    */

    useEffect(() => {
        getCourses();
    }, []) // Dependencies (If blank only occurs when the component mounts)



    let getCourses = async() => {
        let res = await axios.get<ICourse[]>('http://localhost:8080/courses')
        console.log(res)
        setCourses(res.data)
    }


  return (
    <div>
        <h1>Our Courses</h1>
        {/* For right now let's create a button to add in our courses */}
        {/* <button onClick={getCourses}>Fetch Courses</button> */}
      {courses.map(course => {
        return (
            <div className="course">
                <h3>{course.name}</h3>
                <p>Course Id: {course.courseId}</p>
            </div>
        )
      })}
    </div>
  )
}

export default Courses
