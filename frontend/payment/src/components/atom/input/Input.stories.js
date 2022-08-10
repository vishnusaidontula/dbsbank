import React from 'react'
import Input from './Input'

export default{
    title:"Atoms/Input",
    component:Input
}

const Template = args=><Input {...args}/>
export const input = Template.bind({});
input.args={
    label:"Username",
    type:"text",
    placeholder:"Enter input",
    handleKeyUp:(event)=>console.log(event.target.value)
}