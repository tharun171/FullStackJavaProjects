import React, { useEffect, useState } from 'react'
import { deleteEmployeeApi, listEmployees } from '../Services/EmployeeService'

//CSS
import '../CssFolder/ListEmpCss.css'

//for user to navigate from one page to another
import {useNavigate} from 'react-router-dom';


const ListEmpComponent = () => {

    {/*Array of dummy data*/ }
    const dummyData =
        [
            {
                "id": 1,
                "firstName": "Ramesh",
                "lastName": "Fadatare",
                "email": "ramesh@gmail.com"
            },
            {
                "id": 2,
                "firstName": "Umesh",
                "lastName": "yadav",
                "email": "umesh@gmail.com"
            },
            {
                "id": 3,
                "firstName": "RajKumar",
                "lastName": "yadav",
                "email": "Rajkumar@gmail.com"
            }
        ]

    //to hold response to rest APi, we need to hold state(data)
    //so we use stateHook
    //first one is variable name,second one is function that update data
    const [employees, setEmployees] = useState([])   //initial value is empty array
    const navigator = useNavigate();

    function getAllEmployees()
    {
         //From EmployeeService.js
         listEmployees().then((response) => {
            setEmployees(response.data);
        }).catch(error => {
            console.error(error);
        })
    };

    useEffect(() => {
       getAllEmployees();
    }, [])

    //Js function to work on AddEmployee Button
    function addNewEmployee()
    {
        //When user click on button this url should be triggered
        navigator('/add-Employee');
    }
    function updateEmployee(employee)
    {
        navigator(`/updateEmployee/${employee.empId}`);
    }
    function deleteEmployee(employee)
    {
        console.log("deleting : "+employee.empId);
        deleteEmployeeApi(employee.empId).then((response) => 
        {
            console.log(response.data);
            getAllEmployees();
        }).catch(error => {
            console.error("Error:", error.response ? error.response.data : error.message);
        });
        
    }

    return (
        <div className="container mainContainer">
            <h2 className="text-center marginTop">List of Employees</h2>
            
            <button className="btn btn-primary AddEmployeeBtn" onClick={addNewEmployee}>Add Employee</button>

            {/*classNames from Bootstrap class styling*/}
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Employee Id</th>
                        <th>Employee First Name</th>
                        <th>Employee Last Name</th>
                        <th>Employee Email Id</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {/*Javascript to iterate over the array*/}
                    {
                        //dummyData.map(
                        employees.map(
                            empl =>
                                //names as per in EmployeeDto in SpringBoot
                                //Each row key should have diff Id, so we gave our Id
                                <tr key={empl.empId}>
                                    <td>{empl.empId}</td>
                                    <td>{empl.firstName}</td>
                                    <td>{empl.lastName}</td>
                                    <td>{empl.email}</td>
                                    <td>
                                        {/* we are iterating empl here */}
                                        <button className="btn btn-info" onClick={()=>updateEmployee(empl)}>Update</button>
                                        <button className="btn btn-danger" onClick={() => deleteEmployee(empl)}
                                            style={{marginLeft:'10px'}}
                                            >Delete</button>
                                    </td>
                                </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListEmpComponent