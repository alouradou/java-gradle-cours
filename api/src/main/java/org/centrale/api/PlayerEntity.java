package org.centrale.api;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "player")
public class PlayerEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
