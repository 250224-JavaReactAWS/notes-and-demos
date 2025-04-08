import ControlledInput from "./ControlledInput"
import UncontrolledInput from "./UncontrolledInput"


function FormContainer() {
  return (
    <div>
      <h2>Controlled Input</h2>
      <ControlledInput />

        <br />
      <h2>Uncontrolled Input</h2>
      <UncontrolledInput />
    </div>
  )
}

export default FormContainer
