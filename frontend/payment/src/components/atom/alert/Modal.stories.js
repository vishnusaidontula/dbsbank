import React from "react";
import { MemoryRouter } from "react-router-dom";
import Modal from "./Modal";

export default {
    title: 'Atoms/Alert',
    component: Modal
}
const Template= args => <MemoryRouter><Modal {...args} /></MemoryRouter>
export const Modal1 = Template.bind({});
Modal1.args={
    title:"Transaction Successful",
    body:"Thank you"
}