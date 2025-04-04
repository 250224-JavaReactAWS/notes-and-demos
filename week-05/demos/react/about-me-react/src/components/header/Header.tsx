// This is our very first React Component

import React from "react";

// We'll also import in our CSS file which applies to this component specifically
import "./Header.css"

// We're going to start by making a class component
// Class components are basic TS classes that extend the Component class and contain an implementation of
// the render method which returns TSX

class Header extends React.Component{
    
    // This is a normal TS class
    // But the most important thing to include inside of here will be an overidden render method

    render(){
        return (
            // Inside of here I'll add my HTML or TS or BOTH
            // Inside of a react component if I want to use basic html elements they are lowercased
            <header>
                <h1>Bryan Serfozo</h1>
            </header>
        )
    }
}

// We want to make this class available in other places so I will export it
export default Header;