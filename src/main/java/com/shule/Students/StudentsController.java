package com.shule.Students;

import com.shule.utils.Response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    public  StudentsController(){

    }

    @PostMapping("/add")
    public ResponseEntity<Object> addStudent(@RequestBody Students student) {
        try {
            Students saveStudent = studentsService.saveAdvert(student);
            return new ResponseEntity<>(saveStudent, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error" + e);
            return null;
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getAllStudents() {
        try {
            List<Students> allStudents = studentsService.getAll();
            return new ResponseEntity<>(allStudents, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error" + e);
            return null;
        }
    }

    @GetMapping("/get/{registrationNumber}")
    public ResponseEntity<Object> getStudent(@PathVariable String registrationNumber){
        try {
            Students student = studentsService.getStudentByRegistrationNumber(registrationNumber);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error" + e);
            return null;
        }
    }

//    @PutMapping("/update/{registrationNumber}")
//    public  ResponseEntity<?> updateStudent(@PathVariable String registrationNumber,
//                                           @RequestBody Students student){
//
//        try {
//            ApiResponse<Students> response = StudentsService.updateStudent(student, registrationNumber);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            System.out.println("Catched Error {} " + e);
//            return null;
//        }
//    }





}
