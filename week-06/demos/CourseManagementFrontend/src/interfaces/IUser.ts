import { ICourse } from "./ICourse";

export interface IUser {
    userId: number,
    firstName: string,
    lastName: string,
    email: string,
    password: string,
    role: "STUDENT" | "TEACHER", // This will say it's a string but the only allowed values are Student or teacher
    courses: ICourse[]
}