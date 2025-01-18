import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../node_modules/bootstrap/dist/js/bootstrap.min.js";
import NavBar from "./component/common/NavBar.jsx";
import Home from "./Home.jsx";
import StudentView from "./component/student/StudentView.jsx";
import AddStudents from "./component/student/AddStudents.jsx";
import EditStudent from "./component/student/EditStudent.jsx";

function App() {
  return (
    <div className="App">
      <Router>
        <NavBar />
        <Routes>
          
          <Route exact path="/" element={<Home />} />
        
          <Route exact path="/view-students" element={<StudentView/>} />

          <Route exact path="/add-student" element={<AddStudents />} />

          <Route exact path="/edit-student/:id" element={<EditStudent />} />


        </Routes>
      </Router>
    </div>
  );
}

export default App;
