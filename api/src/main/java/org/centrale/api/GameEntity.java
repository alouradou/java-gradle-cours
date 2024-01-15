package org.centrale.api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;

    private String namePlayer1;
    private String namePlayer2;

    private Integer scorePlayer1;
    private Integer scorePalyer2;

    public String getNamePlayer1() {
        return namePlayer1;
    }

    public void setNamePlayer1(String description) {
        this.namePlayer1 = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNamePlayer2() {
        return namePlayer2;
    }

    public void setNamePlayer2(String namePlayer2) {
        this.namePlayer2 = namePlayer2;
    }

    public Integer getScorePlayer1() {
        return scorePlayer1;
    }

    public void setScorePlayer1(Integer scorePlayer1) {
        this.scorePlayer1 = scorePlayer1;
    }

    public Integer getScorePalyer2() {
        return scorePalyer2;
    }

    public void setScorePalyer2(Integer scorePalyer2) {
        this.scorePalyer2 = scorePalyer2;
    }
}
