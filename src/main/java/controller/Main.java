package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Encounter;
import models.Pokemon;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class Main {
    public static final String URL = "https://pokeapi.co/api/v2/";
    public static final String USERAGENT = "Pablo";
    public static Pokemon pokemon = new Pokemon();
    public static Encounter enc = new Encounter();
    public static void main(String[] args) {
        requestAPI();
        printPokemonData(pokemon);

        requestAPIEncounters();
        printEncounterData(enc);
    }

    public static void requestAPI () {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.set(HttpHeaders.USER_AGENT, USERAGENT);
        HttpEntity <Object> request = new HttpEntity<>(header);
        ResponseEntity<String> firstPokemon = restTemplate.exchange(
                URL+"/pokemon/1",
                HttpMethod.GET,
                request,
                String.class
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(firstPokemon.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assert root != null;
        JsonNode name = root.path("name");
        pokemon.setName(name);
        pokemon.setId(1);
        JsonNode baseExperience = root.path("base_experience");
        pokemon.setBaseExperience(baseExperience);

    }

    public static void printPokemonData (Pokemon p) {
        System.out.println("Id Pokemon: " + p.getId());
        System.out.println("Nombre Pokemon: " + p.getName());
        System.out.println("Experiencia base del Pokemon: " + p.getBaseExperience());
    }

    public static void requestAPIEncounters () {
        RestTemplate rest = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.set(HttpHeaders.USER_AGENT, USERAGENT);
        HttpEntity <Object> request = new HttpEntity<>(header);
        ResponseEntity <String> encounter = rest.exchange(
          URL + "/encounter-condition/",
          HttpMethod.GET,
          request,
          String.class
        );

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(encounter.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assert root != null;
        JsonNode id = root.path("id");
        enc.setId(id);
        JsonNode name = root.path("name");
        enc.setName(name);
        JsonNode values = root.path("values");
        enc.setValues(values);
    }

    public static void printEncounterData (Encounter e) {
        System.out.println("ID ENCOUNTER: " + e.getId());
        System.out.println("NAME ENCOUNTER: " + e.getName());
        System.out.println("VALUES ENCOUNTER: " + (e.getValues()));
    }
}
