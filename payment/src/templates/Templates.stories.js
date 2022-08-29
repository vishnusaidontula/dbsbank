import React from 'react';
import { MemoryRouter } from 'react-router-dom';
import Card from '../components/molecules/card/Card';
import message from '../utils/message';
import Template from './Template';
export default{
    tilte:"Templates/Base Template",
    component:Template
}
const DemoTemplate = args =><MemoryRouter><Template {...args}/></MemoryRouter> 
export const template = DemoTemplate.bind({})
template.args={
    children:<Card details={message.details}/>
}