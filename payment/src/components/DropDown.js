import React,{useState,useEffect} from 'react'
import Select from 'react-select'
import getList from '../services/getList';
const DropDown = (props) => {
    const [filterValues,setFilterValues] = useState([]);
    useEffect(() => {
         async function getData(){
            await getList(props.url).then(
                (res)=>{
                    console.log(`inside get list api of value ${props.url}`);
                    setFilterValues(res);
                }
            )
            .catch(
                (err)=>{console.log(err)}
            )
        }
        getData()
    },[props.url])
    const handleChange = ({value})=>{
        props.getValue(value);
    }
    const getOptions = ()=>{
        const options = [];
        filterValues.forEach(
            data =>{
                options.push({value:data,label:data[props.getById]})
            } 
        )
        return options;
    }
    return (
        <div>
            <Select options={getOptions()} onChange={handleChange} placeholder={<div>{props.placeholder}</div>}/>
        </div>
    )
}

export default DropDown
