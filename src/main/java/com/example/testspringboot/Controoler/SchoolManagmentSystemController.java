package com.example.testspringboot.Controoler;

import com.example.testspringboot.ApiResponse.ApiResponse;
import com.example.testspringboot.Model.Student;
import com.example.testspringboot.Model.Teacher;
import com.example.testspringboot.Servic.StudentServeic;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class SchoolManagmentSystemController {
    private final StudentServeic studentServeic;
    @GetMapping("/get")
    public ResponseEntity getStudent(){

        return ResponseEntity.status(200).body(studentServeic.getstu());

    }
    @PostMapping("/add")
    public ResponseEntity addstudent(@Valid@RequestBody Student student, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentServeic.addStu(student);
        return ResponseEntity.status(200).body(new ApiResponse("is added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updatestudent(@PathVariable int id,@Valid@RequestBody Student student, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate=studentServeic.updatestu(id,student);
        if(isUpdate){
            return ResponseEntity.status(200).body("IS updated");
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletStudent(@PathVariable int id){
        boolean isDeleted=studentServeic.deletstu(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("is deleted");
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));

    }
    @GetMapping("/getn/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        Student student=studentServeic.getStuByName(name);
        if(student==null){
            return ResponseEntity.status(400).body("not found");
        }
        return ResponseEntity.status(200).body(studentServeic.getStuByName(name));
    }
    @GetMapping("/getm/{major}")
    public ResponseEntity major(@PathVariable String major){
        studentServeic.getmajor(major);
        return ResponseEntity.status(200).body(studentServeic.getmajor(major));

    }


}
