package com.maurevair.booking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table(
        name = Airport.TABLE_NAME
)
@NoArgsConstructor
@AllArgsConstructor
public class Airport {
    public static final String TABLE_NAME = "AIRPORT";

    @Id
    @NonNull
    @Column(name = "AIRPORT_CODE", length = 10, nullable = false)
    String airportCode;

    @NonNull
    @Column(name = "COUNTRY", length = 25, nullable = false)
    String country;

    @Column(name = "REGION", length = 30)
    String region;

    @NonNull
    @Column(name = "CITY", length = 40, nullable = false)
    String city;
}
