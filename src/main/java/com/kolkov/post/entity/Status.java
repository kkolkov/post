package com.kolkov.post.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kolkov.post.model.StatusType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dispatch_id")
    @JsonBackReference
    private Dispatch dispatch;

    @ManyToOne
    @JoinColumn(name = "office_id")
    @JsonManagedReference
    private Office office;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    private Timestamp date_time;
}
