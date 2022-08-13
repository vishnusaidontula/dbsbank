import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import getList from "../../../services/getList";
import "./LoggerTable.css";
const LoggerTable = () => {
  const [logDetails, setLogDetails] = useState([]);
  const getLoggerData = () => {
    getList("/loggers")
      .then((res) => setLogDetails(res))
      .catch((err) => console.log(err));
  };
  useEffect(() => {
    getLoggerData();
  }, []);
  return (
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
        {logDetails.map((value) => {
          return (
            <tr>
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
  );
};

export default LoggerTable;
