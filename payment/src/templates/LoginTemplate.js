import React from 'react'
import './LoginTemplate.css'
const LoginTemplate = (props) => {
  return (
    <div className='style bg-dark'>
      {props.children}
    </div>
  )
}

export default LoginTemplate
