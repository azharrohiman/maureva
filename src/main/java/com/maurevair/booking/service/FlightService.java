package com.maurevair.booking.service;

import com.maurevair.booking.model.Flight;
import com.maurevair.booking.repository.FlightRepository;
import com.maurevair.booking.xml.FlightCabin;
import com.maurevair.booking.xml.Flights;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportService airportService;

    public List<Flight> fetchAllFlights() {
        return new ArrayList<>(flightRepository.findAllFlights().stream().collect(Collectors.toMap(Flight::getFlightId,
                Function.identity(), (a, b) -> a.getFlightId().equals(b.getFlightId()) ? a : b, LinkedHashMap::new))
                .values());
    }

    public void uploadXMLFile(MultipartFile multipartFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Flights.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));

        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Flights flightsXML = (Flights) unmarshaller.unmarshal(file);

        var flights = flightsXML.getFlights();

        var flightObjects = new ArrayList<Flight>();

        flights.forEach(flight -> {
            Flight flightObj = new Flight();

            flightObj.setFlightId(flight.getId());
            flightObj.setCarrier(flight.getCarrier());
            flightObj.setFlightNumber(flight.getFlightNumber());
            flightObj.setOrigin(flight.getOrigin());
            flightObj.setDestination(flight.getDestination());
            flightObj.setDepartureTime(flight.getDepartureTime());
            flightObj.setArrivalTime(flight.getArrivalTime());
            flightObj.setAirport(airportService.findAirport(flight.getOrigin()).get());
            flightObj.setFlightCabins(saveFlightCabin(flight.getFlightCabins(), flightObj));

            flightObjects.add(flightObj);
        });

        flightRepository.saveAll(flightObjects);
    }

    private List<com.maurevair.booking.model.FlightCabin> saveFlightCabin(List<FlightCabin> flightCabins, Flight flight) {
        return flightCabins.stream()
                .map(flightCabinXML -> {
                    var flightCabin = new com.maurevair.booking.model.FlightCabin();

                    flightCabin.setFlight(flight);
                    flightCabin.setCabinClass(flightCabinXML.getCabinClass());
                    flightCabin.setSeatsAvailable(flightCabinXML.getSeatsAvailable());

                    return flightCabin;
                }).collect(Collectors.toList());
    }
}
