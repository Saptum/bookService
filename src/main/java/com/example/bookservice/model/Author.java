package com.example.bookservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    private Long authorId;
    private String firstName;
    private String lastName;
    private String country;
    private String sex;
    private String email;
    private Date date;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private Set<Book> books = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private Set<Reward> rewards = new HashSet<>();

}
