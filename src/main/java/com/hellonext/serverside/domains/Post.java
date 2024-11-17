package com.hellonext.serverside.domains;

import java.util.Date;

import org.json.JSONObject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id
    Long id;
    String title;
    String body;
    Date dateCreated;
    Date lastUpdated;

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("title", this.title);
        json.put("body", this.body);
        json.put("dateCreated", this.dateCreated);
        json.put("lastUpdated", this.lastUpdated);
        return json;
    }
}
