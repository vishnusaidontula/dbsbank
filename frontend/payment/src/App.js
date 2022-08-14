import { BrowserRouter, Route, Routes } from "react-router-dom";
import ViewTransaction from "./components/organisms/view transaction/ViewTransaction.js";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/transaction/:id" element={<ViewTransaction />}></Route>
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
