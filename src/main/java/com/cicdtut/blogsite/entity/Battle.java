package com.cicdtut.blogsite.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.Instant;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Battle {

    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private String gym;
    @ManyToMany
    private Set<Pokemon> attendees;
}
