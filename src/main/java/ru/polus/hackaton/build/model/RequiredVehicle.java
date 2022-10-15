package ru.polus.hackaton.build.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredVehicle {
    @Id
    private Long id;

    private String characteristic;
    private String model;
}
