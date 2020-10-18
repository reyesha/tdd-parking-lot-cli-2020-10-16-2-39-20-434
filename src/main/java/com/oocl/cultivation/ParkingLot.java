package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    int parkingLotCapacity;

    public ParkingLot(int parkingLotCapacity) {
        this.parkingLotCapacity = parkingLotCapacity;
    }

    private final Map<ParkingTicket,Car> ticketCarMap = new HashMap<>();
    public ParkingTicket park(Car car) throws NotEnoughPositionException {
        ParkingTicket ticket = new ParkingTicket();

        if (ticketCarMap.size() == parkingLotCapacity){
                throw new NotEnoughPositionException("Not enough position.");
        }else {
            ticketCarMap.put(ticket,car);
            return ticket;
        }
    }

    public Map<ParkingTicket, Car> getTicketCarMap() {
        return ticketCarMap;
    }
}
