package com.shule.Students;

//import co.ke.emtechhouse.es.Auth.utils.Response.ApiResponse;
import com.shule.utils.Response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentsService {

    @Autowired
    StudentsRepository studentsRepository;



    public  Students saveAdvert(Students students){
        try {
            Students saveStudent = studentsRepository.save(students);
            return saveStudent;
        }catch (Exception e) {
            System.out.println("Catched Error {} " + e);
            return null;
        }
    }


    public List<Students> getAll() {
        try {
            List<Students> allStudents = studentsRepository.findAll();
            return allStudents;
        }catch (Exception e) {
            System.out.println("Catched Error {} " + e);
            return null;
        }

    }

    public  Students getStudentByRegistrationNumber(String registrationNumber){
        try {
           Students student = studentsRepository.findByregistrationNumber(registrationNumber);
            return student;
        }catch (Exception e) {
            System.out.println("Catched Error {} " + e);
            return null;
        }
    }

//    public static ApiResponse<Students> updateStudent(Students student, String registrationNumber) {
//        try {
//            ApiResponse response = new ApiResponse<>();
//            Optional<Students> existingStudent = StudentsRepository.searchByregNumber(registrationNumber);
//            if (existingStudent.isPresent()) {
//
//                System.out.println(existingStudent);
//
////                student.get
//
////                Students existingStude = existingStudent.get();
////                existingStude.setCharges(student.get);
////                existingStude.setBusinessName(advert.getBusinessName());
////                existingStude.setBusinessDescription(advert.getBusinessDescription());
////
////                Advertisement SavedAd = AdsRepo.save(existingAd);
//                response.setMessage("Advertisement  updated successfully");
//                response.setStatusCode(HttpStatus.OK.value());
////                response.setEntity(SavedAd);
//                return response;
//            } else {
//                response.setMessage("Advertisement Not found");
//                response.setStatusCode(HttpStatus.NOT_FOUND.value());
//            }
//
//
//            return response;
//        } catch (Exception e) {
//            System.out.println("Catched Error {}" + e);
//            return null;
//        }
//    }







}
