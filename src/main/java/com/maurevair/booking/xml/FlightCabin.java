package com.maurevair.booking.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Data;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlAttribute;

@Data
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorType(XmlAccessType.FIELD)
public class FlightCabin {

//    @XmlAttribute(name = "CabinClass")
    @XmlAttribute(name = "CabinClass")
    private String cabinClass;

//    @XmlAttribute(name = "SeatsAvailable")
    @XmlAttribute(name = "SeatsAvailable")
    private Long seatsAvailable;
}
