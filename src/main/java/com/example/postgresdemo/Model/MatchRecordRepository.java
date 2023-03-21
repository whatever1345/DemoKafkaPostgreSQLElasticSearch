package com.example.postgresdemo.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchRecordRepository extends JpaRepository<MatchRecord, Integer> {

    @Query(value = "SELECT * FROM Match_Record r WHERE r.team = :team", nativeQuery = true)
    Optional<MatchRecord> findMatchRecordByTeam(@Param("team") String team);
}
