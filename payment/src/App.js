import { BrowserRouter, Route, Routes } from "react-router-dom";
import DashBoard from "./pages/DashBoard.js";
import LoggerPage from "./pages/LoggerPage.js";
import LoginPage from "./pages/LoginPage.js";
import TransactionDetails from "./pages/TransactionDetails.js";
import TransactionFormPage from "./pages/TransactionFormPage.js";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/" element={<LoginPage/>}/>
          <Route path="/home" element={<DashBoard />}/>
          <Route path="/loggers" element={<LoggerPage />}/>
          <Route path="/transaction" element={<TransactionFormPage />}/>
          <Route path="/transaction/:id" element={<TransactionDetails />}></Route>
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
