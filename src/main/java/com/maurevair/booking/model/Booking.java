package com.maurevair.booking.model;

import com.maurevair.booking.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(
        name = Booking.TABLE_NAME
)
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    public static final String TABLE_NAME = "BOOKING";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKING_KEY", nullable = false)
    Long bookingKey;

    @OneToOne
    @JoinColumn(
            name = FlightCabin.TABLE_NAME + "_KEY",
            foreignKey = @ForeignKey(name = TABLE_NAME + "_FK_" + FlightCabin.TABLE_NAME)
    )
    FlightCabin flightCabin;

    @ManyToOne
    @JoinColumn(
            name = "USER_ID",
            foreignKey = @ForeignKey(name = TABLE_NAME + "_FK" + User.TABLE_NAME)
    )
    User user;
}
