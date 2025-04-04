
interface SharedCounterProps{
    counterValue: number, // State variable
    setCounterValue: (counterValue: number) => void // Setter for the state variable
}

function SharedCounter(props: SharedCounterProps) {
  return (
    <div>
      <p>Shared value for counter is {props.counterValue}</p>
      <button onClick={() => props.setCounterValue(props.counterValue + 1)}>Increment Shared Counter</button>
    </div>
  )
}

export default SharedCounter
