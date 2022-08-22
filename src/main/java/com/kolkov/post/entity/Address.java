package com.kolkov.post.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private Integer index;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Office office;
}