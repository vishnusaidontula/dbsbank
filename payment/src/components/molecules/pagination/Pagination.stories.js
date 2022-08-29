import React from 'react';
import Pagination from './Pagination';
export default{
    title:"Molecules/Pagination",
    component:Pagination
}
const Template = args=><Pagination {...args}/>
export const Pagination1 = Template.bind({})
Pagination1.args={
    totalPages:100,
    postPerPage:10,
    getPageNumber:(value)=>console.log(value)
}