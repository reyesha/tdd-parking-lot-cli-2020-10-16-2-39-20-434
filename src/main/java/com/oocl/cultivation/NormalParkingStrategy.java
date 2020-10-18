package com.oocl.cultivation;

public class NormalParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingTicket park(ParkingBoy parkingBoy, Car car) throws Exception {
        ParkingTicket parkingTicket = new ParkingTicket();
        int counter = 1;
        for(ParkingLot lot : parkingBoy.parkingLotList) {
            if (lot.getParkedCars() < lot.getParkingLotCapacity()) {
               parkingTicket = lot.park(car);
               break;
            }
            counter++;
            if(counter > parkingBoy.parkingLotList.size()){
                throw new NotEnoughPositionException("Not enough position.");
            }
        }
        return parkingTicket;
    }
}
