/*
This is going to be our fist Functional Component. This is almost identical to a class component but it's
just a single function now were were return TSX/JSX. There are virtually no difference to what a class vs a 
functional component can do but class implementations are older and functional implementations are the
newer way to do. Through the use of hooks, functional components can do everything class components can
*/

import "./Home.css"

function Home(){
    // The return statement for this method will be TSX and what is used when this component gets rendered

    return (
    <main>
        <h3>Introduction</h3>

        <figure>
            {/* Self closing tags make sure to end with />. Also Images should be stored in the assets folder*/}
            <img id="pic" src="src/assets/Bryan-Kaitlyn-Maine.jpg" /> 
            <figcaption>Me and my Fiance</figcaption>
        </figure>


        <p>
            My name is Bryan Serfozo, I'm a full stack Java Trainer here at Revature. I've been training for 
            the past 3 years and was recently promoted. In my freetime, I like to do karate, hiking and 
            exploring National Parks. My most recent trip was to Mt Rainier and Olympic National parks in 
            Washington state where I got engaged
        </p>
    </main>
    )
}

export default Home