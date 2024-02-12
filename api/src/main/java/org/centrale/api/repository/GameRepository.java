package org.centrale.api.repository;

import org.centrale.api.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<GameEntity, Integer> {

    List<GameEntity> findByPlayer1IdOrPlayer2Id(Long playerId1, Long playerId2);

}