
export interface DataProps{
    data: {message: string, count: number}
}

function DataComponent(props: DataProps) {
  return (
    <div>
        <h2>Data Loaded</h2>
        <p>{props.data.message}</p>
        <p>{props.data.count}</p>
      
    </div>
  )
}

export default DataComponent
