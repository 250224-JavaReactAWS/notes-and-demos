# JavaScript Fetch API Activity

## Objective
Learn how to use JavaScript’s Fetch API to send requests to an external API and display the response on a webpage.

## Prerequisites
- Basic understanding of JavaScript syntax
- Familiarity with HTML and DOM manipulation

---

## Instructions

1. **Set Up Your Environment:**  
   - Open a text editor (e.g., VS Code, Notepad++).
   - Create a new HTML file (`index.html`) and a JavaScript file (`script.js`).

2. **Design the User Interface:**  
   - Create an input box where users can enter a search term.
   - Add a button to trigger the fetch request.
   - Provide an empty area where the fetched data will be displayed.

3. **Implement the Fetch Request:**  
   - Write JavaScript to capture user input and send a request to the selected API.
   - Process and display the response data in the HTML.
   - Handle errors gracefully if the request fails or returns no results.

4. **Test the Implementation:**  
   - Open `index.html` in a browser.
   - Enter a valid input and observe the results displayed on the screen.

---

## API Options

Select one of the following APIs to fetch and display data:

1. **PokeAPI** (https://pokeapi.co/):
   - Endpoint: `https://pokeapi.co/api/v2/pokemon/{name}`
   - Users can enter a Pokémon name or ID, and the API will return details including a sprite image.

2. **Advice Slip API** (https://api.adviceslip.com/):
   - Endpoint: `https://api.adviceslip.com/advice/search/{query}`
   - Users can enter a keyword to receive related advice from the API.

3. **Dog CEO’s Dog API** (https://dog.ceo/dog-api/):
   - Endpoint: `https://dog.ceo/api/breed/{breedName}/images/random`
   - Users can enter a dog breed to retrieve a random image of that breed.
   - If you're doing a breed with 2 names, it should be entered as `https://dog.ceo/api/breed/retriever/golden/images/random` for `Golden Retreiver`

---

## Bonus Challenge
Enhance the activity by allowing users to select an API from a dropdown menu before making a request.

---

