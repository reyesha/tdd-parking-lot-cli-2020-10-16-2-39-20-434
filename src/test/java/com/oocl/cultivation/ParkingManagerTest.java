package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingManagerTest {
    @Test
    void should_return_2_managed_parking_boys_when_adding_parking_boy_to_management_list_given_2_parking_boys() {
        //given
        List<ParkingLot> parkingLotList1 = new ArrayList<>();
        List<ParkingLot> parkingLotList2 = new ArrayList<>();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(10));
        parkingLotList1.add(new ParkingLot(10));
        parkingLotList2.add(new ParkingLot(10));

        //when
        ParkingManager parkingManager = new ParkingManager(parkingLotList, new NormalParkingStrategy());
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLotList1, new NormalParkingStrategy());
        ParkingBoy parkingBoy2 = new ParkingBoy(parkingLotList2, new SmartParkingStrategy());
        parkingManager.manage(parkingBoy1);
        parkingManager.manage(parkingBoy2);

        //then
        assertEquals(2, parkingManager.managedParkingBoys.size());
    }

    @Test
    void should_return_manager_can_park_or_fetch_when_adding_parking_boy_to_management_list_given_2_parking_boys() throws Exception {
        //given
        List<ParkingLot> parkingLotList1 = new ArrayList<>();
        List<ParkingLot> parkingLotList2 = new ArrayList<>();
        parkingLotList1.add(new ParkingLot(10));
        parkingLotList2.add(new ParkingLot(10));
        Car car = new Car();

        //when
        ParkingManager parkingManager = new ParkingManager(parkingLotList1, new NormalParkingStrategy());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList2, new NormalParkingStrategy());
        parkingManager.manage(parkingBoy);
        parkingManager.park(car);

        //then
        assertEquals(1, parkingLotList1.size());
    }
}
