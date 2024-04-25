package com.spring.crud.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.crud.Entity.courseDeptData;

@Repository
public interface courseDeptDatarepository extends JpaRepository<courseDeptData, Long> {

    @Query("SELECT cdt FROM courseDeptData cdt WHERE cdt.type = :type")
    List<courseDeptData> getDepartmentMasterData( courseDeptData.DeptCourseType type);
}
