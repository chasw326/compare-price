package com.example.comparePrice.dto;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class mosterMart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Ino;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = true)
    private String content;

    @Column(length = 30, nullable = false)
    private String price;

}
