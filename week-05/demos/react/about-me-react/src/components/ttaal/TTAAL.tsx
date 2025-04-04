// This was created using rfce from our abbreviations
import { FactProps } from "../../interface/FactProps"
import Fact from "../fact/Fact"
import "./TTAAL.css"

function TTAAL() {

    let facts : FactProps[] = [
        {
            id: 1,
            fact: "I've been practicing Karate for almost 20 years!",
            isTrue: true
        },
        {
            id: 2,
            fact: "I drink two cups of coffee every morning before training",
            isTrue: false
        },
        {
            id: 3,
            fact: "I wake up every morning at 5:30",
            isTrue: true
        }
    ]



  return (
    <main>
        <h3>Two Truths and Lie</h3>

        <table>
            {/* When we use CSS classes we need to use className since class is a reserved keyword in JS/TS */}
            {/* <tr className="truth">
                <th>1st</th>
                <td>I've been practicing Karate for almost 20 years!</td>
            </tr>
            <tr className="lie">
                <th>2nd</th>
                <td>I drink two cups of coffee every morning before training</td>
            </tr>
            <tr className="truth">
                <th>3rd</th>
                <td>I wake up every morning at 5:30</td>
            </tr> */}

            {/* <Fact id={facts[0].id} fact={facts[0].fact} isTrue={facts[0].isTrue}></Fact>
            <Fact id={facts[1].id} fact={facts[1].fact} isTrue={facts[1].isTrue}></Fact>
            <Fact id={facts[2].id} fact={facts[2].fact} isTrue={facts[2].isTrue}></Fact> */}

            {/* Right now this is good, but if I started adding more facts I'd be copying this line a lot
             Solution: Use a map
            */}

            {
                facts.map((fact) => {
                    return <Fact
                    // id={fact.id}
                    // fact={fact.fact}
                    // isTrue={fact.isTrue}
                    // Since the props for Fact are of type FactProps and a fact in facts is a FactProp, we 
                    // can use a destructing argument to pass all the value
                    {...fact}
                    ></Fact>
                })
            }


        </table>
    </main>
  )
}

export default TTAAL
