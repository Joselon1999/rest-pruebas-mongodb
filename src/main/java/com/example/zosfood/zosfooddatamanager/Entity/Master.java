package com.example.zosfood.zosfooddatamanager.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "masters")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Master {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @Column(name = "idServant")
    private Servant servant;
}
