import { ICourse } from "./ICourse";

export interface IUser{
    userId: number,
    firstName: string,
    lastName: string,
    email: string,
    password: string,
    role: "STUDENT" | "TEACHER" | "UNAUTHENTICATED",
    courses: ICourse[]
}