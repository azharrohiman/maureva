package com.maurevair.booking.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(
        name = FlightCabin.TABLE_NAME
)
@NoArgsConstructor
@AllArgsConstructor
public class FlightCabin {
    public static final String TABLE_NAME = "FLIGHT_CABIN";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(
//            name = TABLE_NAME + "_GENERATOR",
//            sequenceName = TABLE_NAME + "SEQUENCE"
//    )
    @Column(name = "FLIGHT_CABIN_KEY", nullable = false)
    Long flightCabinKey;

    @Column(name = "CABIN_CLASS", nullable = false)
    String cabinClass;

    @Column(name = "SEATS_AVAILABLE", nullable = false)
    Long seatsAvailable;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(
            name = "FLIGHT_ID",
            referencedColumnName = "FLIGHT_ID",
            foreignKey = @ForeignKey(name = TABLE_NAME + "_FK_" + Flight.TABLE_NAME)
    )
    Flight flight;
}
