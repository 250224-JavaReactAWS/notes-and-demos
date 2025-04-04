import { Link } from "react-router-dom"
import "./Nav.css"

function Nav() {
  return (
    <nav>
        <ul>
            <li><Link to="/">State</Link></li>
            <li><Link to="/shared-counter"> Shared State</Link></li>
            <li><Link to="/props"> Prop Drilling</Link></li>
            <li><Link to="/context"> Context</Link></li>
        </ul>
    </nav>
  )
}

export default Nav