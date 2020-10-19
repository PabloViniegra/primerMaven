package models;

import com.fasterxml.jackson.databind.JsonNode;

public class Encounter {
    private JsonNode id;
    private JsonNode name;
    private JsonNode values;

    public JsonNode getId() {
        return id;
    }

    public void setId(JsonNode id) {
        this.id = id;
    }

    public JsonNode getName() {
        return name;
    }

    public void setName(JsonNode name) {
        this.name = name;
    }

    public JsonNode getValues() {
        return values;
    }

    public void setValues(JsonNode values) {
        this.values = values;
    }
}
