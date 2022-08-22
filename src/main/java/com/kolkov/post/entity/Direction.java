package com.kolkov.post.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer index;
    private String address;

    @OneToOne(mappedBy = "direction")
    private Customer customer;
}