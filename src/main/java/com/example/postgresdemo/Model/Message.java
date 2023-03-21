package com.example.postgresdemo.Model;

import jakarta.persistence.*;

@Entity
@Table
public class Message {
    @Id
    @SequenceGenerator(
            name = "id_generator",
            sequenceName = "message_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_generator"
    )
    int id;

    private String blueTeam;
    private String redTeam;
    private int result;

    public Message() {
    }

    public Message(int id, String red_team, String blue_team, int result){
        this.id = id;
        this.blueTeam = blue_team;
        this.redTeam = red_team;
        this.result = result;
    }

    public Message(String red_team, String blue_team, int result){
        this.blueTeam = blue_team;
        this.redTeam = red_team;
        this.result = result;
    }

    public int getId(){
        return id;
    }

    public String getRedTeam(){
        return redTeam;
    }

    public String getBlueTeam(){
        return blueTeam;
    }

    public int getResult(){
        return result;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setBlueTeam(String blue_team){
        this.blueTeam = blue_team;
    }

    public void setRedTeam(String red_team){
        this.redTeam = red_team;
    }

    public void setResult(int result){
        this.result = result;
    }

    @Override
    public String toString() {
        return "MessageDocument{" +
                "id=" + id +
                ", blue team='" + blueTeam + '\'' +
                ", red team='" + redTeam + '\'' +
                ", result=" + result +
                '}';
    }
}