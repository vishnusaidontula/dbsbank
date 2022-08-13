import React from "react";

const Pagination = (props) => {
    const pageNumber = []
    for(let i=1;i<=Math.ceil(props.totalPages/props.postPerPage);i++){
        pageNumber.push(i)
    }
  return (
    <nav aria-label="Page navigation example">
      <ul className="pagination"> 
        {pageNumber.map((number,index)=>(
            <li key={index}  className="page-item">
                <button className="page-link"  onClick={()=>props.getPageNumber(number)}>
                    {number}
                </button>
            </li>
        ))}
      </ul>
    </nav>
  );
};

export default Pagination;
