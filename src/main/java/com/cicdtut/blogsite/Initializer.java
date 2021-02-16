package com.cicdtut.blogsite;
import com.cicdtut.blogsite.entity.Battle;
import com.cicdtut.blogsite.entity.Pokemon;
import com.cicdtut.blogsite.entity.PokemonType;
import com.cicdtut.blogsite.repository.PokemonTypeRepo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

    private final PokemonTypeRepo repo;

    public Initializer(PokemonTypeRepo repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Fairy", "Water", "Grass", "Fire").forEach(name ->
                repo.save(new PokemonType(name)));

        PokemonType pokemonType = repo.findByName("Grass");
        //Battle b = Battle.builder().gym("Cerulean Gym")
        //        .date("16.02.21 13:00")
        //        .build();

        Pokemon bulbasaur = Pokemon.builder().id(1)
                .name("Bulbasaur")
                .build();
        Pokemon ivysaur = Pokemon.builder().id(2)
                .name("Ivysaur")
                .build();
        Pokemon venusaur = Pokemon.builder().id(3)
                .name("Venusaur")
                .build();
        Set<Pokemon> pokemonSet = new HashSet<>(Arrays.asList(bulbasaur, ivysaur, venusaur));
       pokemonType.setPokemon(pokemonSet);
        repo.save(pokemonType);

        repo.findAll().forEach(System.out::println);

    }
}
