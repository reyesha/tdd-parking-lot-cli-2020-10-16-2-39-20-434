package com.oocl.cultivation;

public class SmartParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingTicket park(ParkingBoy parkingBoy, Car car) throws Exception {
        ParkingLot preferredParkingLot = parkingBoy.parkingLotList.get(0);
        for(ParkingLot lot : parkingBoy.parkingLotList) {
            int emptyLots1 = lot.getParkingLotCapacity() - lot.getParkedCars();
            int emptyLots2 = preferredParkingLot.getParkingLotCapacity() - preferredParkingLot.getParkedCars();

            if(emptyLots1 > emptyLots2){
                preferredParkingLot = lot;
            }
        }

        return preferredParkingLot.park(car);
    }
}
