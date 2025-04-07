import axios from "axios"
import { ChangeEvent, useState } from "react"


function AxiosFetch() {

    const [pokemonName, setPokemonName] = useState('')
    const [pokemon, setPokemon] = useState<any>({})

    let changePokemonName = (e: ChangeEvent<HTMLInputElement>) => {
        setPokemonName(e.target.value)
    }

    /*
    Recall that last week when working with JS we leveraged the Fetch API to send HTTP requests and parse
    the necessary results. This is perfectly valid and able to be done in React with no issues

    Axios is a library that functions as an alternative to fecth. So why would we want to use it?
    - Centrally configure requests
    - Better error handling
    - Automatically parses JSON
    */

    // Using Fetch
    let searchWithFetch = async () => {
        // Remember we can send fully customizable requests with Fetch
        let res = await fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonName}`)
        let data = await res.json()
        console.log(data)
        setPokemon(data)
    }

    // Using Axios
    let searchWithAxios = async () => {
        // Axios also returns a promise like Fetch so it can be chained if desired or we can use async and
        // await to handle all of that
        // We can specify the kind of data we want to be returned
        let res = await axios.get<any>(`https://pokeapi.co/api/v2/pokemon/${pokemonName}`)
        // Now the data will be automatically parsed and we can get different pieces of info from it
        console.log(res)
        setPokemon(res.data)
    }



  return (
    <div>
        <h2>Axios and Fetch for pokemon data</h2>
        <label>
            Enter Pokemon Name: 
            <input type='text' id='pokemon-name-field' value={pokemonName} onChange={changePokemonName} />
        </label>

        <br />
        <br />

        <button onClick={searchWithFetch}>Search With Fetch!</button>
        <button onClick={searchWithAxios}>Search With Axios!</button>

        <br />
        <br />

        { pokemon.name && 
        <>
            <h1>Pokemon Name: {pokemon.name}</h1>
            <img src={pokemon.sprites.front_default} />
        </>}
      
    </div>
  )
}

export default AxiosFetch
