package com.nc.ec.informationsystem.repository;

import com.nc.ec.informationsystem.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Groups, Long> {
//    @Query("select all from group")
//    List<Groups> findAll();
//
////    @Query("update ")
////    void update(Student student);
//
//    @Query(value = "insert into group (st_name, st_groupId, st_date) VALUES (?1, ?2, ?3)", nativeQuery = true)
//    void add(String name, long groupId, String date);
//
//    @Query("delete from student s where s.id = ?1")
//    void delete(long id);
}
