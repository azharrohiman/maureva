package com.maurevair.booking.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlAttribute;
//import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.List;

@Data
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorType(XmlAccessType.FIELD)
public class Flight {

//    @XmlAttribute
    @XmlAttribute
    private String id;

    @XmlAttribute(name = "Carrier")
    private String carrier;

    @XmlAttribute(name = "FlightNumber")
    private Long flightNumber;

    @XmlAttribute(name = "Origin")
    private String origin;

    @XmlAttribute(name = "Destination")
    private String destination;

    @XmlAttribute(name = "DepartureTime")
    private Date departureTime;

    @XmlAttribute(name = "ArrivalTime")
    private Date arrivalTime;

//    @XmlElement(name = "BookingInfo")
    @XmlElement(name = "BookingInfo")
    private List<FlightCabin> flightCabins;
}
