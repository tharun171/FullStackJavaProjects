import React, { useEffect, useState } from 'react'
import { useAsyncError, useNavigate, useParams } from 'react-router-dom'
import { createEmployee, getEmployee, updateEmployee } from '../Services/EmployeeService'

const AddEmployeeComponent = () => {

  //Defining State Variables using stateHook
  //These 2 values will be strings, so gave '' in useState
  const [firstName, setFirstName] = useState('')
  const [lastName, setLastName] = useState('')
  const [email, setEmail] = useState('')
  //For user to navigate from one page to another
  const navigator = useNavigate();

  //Validations
  const [errors, setErrors] = useState({
    firstName: '',
    lastName: '',
    email: ''
  })
  function validateForm() {
    let valid = true;
    //... = spread Operator to copy object into another object
    //copying errors from above into errorsCopy
    const errorsCopy = { ...errors }
    if (firstName.trim()) {
      //setting error String value
      errorsCopy.firstName = '';
    } else {
      errorsCopy.firstName = "First name is required";
      valid = false;
    }
    if (lastName.trim()) {
      errorsCopy.lastName = '';
    } else {
      errorsCopy.lastName = "Last name is required";
      valid = false;
    }
    if (email.trim()) {
      errorsCopy.email = '';
    } else {
      errorsCopy.email = "Email is required";
      valid = false;
    }
    setErrors(errorsCopy);
    return valid;
  }

  //e is event
  //using Arrow function
  const handleFirstName = (e) => {
    //function for changing value
    setFirstName(e.target.value);
  }
  function handleLastName(e) { setLastName(e.target.value); }
  const handleEmail = (e) => { setEmail(e.target.value); }

  function saveOrUpdateEmployee(e) {
    e.preventDefault();
    if (validateForm()) {
      const employee = { firstName, lastName, email }
      console.log("employee " + employee)
      if (id) {
        console.log("inside update");
        //Calling updateEmployee method from EmployeeService.js
        updateEmployee(id, employee).then((response) => {
          console.log(response.data);
          //After adding or updating calling this url
          //navigate to this url - url configured in Routes - App.jsx
          //navigator("/");
          //or
          navigator("/employees");
        }).catch(error => {
          console.error(error);
        });
      }
      else {
        //Calling createEmployee method from EmployeeService.js
        createEmployee(employee).then((response) => {
          console.log(response.data);
          //After adding or updating calling this url
          //navigate to this url - url configured in Routes - App.jsx
          //navigator("/");
          //or
          navigator("/employees");
        })
      }
    }
  }

  //We get this id from ListEmpComponent when user submit update button
  const { id } = useParams();
  function pageTitle() {
    console.log(id);
    if (id) { return <h2 className="text-center">Update Employee</h2> }
    else { return <h2 className="text-center">Add Employee</h2> }
  }

  useEffect(() => {
    if (id) {
      getEmployee(id).then((response) => {
        setFirstName(response.data.firstName);
        setLastName(response.data.lastName);
        setEmail(response.data.email);
      }).catch(error => {
        console.error(error);
      })
    }
  }, [id])

  return (
    //container class taken from Bootstrap
    //Bootstrap imported in main.jsx
    <div className="container">
      <br /><br />
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          {
            //Calling pageTitle method() to get name dynamically
            pageTitle()
          }
          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="from-label">FirstName: </label>
                <input
                  type="text"
                  placeholder="Enter Employee First Name"
                  name="firstName"
                  value={firstName}
                  className={`form-control ${errors.firstName ? 'is-invalid' : ''}`}
                  //Js function to set firstName given by user
                  //onChange={handleFirstName}
                  //instead of using onChange like above - calling function
                  //we can directly pass them
                  onChange={(e) => setFirstName(e.target.value)}
                ></input>
                {errors.firstName && <div className="invalid-feedback">{errors.firstName}</div>}
              </div>
              <div className="form-group mb-2">
                <label className="from-label">LastName: </label>
                <input
                  type="text"
                  placeholder="Enter Employee Last Name"
                  name="lastName"
                  value={lastName}
                  className={`form-control ${errors.lastName ? 'is-invalid' : ''}`}
                  //Js function to set LastName given by user
                  onChange={handleLastName}
                ></input>
                {errors.lastName && <div className="invalid-feedback">{errors.lastName}</div>}
              </div>
              <div className="form-group mb-2">
                <label className="from-label">Email: </label>
                <input
                  type="text"
                  placeholder="Enter Employee Email"
                  //names are from const[var,func] - var
                  name="email"
                  value={email}
                  className={`form-control ${errors.email ? 'is-invalid' : ''}`}
                  //Js function to set email given by user
                  onChange={(e) => setEmail(e.target.value)}
                ></input>
                {errors.email && <div className="invalid-feedback">{errors.email}</div>}
              </div>
              <button className="btn btn-success" onClick={saveOrUpdateEmployee}>Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  )
}

export default AddEmployeeComponent