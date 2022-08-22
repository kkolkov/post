package com.kolkov.post.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private Set<Dispatch> dispatches = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "direction_id")
    @JsonBackReference
    private Direction direction;
}