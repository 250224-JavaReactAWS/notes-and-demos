import { ChildProps } from "../ChildProps"
import Grandchild from "../grandchild/Grandchild"
import "./Child.css"

function Child(props: ChildProps) {
  return (
    <div className="child">
      <h2>Hello from the child component!</h2>
      <h2>I do not care about having the nameValue </h2>
      <Grandchild nameValue={props.nameValue} toggleName={props.toggleName} />
    </div>
  )
}

export default Child
