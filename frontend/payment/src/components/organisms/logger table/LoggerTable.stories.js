import React from 'react';
import { MemoryRouter } from 'react-router-dom';
import LoggerTable from './LoggerTable';
export default{
    title:"Organisms/Logger Table",
    component:LoggerTable
}
const Template = args=><MemoryRouter><LoggerTable {...args}/></MemoryRouter>
export const LoggerTable1 = Template.bind({});