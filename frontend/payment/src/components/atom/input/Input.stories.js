import React from 'react'
import Input from './Input'

export default{
    title:"Atoms/Input",
    component:Input
}

const Template = args=><Input {...args}/>
export const input = Template.bind({});
input.args={
    type:"text",
    placeholder:"Enter input",
    handleKeyUp:(value)=>console.log(value),
    isRequired:true
}