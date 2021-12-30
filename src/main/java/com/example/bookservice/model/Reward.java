package com.example.bookservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rewards")
public class Reward {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
    private Author author;

    public void assignAuthor(Author author) {
        this.author = author;
    }
}
