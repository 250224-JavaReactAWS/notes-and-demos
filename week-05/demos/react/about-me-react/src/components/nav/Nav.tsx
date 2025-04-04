
/*
This component is in charge of changing the path on the actual SPA to dynamically render and hide certain
views. It does this by affecting the path WITHOUT reloading the page. So to accomplish this we'll need to use
a Link component instead of an a tag. An a tag will reload the screen and that's not what we want
*/

import { Link } from "react-router-dom"
import "./Nav.css"

function Nav() {
  return (
    <nav>
        <ul>
            <li><Link to="/"> About me</Link></li>
            <li><Link to="/ttaal"> TTAAL</Link></li>
            <li><a href="https://google.com">Questions?</a></li>
        </ul>
    </nav>
  )
}

export default Nav
