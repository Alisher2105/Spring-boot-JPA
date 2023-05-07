package org.example.SpringbootJPA.controller;

import org.example.SpringbootJPA.model.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController

public class PersonController {

    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1,"Alisher","Rajabov",new Date(),"+998919138316"),
            new Student(2,"Ganisher","Rajabboyev",new Date(),"+998914324812"),
            new Student(3,"Mahliyo","Jumanazarova",new Date(),"+998943118865"),
            new Student(4,"Mohinur","Rajabova",new Date(),"+998742222222")
    ));


    //Student royhatini olish
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public List <Student> getStudents(){
        return students;
    }

    // bitta studentni olish
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable Integer id){
        for (Student student : students) {
            if(student.getId() == id){
                return student;
            }
        }
        return new Student();
    }

    //Client tarafdan json faylni gson orqali student clasiga o`tkazish
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student){
        student.setId(students.get(students.size() - 1).getId() + 1);
        students.add(student);
        return "Student qo`shildi";
    }

    // Delete
    @RequestMapping(value = "/student/{id}", method =RequestMethod.DELETE)
    public String deleteStudent(@PathVariable Integer id){
        boolean deleted = false;
        for (Student student : students) {
            if(student.getId() == id){
                students.remove(student);
                deleted = true;
                break;
            }
        }
        return deleted?"Student o`chirildi":"Student topilmadi";
    }


    // EDITE(Studentni id si bo`yicha o`zgartirish)
    @RequestMapping(value = "/student/{id}",method = RequestMethod.PUT)
    public String editeStudent(@PathVariable Integer id,@RequestBody Student student){
        boolean edited = false;
        for (Student currentStudent : students) {
            if (currentStudent.getId()== id){
                currentStudent.setFirstName(student.getFirstName());
                currentStudent.setLastName(student.getLastName());
                currentStudent.setBirthDate(student.getBirthDate());
                currentStudent.setPhoneNumber(student.getPhoneNumber());
                edited = true;
                break;
            }
        }
        if (edited)  // if ning o`rniga return edited ? "Student o`zgartirildi" : "Student topilmadi";
            return "Student o`zgartirildi";
        else
            return "Student Topilmadi";


    }

}
