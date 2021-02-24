package com.cicdtut.blogsite.controller;


import com.cicdtut.blogsite.entity.PokemonType;
import com.cicdtut.blogsite.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/pokemontype")
public class Controller {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("")
    Collection<PokemonType> allTypes(){
        return pokemonService.findAllTypes();
    }
    @GetMapping("/{type}")
    public PokemonType getPokemonByType(@PathVariable("type") String pType){

        return pokemonService.getPokemonByType(pType);
    }



}
