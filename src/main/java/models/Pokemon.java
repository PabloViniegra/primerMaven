package models;

import com.fasterxml.jackson.databind.JsonNode;

public class Pokemon {
    private int id;
    private JsonNode name;
    private JsonNode baseExperience;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JsonNode getName() {
        return name;
    }

    public void setName(JsonNode name) {
        this.name = name;
    }

    public JsonNode getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(JsonNode baseExperience) {
        this.baseExperience = baseExperience;
    }
}
