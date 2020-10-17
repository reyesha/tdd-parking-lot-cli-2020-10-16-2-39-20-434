package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int parkingLotCapacity = 1;
    private final Map<ParkingTicket,Car> ticketCarMap = new HashMap<>();
    public ParkingTicket park(Car car) {
        ParkingTicket ticket = new ParkingTicket();

        if (ticketCarMap.size() == parkingLotCapacity){
            return null;
        }else {
            ticketCarMap.put(ticket,car);
            return ticket;
        }
    }

    public Map<ParkingTicket, Car> getTicketCarMap() {
        return ticketCarMap;
    }
}
