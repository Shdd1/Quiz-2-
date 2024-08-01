package com.example.testspringboot.Servic;

import com.example.testspringboot.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher>teachers=new ArrayList<>();

    public ArrayList<Teacher> getTea(){
        return teachers;
    }

    public void addTea(Teacher teacher){
        teachers.add(teacher);
    }
    public boolean updateTea(int id,Teacher teacher){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                teachers.set(i,teacher);
                return true;
            }

        }
        return false;
    }
    public boolean deleteTea(int id){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                teachers.remove(i);
                return true;
            }

        }
        return false;
    }

    public Teacher searchById(int id){
        for(int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                return teachers.get(i);
            }
        }
        return null;
    }
    public ArrayList<Teacher> getSalary(int salary){
        ArrayList<Teacher>teachers1=new ArrayList<>();
        for(int i=0;i<teachers.size();i++){
           if(teachers.get(i).getSalary()==salary){
               teachers1.add(teachers.get(i));
           }
        }
        return teachers1;
    }
}
