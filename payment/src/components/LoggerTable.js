import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import getList from "../services/getList";
import Pagination from ".//Pagination";
import "./LoggerTable.css";
const LoggerTable = () => {
  const [logDetails, setLogDetails] = useState([]);
  const[currentPage,setCurrentPage] = useState(1);
  const postPerPage = 15;
  const getLoggerData = () => {
    getList("/loggers")
      .then((res) => setLogDetails(res))
      .catch((err) => console.log(err));
  };
  useEffect(() => {
    getLoggerData();
  }, []);

  const indexOfLastEntry = currentPage*postPerPage;
  const indexOfFirstEntry =indexOfLastEntry-postPerPage;
  const currentLoggerDetails = logDetails.slice(indexOfFirstEntry,indexOfLastEntry);
  const getCurrentPage = (value)=>{
    setCurrentPage(value);
  } 
  return (
    <>
    <table className="table table-bordered border-dark table-hover">
      <thead>
        <tr className="header">
          <th>Logger ID</th>
          <th>Customer</th>
          <th>Transaction ID</th>
          <th>Transfer Date</th>
          <th>Amount</th>
        </tr>
      </thead>
      <tbody>
        {currentLoggerDetails.map((value,index) => {
          return (
            <tr key={index}>
              <td>{value.loggerId}</td>
              <td>
                  <div>
                    {value.customer.accountHolderName}
                  </div>
                  <div>
                      <p className="text-muted">#{value.customer.customerId}</p>
                  </div>
              </td>
              <td>
                <Link to={`/transaction/${value.transaction.transactionId}`}>
                  {value.transaction.transactionId}
                </Link>
              </td>
              <td>
                  {value.transaction.transferDate}
              </td>
              <td>Rs {value.transaction.inrAmount}</td>
            </tr>
          );
        })}
      </tbody>
    </table>
    <Pagination totalPages={logDetails.length} postPerPage={postPerPage} getPageNumber={getCurrentPage}/>
    </>
  );
};

export default LoggerTable;
