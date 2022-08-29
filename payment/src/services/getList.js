import API from "./API";
const getList = async(url)=>{
    const res = await API.get(url);
    return res.data;
}
export default getList;