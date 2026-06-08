package org.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "topic")
    private List<Question> questions = new ArrayList<>();
}