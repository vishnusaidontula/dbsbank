
import React from "react";
import Button from "./Button";
export default {
    title: 'Atoms/Button',
    component: Button
}
const Template= args => <Button {...args} />
export const Button1 = Template.bind({});
Button1.args = {
    text:"login",
    size:"lg",
    type:"button",
    outline:"danger",
    handleClick:()=>console.log("button clicked")

}
export const Button2 = Template.bind({});
Button2.args = {
    text:"Submit",
    size:"lg",
    type:"submit",
    outline:"success"

}