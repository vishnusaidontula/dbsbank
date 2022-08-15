import React from 'react'
import Header from '../components/organisms/header/Header'
const Template = (props) => {
    return (
        <div>
            <Header />
            {
                props.children
            }
        </div>
    )
}

export default Template
