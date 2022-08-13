import React from "react";
import DropDown from "./DropDown";
// eslint-disable-next-line import/no-anonymous-default-export
export default{
    title: 'Organisms/Dropdown',
    component: DropDown
}
const Template= args => <DropDown {...args} />
export const DropDown1 = Template.bind({});
DropDown1.args = {
   url:"currency",
   getById:"currencyCode",
   getValue:(value)=>console.log(value)
}