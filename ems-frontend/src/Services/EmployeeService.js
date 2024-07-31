
// importing axios 
import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/employees';

export const listEmployees = () => 
{
    return axios.get(REST_API_BASE_URL);
}
//OR
export const listOfEmployees = () => axios.get(REST_API_BASE_URL);

export const createEmployee = (employee) => axios.post(REST_API_BASE_URL,employee);

//GET By Id - Employee
export const getEmployee = (employeeId) => axios.get(REST_API_BASE_URL+"/"+employeeId);

//Update Employee
export const updateEmployee = (employeeId,employee) => axios.put(REST_API_BASE_URL+"/"+employeeId,employee);

//Delete Employee
export const deleteEmployeeApi = (employeeId) => axios.delete(REST_API_BASE_URL+"/"+employeeId);