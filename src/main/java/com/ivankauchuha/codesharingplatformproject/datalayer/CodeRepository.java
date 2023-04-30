package com.ivankauchuha.codesharingplatformproject.datalayer;

import com.ivankauchuha.codesharingplatformproject.entities.Code;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeRepository extends CrudRepository<Code, String> {
    @Query(value = "SELECT * FROM code WHERE NOT time_limit AND NOT views_limit ORDER BY date DESC LIMIT 10", nativeQuery = true)
    List<Code> findTopByOrderByCodeDesc();
}
