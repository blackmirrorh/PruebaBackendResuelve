package com.resuelve.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SCORE_BY_LEVEL")
public class ScoreByLevelEntity {

	@Id
	@Column(name = "LEVEL")
	private String level;
	
	@Column(name = "SCORE")
	private int score;
}
