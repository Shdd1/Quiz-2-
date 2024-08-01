package com.example.testspringboot.Controoler;

import com.example.testspringboot.ApiResponse.ApiResponse;
import com.example.testspringboot.Model.Teacher;
import com.example.testspringboot.Servic.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity getT(){
        return ResponseEntity.status(200).body( teacherService.getTea());
    }
    @PostMapping("/add")
    public ResponseEntity addtea(@Valid@RequestBody Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTea(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("is added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTea(@PathVariable int id,@Valid@RequestBody Teacher teacher,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated=teacherService.updateTea(id,teacher);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("is updated"));
        }
       return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTea(@PathVariable int id){
        boolean isDeleted=teacherService.deleteTea(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("IS deleted");
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }
    @GetMapping("/getid/{id}")
    public ResponseEntity searchId(@PathVariable int id){
        Teacher teacher=teacherService.searchById(id);
        if(teacher==null){
            return ResponseEntity.status(400).body("not found");
        }
        return ResponseEntity.status(200).body(teacherService.searchById(id));
    }
    @GetMapping("/get/{salary}")
    public ResponseEntity getSalary(@PathVariable int salary){
        teacherService.getSalary(salary);
        return ResponseEntity.status(200).body(teacherService.getSalary(salary));
    }



}
