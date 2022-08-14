import React from "react";
import ReactPaginate from "react-paginate";
const Pagination = (props) => {
  const pageCount = Math.ceil(props.totalPages / props.postPerPage);
  function handleChange({selected}){
    props.getPageNumber(selected+1)
  }
  return (
    <ReactPaginate
      breakLabel="..."
      nextLabel=">>"
      onPageChange={handleChange}
      pageRangeDisplayed={5}
      pageCount={pageCount}
      previousLabel="<<"
      renderOnZeroPageCount={null}
      pageClassName="page-item"
      pageLinkClassName="page-link"
      previousClassName="page-item"
      previousLinkClassName="page-link"
      nextClassName="page-item"
      nextLinkClassName="page-link"
      breakClassName="page-item"
      breakLinkClassName="page-link"
      containerClassName="pagination"
      activeClassName="active"
    />
  );
};

export default Pagination;
