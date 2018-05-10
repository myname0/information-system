package com.nc.ec.informationsystem.repository;


import com.nc.ec.informationsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM Student", nativeQuery = true)
    List<Student> findAll();

    @Query(value = "SELECT * FROM  Student WHERE id = ?1", nativeQuery = true)
    Student findById(long id);

    @Query(value = "SELECT * FROM Student WHERE st_group_id = ?1", nativeQuery = true)
    List<Student> findByGroupId(long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Student SET st_name = ?2, st_group_id = ?3, st_date = ?4 WHERE  id = ?1", nativeQuery = true)
    void update(long id, String name, long groupId, String date);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Student (st_name, st_group_id, st_date) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void save(String name, long groupId, String date);

    @Modifying
    @Query("DELETE FROM Student WHERE id = ?1")
    void deleteById(long id);
}
