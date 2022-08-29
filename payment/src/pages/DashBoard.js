import React from 'react'
import Card from '../components/Card'
import Template from '../templates/Template'
import message from '../utils/message'

const DashBoard = () => {
    return (
        <div>
            <Template>
                <Card details={message.details}/>
            </Template>
        </div>
    )
}

export default DashBoard
