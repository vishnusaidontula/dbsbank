import React from 'react';
import Header from './Header';
import {MemoryRouter} from 'react-router-dom';
export default{
    title:"Organisms/Header",
    component:Header
}
const Template= args => <MemoryRouter><Header {...args} /></MemoryRouter>
export const Header1 = Template.bind({});