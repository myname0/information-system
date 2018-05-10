package com.nc.ec.informationsystem.repository;

import com.nc.ec.informationsystem.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Groups, Long> {
    @Query(value = "SELECT * FROM GROUPS", nativeQuery = true)
    List<Groups> findAll();

    @Transactional
    @Modifying
    @Query(value = "UPDATE GROUPS SET gr_number = ?2, gr_faculty = ?3 WHERE id = ?1", nativeQuery = true)
    void update(long id, int number, String faculty);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO GROUPS (gr_number, gr_faculty) VALUES (?1, ?2)", nativeQuery = true)
    void save(int number, String faculty);

    @Modifying
    @Query(value = "DELETE FROM GROUPS G WHERE G.id = ?1", nativeQuery = true)
    void deleteById(long id);

    @Query(value = "SELECT * FROM GROUPS WHERE id = ?1", nativeQuery = true)
    Groups findById(long id);
}
