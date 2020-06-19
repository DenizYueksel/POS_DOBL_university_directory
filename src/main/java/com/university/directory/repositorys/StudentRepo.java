package com.university.directory.repositorys;

import com.university.directory.model.Student;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface StudentRepo extends Repository<Student, long> {

    //hier bringen wir der Repository bei wie wir einen Studenten anhand seines Namens finden.
    //da die Name der Studenten nicht unique sind verwenden wir Iterable.
    //Springboot erkennt durch Itereble das eine Liste von Daten zurück kommt.

    public Iterable<Student> getStudentsByName(@Param("name")String name);

    }



