package com.cicdtut.blogsite.entity;

import com.cicdtut.blogsite.entity.Battle;
import com.cicdtut.blogsite.entity.Pokemon;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "pokemon_type")
public class PokemonType {

    @Id
    @GeneratedValue
    private Integer id;
    @NonNull
    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<Pokemon> pokemon;

}