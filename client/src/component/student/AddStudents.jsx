import axios from "axios";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const AddStudents = () => {

  let navigate=useNavigate();

  const [student, setStudents] = useState({
    firstName: "",
    lastName: "",
    email: "",
    department: "",
  });

  const { firstName, lastName, email, department } = student;

  const handleInputChange = (e) => {
    setStudents({ ...student, [e.target.name]: e.target.value });
  };

  
  const saveStudent= async (e)=>{
    e.preventDefault();
    await axios.post("http://localhost:8080/api/student/addStudent", student);
    navigate("/view-students");

  }

  

  return (
    <div className="col-sm-8 py-2 px-5">
      <form onSubmit={ (e)=> saveStudent(e)}>
        <div className="input-group mb-5">
          <label className="input-group-text" htmlFor="firstName">
            First Name
          </label>
          <input
            className="form-control col-sm-6"
            type="text"
            name="firstName"
            id="firstName"
            required
            value={firstName}
            onChange={handleInputChange}
          />
        </div>

        <div className="input-group mb-5">
          <label className="input-group-text" htmlFor="lastName">
            Last Name
          </label>
          <input
            className="form-control col-sm-6"
            type="text"
            name="lastName"
            id="lastName"
            required
            value={lastName}
            onChange={handleInputChange}
          />
        </div>

        <div className="input-group mb-5">
          <label className="input-group-text" htmlFor="email">
            Email
          </label>
          <input
            className="form-control col-sm-6"
            type="email"
            name="email"
            id="email"
            required
            value={email}
            onChange={handleInputChange}
          />
        </div>

        <div className="input-group mb-5">
          <label className="input-group-text" htmlFor="department">
            Department
          </label>
          <input
            className="form-control col-sm-6"
            type="text"
            name="department"
            id="department"
            required
            value={department}
            onChange={handleInputChange}
          />
        </div>

      
        <div className="col-sm-2">
          <button type="submit" className="btn btn-outline-success btn-lg">
            Save
          </button>
        </div>

        <div className="col-sm-2">
          <Link to={"/view-students"}
            type="button"
            className="btn btn-outline-warningbtn-lg">
          
            Cancel
          </Link>
        </div>

       
       
      </form>
    </div>
  );
};

export default AddStudents;
