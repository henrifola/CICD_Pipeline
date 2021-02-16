package com.cicdtut.blogsite.service;


import com.cicdtut.blogsite.entity.PokemonType;
import com.cicdtut.blogsite.repository.PokemonTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PokemonService {

    @Autowired
    private PokemonTypeRepo repo;

    public Collection<PokemonType> findAllTypes() {
        return repo.findAll();
    }

    public PokemonType getPokemonByType(String pType) {
        return repo.findByName(pType);
    }
}
