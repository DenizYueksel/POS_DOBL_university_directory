package com.university.directory.repositorys;

import com.university.directory.model.Student;
import org.springframework.data.repository.CrudRepository;

//Dieses Interface liefert uns einfach die standard CRUD Methoden wie CREATE , SELECT, UPDATE, DELETE;

public interface StudentRepo extends CrudRepository<Student, Long> {


}



