import React from 'react';
import { MemoryRouter, Route, Routes } from 'react-router-dom';
import ViewTransaction from './ViewTransaction';
export default{
    title:"Organisms/View Transaction",
    component:ViewTransaction,
    decorators: [(Story) => (
        <MemoryRouter initialEntries={["/transaction/13"]}>
           <Routes>
             <Route path="/transaction/:id" element={<Story />}/>
           </Routes>
        </MemoryRouter>)]
}
const Template = args=><ViewTransaction {...args}/>
export const viewTransaction = Template.bind({})