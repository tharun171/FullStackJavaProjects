
import './App.css'
import FooterComponent from './Components/FooterComponent'
import HeaderComponent from './Components/HeaderComponent'
import ListEmpComponent from './Components/ListEmpComponent'
import AddEmployeeComponent from './Components/AddEmployeeComponent'
import HelloWorld from './HelloWorld'

//import routing related components
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {


  return (
    //Single line Comment
    <>
      {/*Multi Line Comment*/}
      <BrowserRouter>
        {/* This is from HelloWorld.jsx */}
        {/*<HelloWorld/>*/}

        <HeaderComponent />
        <Routes>

          {/*When user click / this should be rendered
          http://localhost:3000   */}
          <Route path="/" element={
            //List Emp Component from Components Folder - gives a table with list of employees
            <ListEmpComponent />
          }></Route>

          {/*When user gives /employees we want to show all employees
          http://localhost:3000/employees   */}
          <Route path="/employees" element={
            <ListEmpComponent />
          }></Route>

          {/* http://localhost:3000/add-Employee  */}
          <Route path="/add-Employee" element={
            <AddEmployeeComponent/>
          }></Route>

           {/* http://localhost:3000/updateEmployee/id  */}
           <Route path="/updateEmployee/:id" element={
            <AddEmployeeComponent/>
          }></Route>

        </Routes>
        <FooterComponent />
      </BrowserRouter>

    </>
  )
}

export default App
