package com.resuelve.dao;

import java.util.HashMap;
import java.util.Map;
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
		Map<String, Integer> golesPorEquipo = new HashMap<>();
		Map<String, Integer> requeridoPorEquipo = new HashMap<>();
		players.getPlayer().forEach((p) -> {
			Optional<ScoreByLevelEntity> optional = repository.findById(p.getNivel());
			if (optional.isPresent()) {
				ScoreByLevelEntity entity = optional.get();
				if(golesPorEquipo.containsKey(p.getEquipo())) {
					int goles = golesPorEquipo.get(p.getEquipo());
					int requerido = requeridoPorEquipo.get(p.getEquipo());
					golesPorEquipo.put(p.getEquipo(), p.getGoles() + goles);
					requeridoPorEquipo.put(p.getEquipo(), entity.getScore() + requerido);
				}
				else {
					golesPorEquipo.put(p.getEquipo(), p.getGoles());
					requeridoPorEquipo.put(p.getEquipo(), entity.getScore());
				}
			}
		});
		players.getPlayer().forEach((p) -> {
			Optional<ScoreByLevelEntity> optional = repository.findById(p.getNivel());
			if (optional.isPresent()) {
				ScoreByLevelEntity entity = optional.get();				
				String equipo = p.getEquipo();
				
				double porcEquipo = redondea((golesPorEquipo.get(equipo) * 100.0) / requeridoPorEquipo.get(equipo));
				porcEquipo = (porcEquipo > 100) ? 100.0 : porcEquipo;
				
				double porcInd = redondea((p.getGoles() * 100.0) / entity.getScore());
				porcInd = (porcInd > 100) ? 100.0 : porcInd;
				
				double bonoEquipo = redondea((p.getBono()/2) * porcEquipo / 100.0);
				double bonoInd = redondea((p.getBono()/2) * porcInd / 100.0);
				
				p.setSueldoCompleto(p.getSueldo() + bonoEquipo + bonoInd);
			}
		});
		return players;
	}
	
	private double redondea(double valor) {
		return Math.round(valor * 100.0)/100.0;
	}

}
