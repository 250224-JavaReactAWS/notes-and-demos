// Inside of here I'm going to define an interface that holds the shape the of the data I'll pass from
// TTAAL to each fact component

export interface FactProps {
    id: number,
    fact: string,
    isTrue: boolean
}