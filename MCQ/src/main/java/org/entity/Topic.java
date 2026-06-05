package org.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tpID;

    private String tpTitle;
    private int tpParent;
    private int tpStatus;

    @Override
    public String toString() {
        return tpTitle;
    }
}