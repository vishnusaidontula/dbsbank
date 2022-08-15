import API from "./API";
const postElement = async(url,object)=>{
    console.log(object)
    const res = await API.post(url,object);
    return res.data;
}
export default postElement;