package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    int parkingLotCapacity;
    int parkedCars;

    public ParkingLot(int parkingLotCapacity) {
        this.parkingLotCapacity = parkingLotCapacity;
    }

    public int getParkingLotCapacity() {
        return parkingLotCapacity;
    }

    private final Map<ParkingTicket,Car> ticketCarMap = new HashMap<>();


    public ParkingTicket park(Car car) {
        ParkingTicket ticket = new ParkingTicket();

        ticketCarMap.put(ticket,car);
        parkedCars += 1;
        return ticket;
    }

    public Map<ParkingTicket, Car> getTicketCarMap() {
        return ticketCarMap;
    }

    public int getParkedCars() {
        return parkedCars;
    }
}
