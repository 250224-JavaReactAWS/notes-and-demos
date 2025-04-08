import { Button, Dialog, DialogTitle, DialogContent, DialogContentText, TextField, DialogActions } from "@mui/material";
import axios from "axios";
import { ICourse } from "../../interfaces/ICourse";
import { ChangeEvent, useState } from "react";


function NewCourseForm(props: {open: boolean, 
    setOpen: (open:boolean) => void, 
    shouldUpdate: boolean,
    setShouldUpdate: (shouldUpdate:boolean) => void}) {

    const [courseName, setCourseName] = useState('')

    const handleClickOpen = () => {
        props.setOpen(true);
      };
    
      const handleClose = () => {
        props.setOpen(false);
      };
    
      return (
        <>
          <Button variant="outlined" onClick={handleClickOpen}>
            Add a new Course
          </Button>
          <Dialog
            open={props.open}
            onClose={handleClose}
            slotProps={{
              paper: {
                component: 'form',
                onSubmit: async (event: React.FormEvent<HTMLFormElement>) => {
                  event.preventDefault();
                  // We need to add in functionality for sending an axios request

                  let res = await axios.post<ICourse>('http://localhost:8080/courses',
                    {name: courseName},
                    {withCredentials: true}
                  )
                  console.log(res)
                  console.log(props.shouldUpdate)
                  props.setShouldUpdate(!props.shouldUpdate)
                  console.log(props.shouldUpdate)
                  handleClose();
                },
              },
            }}
          >
            <DialogTitle>Create a new course</DialogTitle>
            <DialogContent>
              <DialogContentText>
                To add a new course please add in a name below
              </DialogContentText>
              <TextField
                autoFocus
                required
                margin="dense"
                id="name"
                name="email"
                label="Course Name"
                type="text"
                fullWidth
                variant="standard"
                value={courseName}
                onChange={(e:ChangeEvent<HTMLInputElement>) => setCourseName(e.target.value)}
              />
            </DialogContent>
            <DialogActions>
              <Button onClick={handleClose}>Cancel</Button>
              <Button type="submit">Create New Course</Button>
            </DialogActions>
          </Dialog>
        </>
      );
}

export default NewCourseForm
