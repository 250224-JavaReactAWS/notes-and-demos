import { useEffect, useState } from "react"
import { ICourse } from "../../interfaces/ICourse"
import { Card, CardContent, Typography } from "@mui/material"
import axios from "axios"

function Enrollments() {

    const [courses, setCourses] = useState<ICourse[]>([])

    useEffect(() => {

        axios.get<ICourse[]>('http://localhost:8080/enrollments', {withCredentials:true})
        .then((res) => {
            setCourses(res.data)
        })
        .catch((err) => {
            console.log(err)
        })
    }, []) // Only triggers when the component mounts

  return (
    <div style={{
        display: 'flex',
        flexDirection : 'row',
        justifyContent: 'center',
        flexWrap : 'wrap'
    }}>
      {courses.map((course) => {
        return (
            <Card sx={{
                minWidth: 350,
                minHeight: 150,
                margin: "20px",
                textAlign: 'center'
                }}
                key={`course-${course.courseId}`}
                >
                <CardContent>
                    <Typography>
                        {course.name}
                    </Typography>
                    <Typography>
                        Course Id: {course.courseId}
                    </Typography>
                </CardContent>
            </Card>
        )
      })}
    </div>
  )
}

export default Enrollments
