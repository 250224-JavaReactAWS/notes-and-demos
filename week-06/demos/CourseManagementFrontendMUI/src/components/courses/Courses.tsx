
// Here I want to grab all of the courses from our backend

import { useContext, useEffect, useState } from "react"
import { ICourse } from "../../interfaces/ICourse"
import axios from "axios"
import { Button, Card, CardActions, CardContent, Typography } from "@mui/material"
import { authContext } from "../../App"
import NewCourseForm from "./NewCourseForm"


function Courses() {

    const [courses, setCourses] = useState<ICourse[]>([])
    const roleReference = useContext(authContext)
    const [enrollmentIds, setEnrollmentIds] = useState<number[]>([])
    const [shouldUpdate, setShouldUpdate] = useState(false)
    const [open, setOpen] = useState(false)

    useEffect(() => {

        // If you want to use Async/Await inside a useEffect you need to create a separate function
        let getCourses = async () => {
            let res =  await axios.get<ICourse[]>('http://localhost:8080/courses')
            setCourses(res.data)

            // Let's see if the user is logged in
            // If the logged in user is a student we should give them the ability to enroll in a course
            // But they should not have the option to enroll in a course if they're already enrolled in it
            if (roleReference?.role === "STUDENT"){
                let enrollments = await axios.get<ICourse[]>('http://localhost:8080/enrollments', {withCredentials: true})
                let enrollmentIdValues = enrollments.data.map(enrollment => enrollment.courseId)
            
            setEnrollmentIds(enrollmentIdValues)
            }
            
        }

        getCourses();
        
        
    }, [shouldUpdate]) // Only triggers when the component mounts and when shouldUpdate gets changed

    // GOAL: We want to be able to enroll in a course
    // Steps: Get the current enrollments ID and render a button that allows us to enroll in a course


    let enrollInCourse = async (courseId: number) => {
        let res = await axios.post<ICourse>(`http://localhost:8080/enrollments/${courseId}`, 
            {}, {withCredentials:true})

        console.log(res)

        // AT THIS POINT WE SHOULD BE ENROLLED BUT WE NEED TO REFRESH THE DATA ON THE SCREEN
        // This involves calling our useEffect again to refresh the data
        // One quick workaround is a setUpdate state variable
        // Toggle the should update variable
        setShouldUpdate(!shouldUpdate)
    }


  return (
    <>
    <div style={{
        display: 'flex',
        flexDirection : 'row',
        justifyContent: 'center',
        flexWrap : 'wrap'
    }}>
      {courses.map((course) => {
        return (
            <Card 
            key={`course-${course.courseId}`}
            sx={{
                minWidth: 350,
                minHeight: 150,
                margin: "20px",
                textAlign: 'center'
                }}>
                <CardContent>
                    <Typography>
                        {course.name}
                    </Typography>
                    <Typography>
                        Course Id: {course.courseId}
                    </Typography>
                </CardContent>
                <CardActions>
                    {roleReference?.role === "STUDENT" && 
                    !enrollmentIds.includes(course.courseId) &&
                    <Button color="primary" variant="contained"
                    onClick={() => enrollInCourse(course.courseId)}
                    >Enroll Now!</Button>}
                </CardActions>
            </Card>
        )
      })}
      
    </div>
    {roleReference?.role === "TEACHER" && <NewCourseForm 
    open={open} 
    setOpen={setOpen} 
    shouldUpdate={shouldUpdate} 
    setShouldUpdate={setShouldUpdate}/>}
    </>
  )
}

export default Courses
