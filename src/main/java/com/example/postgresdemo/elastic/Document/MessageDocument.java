package com.example.postgresdemo.elastic.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "message_index")
public class MessageDocument {
    @Id
    int id;

    @Field(type = FieldType.Text, name = "blue_team")
    private String blueTeam;

    @Field(type = FieldType.Text, name = "red_team")
    private String redTeam;

    @Field(type = FieldType.Integer, name = "result")
    private int result;

    public int getId() {
        return id;
    }

    public String getBlueTeam() {
        return blueTeam;
    }

    public String getRedTeam() {
        return redTeam;
    }

    public int getResult() {
        return result;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBlueTeam(String blueTeam) {
        this.blueTeam = blueTeam;
    }

    public void setRedTeam(String redTeam) {
        this.redTeam = redTeam;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MessageDocument{" +
                "id=" + id +
                ", blueTeam='" + blueTeam + '\'' +
                ", redTeam='" + redTeam + '\'' +
                ", result=" + result +
                '}';
    }
}
