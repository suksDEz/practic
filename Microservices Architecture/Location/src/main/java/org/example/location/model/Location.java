package org.example.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private String city;

    private double latitude;

    private double longitude;

    public Location(String city,
                    double latitude,
                    double longitude) {

        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}