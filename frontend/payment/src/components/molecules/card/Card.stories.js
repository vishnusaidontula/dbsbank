import React from "react";
import Card from "./Card";
import imgv1 from "../../../asset/images/logger.png"
import imgv2 from "../../../asset/images/transaction.png"
import imgv3 from "../../../asset/images/customer.png"
import imgv4 from "../../../asset/images/contact.png"
import imgv5 from "../../../asset/images/about.png"
import imgv6 from "../../../asset/images/settings.png"
import {MemoryRouter} from 'react-router-dom';


export default{
    title: 'Molecules/Cards',
    component: Card
}

const Template= args =><MemoryRouter><Card {...args} /></MemoryRouter>
export const Card1= Template.bind({});
Card1.args={
    details:[
        {
            title:"View Loggers",
            imgv:imgv1,
            path:"/loggers"
        },
        {
            title:"Make Transaction",
            imgv:imgv2,
            path:"/transaction"
        },
        {
            title:"Add Customer",
            imgv:imgv3,
            path:"/customer"
        },
        {
            title:"Contact Us",
            imgv:imgv4,
            path:"/contact-us"
        },
        {
            title:"About",
            imgv:imgv5,
            path:"/about"
        },
        {
            title:"Settings",
            imgv:imgv6,
            path:'/settings'
        }
    ]
}