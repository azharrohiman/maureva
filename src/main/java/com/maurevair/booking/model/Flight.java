package com.maurevair.booking.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(
        name = Flight.TABLE_NAME
)
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    public static final String TABLE_NAME = "FLIGHT";

    @Id
    @Column(name = "FLIGHT_ID", length = 40, nullable = false)
    String flightId;

    @Column(name = "CARRIER", length = 10, nullable = false)
    String carrier;

    @Column(name = "FLIGHT_NUMBER", nullable = false)
    Long flightNumber;

    @Column(name = "ORIGIN", length = 10, nullable = false)
    String origin;

    @Column(name = "DESTINATION", length = 10, nullable = false)
    String destination;

    @Column(name = "DEPARTURE_TIME", nullable = false)
    Date departureTime;

    @Column(name = "ARRIVAL_TIME", nullable = false)
    Date arrivalTime;

    @ManyToOne
    @JoinColumn(
            name = "AIRPORT_CODE",
            foreignKey = @ForeignKey(name = TABLE_NAME + "_FK_" + Airport.TABLE_NAME)
    )
    Airport airport;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    List<FlightCabin> flightCabins;


}
