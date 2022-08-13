import React from "react";
import Card from "./Card";
import imgv1 from "../../../asset/images/logger.png"
import imgv2 from "../../../asset/images/transaction.png"
import imgv3 from "../../../asset/images/customer.png"
import imgv4 from "../../../asset/images/contact.png"
import imgv5 from "../../../asset/images/about.png"
import imgv6 from "../../../asset/images/settings.png"
export default{
    title: 'Molecules/Cards',
    component: Card
}

const Template= args => <Card {...args} />
export const Card1= Template.bind({});
Card1.args={
    details:[
        {
            id:1,
            title:"View Loggers",
            imgv:imgv1
        },
        {
            id:2,
            title:"Make Transaction",
            imgv:imgv2
        },
        {
            id:3,
            title:"Add Customer",
            imgv:imgv3
        },
        {
            id:4,
            title:"Contact Us",
            imgv:imgv4
        },
        {
            id:5,
            title:"About",
            imgv:imgv5
        },
        {
            id:6,
            title:"Settings",
            imgv:imgv6
        }
    ]
}