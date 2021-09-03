package com.resuelve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.resuelve.entity.ScoreByLevelEntity;

public interface IScoreByLevelRepository extends JpaRepository<ScoreByLevelEntity, String> {

}
