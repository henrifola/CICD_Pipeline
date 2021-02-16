package com.cicdtut.blogsite.repository;
import com.cicdtut.blogsite.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cicdtut.blogsite.entity.PokemonType;
import java.util.List;
public interface PokemonTypeRepo extends JpaRepository<PokemonType, Long > {
    PokemonType findByName(String name);

}
