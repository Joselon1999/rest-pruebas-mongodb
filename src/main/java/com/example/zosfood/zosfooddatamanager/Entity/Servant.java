package com.example.zosfood.zosfooddatamanager.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "servants")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Servant {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "class")
    private String servantClass;
}
