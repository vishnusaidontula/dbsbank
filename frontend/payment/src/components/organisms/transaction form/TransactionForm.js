import React, { useState, useEffect } from "react";
import getList from "../../../services/getList";
import postElement from "../../../services/postElement";
import Button from "../../atom/button/Button";
import Input from "../../atom/input/Input";
import DropDown from "../DropDown/DropDown";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
const TransactionForm = () => {
  const [customerId, setCustomerId] = useState();
  const [customer, setCustomer] = useState(null);
  const [senderBIC, setSenderBIC] = useState();
  const [receiverAccountHolderNumber, setReceiverAccontNumber] = useState();
  const [receiverAccountHolderName, setReceiverAccontName] = useState();
  const [isReceiverBlocked, setReceiverBlocked] = useState(false);
  const [receiverBIC, setReceiverBIC] = useState();
  const [currency, setCurrency] = useState();
  const [currencyAmount, setCurrencyAmount] = useState();
  const [transferType, setTransferType] = useState();
  const [indianCurrencyAmount, setIndianCurrencyAmount] = useState();
  const [inrAmount, setInrAmount] = useState();
  const [transferFee, setTransferFee] = useState();
  const [message, setMessage] = useState();
  const[transferDate,setTransferDate] = useState(new Date());
  useEffect(() => {
    async function getCustomer() {
      await getList(`/customer/${customerId}`)
        .then((res) => {
          console.log(`inside get list api of value /transaction/id`);
          setCustomer(res);
          if (res.accountHolderName.includes("HDFC"))
            setTransferType({
              transferTypeCode: "Bank Transfer",
              description: "Transfer to BANK",
            });
          else
            setTransferType({
              transferTypeCode: "Customer Transfer",
              description: "Transfer to customer",
            });
        })
        .catch((err) => {
          console.log(err);
        });
    }
    customerId && getCustomer();
  }, [customerId]);
  useEffect(() => {
    async function checkreceiver() {
      await getList(`/checkreceiver/${receiverAccountHolderName}`)
        .then((res) => {
          console.log(`inside get list api of value /checkreceiver/id` + res);
          if (res === "Transaction Not Allowed") setReceiverBlocked(true);
          else setReceiverBlocked(false);
        })
        .catch((err) => {
          console.log(err);
        });
    }
    receiverAccountHolderName && checkreceiver();
  }, [receiverAccountHolderName]);
  function invalidCustomerId() {
    if (customerId && !customer)
      return (
        <span className="text-danger m-2">
          Please choose a valid customer id.
        </span>
      );
    return <span></span>;
  }
  useEffect(() => {
    function getAmount() {
      const amount = parseFloat(currency.conversionRate) * currencyAmount;
      const tranferFeeAmount = 0.1 * amount;
      setIndianCurrencyAmount(amount);
      setTransferFee(tranferFeeAmount);
      setInrAmount(amount + tranferFeeAmount);
    }
    currency && currencyAmount && getAmount();
  }, [currencyAmount, currency]);
  function handleSubmit(){
    const transaction = {
      customer: customer,
      currency: currency,
      senderBIC: senderBIC,
      receiverBIC: receiverBIC,
      receiverAccountHolderNumber: receiverAccountHolderNumber,
      receiverAccountHolderName: receiverAccountHolderName,
      transferType: transferType,
      message: message,
      currencyAmount: currencyAmount,
      transferFee: transferFee,
      inrAmount: inrAmount,
      transferDate:transferDate
    };
    postElement('/transaction',transaction).then(
      res=>console.log(res)
    ).catch(err=>console.log(err))
  }
  return (
    <div className="container-fluid">
      <form className="row g-3 needs-validation">
        <div className="d-flex justify-content-center align-items-center py-3">
          <h2 className="mb-0 text-danger">Transaction Form</h2>
        </div>
        <div className="row">
          <div className="col-lg-6">
            <div className="card">
              <div className="card-body">
                <table className="table table-borderless">
                  <tbody>
                    <tr>
                      <td>
                        <p className="h5 mb-0">
                          <span className="text-danger">Sender Details</span>
                        </p>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">Customer ID</span>
                        </h6>
                      </td>
                      <td className="ps-3">
                        <Input
                          type="text"
                          placeholder="Enter Customer ID"
                          handleKeyUp={(value) => setCustomerId(value)}
                          isRequired={true}
                        />
                        {invalidCustomerId()}
                        <div className="invalid-feedback">
                          <span>Please choose a valid customer id.</span>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">
                            Account Holder Name
                          </span>
                        </h6>
                      </td>
                      <td>
                        <p className="small mb-0">
                          {customer && (
                            <span className="text-mute">
                              {customer.accountHolderName}
                            </span>
                          )}
                        </p>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">BIC</span>
                        </h6>
                      </td>
                      <td className="ps-0">
                        <DropDown
                          url="/banks"
                          getById="bic"
                          getValue={(value) => setSenderBIC(value)}
                          placeholder="Select BIC Code"
                        />
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">Bank Name</span>
                        </h6>
                      </td>
                      <td>
                        <p className="small mb-0">
                          {senderBIC && (
                            <span className="text-reset">
                              {senderBIC.bankName}
                            </span>
                          )}
                        </p>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h5 className="mb-0">
                          <span className="text-danger">Receiver Details</span>
                        </h5>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">Account Number</span>
                        </h6>
                      </td>
                      <td className="ps-3">
                        <Input
                          type="text"
                          placeholder="Enter Account Holder Number"
                          handleKeyUp={(value) =>
                            setReceiverAccontNumber(value)
                          }
                          isRequired={true}
                        />
                        <div className="invalid-feedback">
                          <span>Please enter a receiver account number.</span>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">
                            Account Holder Name
                          </span>
                        </h6>
                      </td>
                      <td className="ps-3">
                        <Input
                          type="text"
                          placeholder="Enter Account Holder Name"
                          handleKeyUp={(value) => setReceiverAccontName(value)}
                          isRequired={true}
                        />
                        <div className="invalid-feedback">
                          <span>Please enter a receiver account number.</span>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">BIC</span>
                        </h6>
                      </td>
                      <td className="ps-0">
                        <DropDown
                          url="/banks"
                          getById="bic"
                          getValue={(value) => setReceiverBIC(value)}
                          placeholder="Select BIC Code"
                        />
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">Bank Name</span>
                        </h6>
                      </td>
                      <td>
                        <p className="small mb-0">
                          {receiverBIC && (
                            <span className="text-reset">
                              {receiverBIC.bankName}
                            </span>
                          )}
                        </p>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <div className="col-lg-6">
            <div className="card">
              <div className="card-body">
                <table className="table table-borderless">
                  <tbody>
                    <tr>
                      <td>
                        <h5 className="mb-0">
                          <span className="text-danger">
                            Transaction Details
                          </span>
                        </h5>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">Transaction Date</span>
                        </h6>
                      </td>
                      <td>
                        <DatePicker
                       minDate={new Date()}
                        selected={transferDate}
                        onChange={date => setTransferDate(date)}
                        dateFormat="yyyy/MM/dd"
                        />
                      </td>
                    </tr>

                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">Transfer Type</span>
                        </h6>
                      </td>
                      <td>
                        <p className="small mb-0">
                          {transferType && (
                            <span className="text-mute">
                              {transferType.transferTypeCode}
                            </span>
                          )}
                        </p>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">Message</span>
                        </h6>
                      </td>
                      <td className="ps-0">
                        <DropDown
                          url="message"
                          getById="messageCode"
                          getValue={(value) => setMessage(value)}
                          placeholder="Select Message Code"
                        />
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">Currency</span>
                        </h6>
                      </td>
                      <td className="ps-0">
                        <DropDown
                          url="currency"
                          getById="currencyCode"
                          getValue={(value) => setCurrency(value)}
                          placeholder="Select Currency"
                        />
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">Amount</span>
                        </h6>
                      </td>
                      <td className="ps-3">
                        <Input
                          type="number"
                          placeholder="Enter Amount"
                          step={0.01}
                          handleKeyUp={(value) => setCurrencyAmount(value)}
                          isRequired={true}
                        />
                        <div className="invalid-feedback">
                          <span>Please enter the amount.</span>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">
                            Indian Currency Amount
                          </span>
                        </h6>
                      </td>
                      <td>
                        <p className="small mb-0">
                          {indianCurrencyAmount && (
                            <span className="text-mute">
                              {indianCurrencyAmount}
                            </span>
                          )}
                        </p>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">Transfer Fee</span>
                        </h6>
                      </td>
                      <td>
                        <p className="small mb-0">
                          {transferFee && (
                            <span className="text-mute">{transferFee}</span>
                          )}
                        </p>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <h6 className="small mb-0">
                          <span className="text-reset">Total Amount</span>
                        </h6>
                      </td>
                      <td>
                        <p className="small mb-0">
                          {inrAmount && (
                            <span className="text-mute">{inrAmount}</span>
                          )}
                        </p>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
        <div className="col-12 justify-content-center align-items-center mx-auto d-flex ">
          <Button type="button" size="lg" text="Submit form" outline="danger" handleClick={handleSubmit} />
        </div>
      </form>
    </div>
  );
};

export default TransactionForm;
