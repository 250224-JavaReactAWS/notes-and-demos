import { ChildProps } from "../ChildProps"
import GreatGrandchild from "../great-grandchild/GreatGrandchild"
import "./Grandchild.css"

function Grandchild(props: ChildProps) {
  return (
    <div className="grandchild">
        <h3>Hello from the grandchild component</h3>
        <h3>I do not care about the nameValue</h3>
        <GreatGrandchild nameValue={props.nameValue} toggleName={props.toggleName}/>
    </div>
  )
}

export default Grandchild
