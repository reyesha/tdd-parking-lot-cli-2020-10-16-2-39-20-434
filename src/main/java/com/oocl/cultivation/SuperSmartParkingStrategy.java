package com.oocl.cultivation;

public class SuperSmartParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingTicket park(ParkingBoy parkingBoy, Car car) throws Exception {
        ParkingLot preferredParkingLot = parkingBoy.parkingLotList.get(0);
        for(ParkingLot lot : parkingBoy.parkingLotList) {
            int availableParkingSlot1 =  lot.getParkingLotCapacity() - lot.getParkedCars();
            double positionRateParkingLot1 = availableParkingSlot1/lot.getParkingLotCapacity();
            int availableParkingSlot2 = preferredParkingLot.getParkingLotCapacity() - preferredParkingLot.getParkedCars();
            int positionRateParkingLot2 = availableParkingSlot2/preferredParkingLot.getParkingLotCapacity();

            if(positionRateParkingLot1 > positionRateParkingLot2){
                preferredParkingLot = lot;
            }
        }

        return preferredParkingLot.park(car);
    }
}
