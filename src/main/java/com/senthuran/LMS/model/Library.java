package com.senthuran.LMS.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "library",
        uniqueConstraints={
                @UniqueConstraint(columnNames = "name")
        }
)
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @NotEmpty
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Book> books;
}
