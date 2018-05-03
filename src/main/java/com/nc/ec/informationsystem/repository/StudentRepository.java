package com.nc.ec.informationsystem.repository;


import com.nc.ec.informationsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Query("select all from student")
//    List<Student> findAll();
//
////    @Query("update ")
////    void update(Student student);
//
//    @Query(value = "insert into stundent (st_name, st_groupId, st_date) VALUES (?1, ?2, ?3)", nativeQuery = true)
//    void add(String name, long groupId, String date);
//
//    @Query("delete from student s where s.id = ?1")
//    void delete(long id);
}
