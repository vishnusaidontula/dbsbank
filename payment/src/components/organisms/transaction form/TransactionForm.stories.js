import React from 'react';
import { MemoryRouter } from 'react-router-dom';
import TransactionForm from './TransactionForm';
export default{
    title:"Organisms/Transaction Form",
    component:TransactionForm
}
const Template = args => <MemoryRouter><TransactionForm /></MemoryRouter>
export const TransactionForm1 = Template.bind({})