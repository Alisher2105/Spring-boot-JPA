package org.example.SpringbootJPA.controller;

import org.example.SpringbootJPA.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
