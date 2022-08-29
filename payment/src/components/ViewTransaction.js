/* eslint-disable no-undef */
import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import getList from "../services/getList";
const ViewTransaction = () => {
  const [transactionDetails, setTransactionDetails] = useState({});
  const params = useParams();
  const [loading, setLoading] = useState(true);
  const [amount,setAmount]=useState();
  useEffect(() => {
    async function getData() {
      await getList(`/transaction/${params.id}`)
        .then((res) => {
          console.log(`inside get list api of value /transaction/id` + res);
          setTransactionDetails(res);
          setLoading(false);
          setAmount( parseFloat(res.currency.conversionRate)*parseFloat(res.currencyAmount))
        })
        .catch((err) => {
          console.log(err);
          setLoading(false);
        });
    }
    getData();
  }, [params]);
  return (
    <>
      {loading ? (
        <h1>loading</h1>
      ) : (
        <div className="container-fluid">
          <div className="d-flex justify-content-between align-items-center py-3">
            <h2 className="h5 mb-0">
              Transaction
              <span className="text-muted">
                #{transactionDetails.transactionId}
              </span>
            </h2>
          </div>
          <div className="row">
            <div className="col-lg-8">
              <div className="card">
                <div className="card-body mb-0 pb-0">
                  <div className="mb-3 d-flex justify-content-between">
                    <div>
                      <span className="me-3">
                        {transactionDetails.transferDate}
                      </span>
                      <span className="me-3">
                        #{transactionDetails.transactionId}
                      </span>
                      <span className="badge rounded-pill bg-danger">
                        TRANSACTION
                      </span>
                    </div>
                    <div className="d-md-flex  ">
                      <span className="text">Invoice</span>
                    </div>
                  </div>
                  <table className="table table-borderless mb-0 pb-0">
                    <tbody>
                      <tr>
                        <td>
                          <h6 className="small mb-0">
                            <span className="text-reset">Message</span>
                          </h6>
                        </td>
                        <td className="text-end">
                          {transactionDetails.message.instruction}
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <h6 className="small mb-0">
                            <span className="text-reset">
                              {transactionDetails.currency.currencyName}
                            </span>
                          </h6>
                          <span className="small">
                            {transactionDetails.currency.currencyCode}
                          </span>
                        </td>
                        <td className="text-end">
                          ₹ {transactionDetails.currency.conversionRate}
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <h6 className="small mb-0">
                            <span className="text-reset">Currency Amount</span>
                          </h6>
                        </td>
                        <td className="text-end">
                          ₹ {transactionDetails.currencyAmount}
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <h6 className="small mb-0">
                            <span className="text-reset">Amount</span>
                          </h6>
                        </td>
                        <td className="text-end">
                          ₹ {amount}
                        </td>
                      </tr>
                      
                      <tr>
                        <td>
                          <h6 className="small mb-0">
                            <span className="text-reset">Transfer Fee</span>
                          </h6>
                        </td>
                        <td className="text-end">
                          ₹ {transactionDetails.transferFee}
                        </td>
                      </tr>

                      <tr className="fw-bold">
                        <td>
                          <span className="text-reset">
                            Total Transaction amount
                          </span>
                        </td>
                        <td className="text-end">
                          ₹ {transactionDetails.inrAmount}
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <div className="col-lg-4">
              <div className="card mb-4">
                <div className="card-body">
                  <h3 className="h6">Sender Information</h3>
                  <table>
                    <tbody>
                      <tr className="fw-bold">
                        <td>
                          <span className="text-reset">Customer ID</span>
                        </td>
                        <td className="p-2 text-end text-muted">
                          #{transactionDetails.customer.customerId}
                        </td>
                      </tr>
                      <tr className="fw-bold">
                        <td>
                          <span className="text-reset">
                            Account Holder Name
                          </span>
                        </td>
                        <td className="p-2 text-end text-muted">
                          {transactionDetails.customer.accountHolderName}
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div className="card mb-4">
                <div className="card-body">
                  <h3 className="h6">Receiver Information</h3>
                  <table>
                    <tbody>
                      <tr className="fw-bold">
                        <td>
                          <span className="text-reset">
                            Account Holder Number
                          </span>
                        </td>
                        <td className="p-2 text-end text-muted">
                          #{transactionDetails.receiverAccountHolderNumber}
                        </td>
                      </tr>
                      <tr className="fw-bold">
                        <td>
                          <span className="text-reset">
                            Account Holder Name
                          </span>
                        </td>
                        <td className="p-2 text-end text-muted">
                          {transactionDetails.receiverAccountHolderName}
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default ViewTransaction;
