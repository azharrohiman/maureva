package com.maurevair.booking.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
//@XmlRootElement(name = "flights")
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "flights")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flights {

//    @XmlElement(name = "flight")
    @XmlElement(name = "flight")
    private List<Flight> flights;
}
