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

        PokemonType grass = repo.findByName("Grass");
        PokemonType water = repo.findByName("Water");
        PokemonType fairy = repo.findByName("Fairy");
        PokemonType fire = repo.findByName("Fire");

        Pokemon bulbasaur = Pokemon.builder().id(1).name("Bulbasaur").build();
        Pokemon ivysaur = Pokemon.builder().id(2).name("Ivysaur").build();
        Pokemon venusaur = Pokemon.builder().id(3).name("Venusaur").build();

        Pokemon sq = Pokemon.builder().id(7).name("Squirtle").build();
        Pokemon wa = Pokemon.builder().id(8).name("Wartortle").build();
        Pokemon bl = Pokemon.builder().id(9).name("Blastoise").build();

        Pokemon cl = Pokemon.builder().id(35).name("Clefairy").build();
        Pokemon to = Pokemon.builder().id(175).name("Togepi").build();
        Pokemon sn = Pokemon.builder().id(209).name("Snubbull").build();

        Pokemon ch = Pokemon.builder().id(4).name("Charmander").build();
        Pokemon vu = Pokemon.builder().id(37).name("Vulpix").build();
        Pokemon ni = Pokemon.builder().id(38).name("Ninetales").build();

        Set<Pokemon> grassSet = new HashSet<>(Arrays.asList(bulbasaur, ivysaur, venusaur));
        Set<Pokemon> waterSet = new HashSet<>(Arrays.asList(sq, wa, bl));
        Set<Pokemon> fairySet = new HashSet<>(Arrays.asList(cl, to, sn));
        Set<Pokemon> fireSet = new HashSet<>(Arrays.asList(ch, vu, ni));

        grass.setPokemon(grassSet);
        water.setPokemon(waterSet);
        fairy.setPokemon(fairySet);
        fire.setPokemon(fireSet);

        repo.save(grass);
        repo.save(water);
        repo.save(fairy);
        repo.save(fire);

        repo.findAll().forEach(System.out::println);

    }
}
