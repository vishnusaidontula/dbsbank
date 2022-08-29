import React from 'react'
import LoggerTable from '../components/LoggerTable'
import Template from '../templates/Template'

const LoggerPage = () => {
    return (
        <div>
            <Template>
                <div className="container-fluid mt-4">
                    <LoggerTable />
                </div>
                
            </Template>
        </div>
    )
}

export default LoggerPage
