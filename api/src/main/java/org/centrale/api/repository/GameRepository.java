package org.centrale.api.repository;

import org.centrale.api.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<GameEntity, Integer> {

    List<GameEntity> findByNamePlayer1OrNamePlayer2(String namePlayer1, String namePlayer2);

}