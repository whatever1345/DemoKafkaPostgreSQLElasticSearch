package com.example.postgresdemo.Model;

import jakarta.persistence.*;

@Entity
@Table
public class MatchRecord {
    @Id
    @SequenceGenerator(
            name = "id_generator",
            sequenceName = "record_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_generator"
    )
    Integer id;

    private String team;
    private int matches;

    private int wins;

    public MatchRecord(){
    }

    public MatchRecord(String team, int win){
        this.team = team;
        this.matches = 1;
        if (win != 0)
            this.wins = 1;
        else
            this.wins = 0;
    }

    public Integer getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public int getMatches() {
        return matches;
    }

    public int getWins() {
        return wins;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "MatchRecord{" +
                "id=" + id +
                ", team='" + team + '\'' +
                ", matches=" + matches +
                ", wins=" + wins +
                '}';
    }
}
