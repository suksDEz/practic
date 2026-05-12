package org.example.weather.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weather {

    @Id
    @GeneratedValue
    private int id;

    private double latitude;

    private double longitude;

    private String weather;

    private double temperature;

    public Weather(double latitude,
                   double longitude,
                   String weather,
                   double temperature) {

        this.latitude = latitude;
        this.longitude = longitude;
        this.weather = weather;
        this.temperature = temperature;
    }
}