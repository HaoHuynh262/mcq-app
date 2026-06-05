package org.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qId;

    private String qContent;
    private String qPicture;
    private int qTopicId;

    private String qA;
    private String qB;
    private String qC;
    private String qD;

    private String qRight;  // answer
    private String qLevel;  // easy, medium, hard

    private int qStatus;   // đang dùng(1) hoặc không dùng(0)
}