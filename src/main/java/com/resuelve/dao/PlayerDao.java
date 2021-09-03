package com.resuelve.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resuelve.entity.ScoreByLevelEntity;
import com.resuelve.model.Players;
import com.resuelve.repository.IScoreByLevelRepository;

@Component
public class PlayerDao implements IPlayerDao {

	@Autowired
	private IScoreByLevelRepository repository;
	
	@Override
	public Players returnPayment(Players players) {
		players.getPlayer().forEach((p) -> {
			Optional<ScoreByLevelEntity> optional = repository.findById(p.getNivel());
			if (optional.isPresent()) {
				ScoreByLevelEntity entity = optional.get();
				System.out.println("Nivel: " + entity.getLevel() + " Goles: " + entity.getScore());
			}
		});
		return players;
	}

}
