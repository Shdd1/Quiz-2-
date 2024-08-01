package com.example.testspringboot.Servic;

import com.example.testspringboot.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServeic {
    ArrayList<Student>students=new ArrayList<>();


    public ArrayList<Student> getstu(){
        return students;
    }
    public void addStu(Student student){
        students.add(student);
    }

    public boolean updatestu(int id,Student student){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                    students.set(i,student);
                    return true;
            }

        }
        return false;
    }

    public boolean deletstu(int id){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    public Student getStuByName(String name){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getName().equalsIgnoreCase(name)){
               students.add(students.get(i));
            }
        }
        return null;

    }
    public ArrayList<Student> getmajor(String major){
        ArrayList<Student>major1=new ArrayList<>();
        for(int i=0;i<students.size();i++){
            if(students.get(i).getMajor().equalsIgnoreCase(major)){
                major1.add(students.get(i));
            }
        }
        return major1;
    }
}
