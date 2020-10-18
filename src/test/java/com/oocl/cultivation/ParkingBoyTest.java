package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {

    @Test
    void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() throws Exception {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));

        //when
        ParkingTicket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_correct_car_when_fetching_given_a_correct_ticket() throws Exception {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //when
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        //then
        assertSame(car, fetchedCar);
    }

    @Test
    void should_return_two_cars_when_fetching_two_cars_with_corresponding_tickets_given_two_cars() throws Exception {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket1 = parkingBoy.park(car1);
        ParkingTicket parkingTicket2 = parkingBoy.park(car2);

        //when
        Car fetchedCar1 = parkingBoy.fetch(parkingTicket1);
        Car fetchedCar2 = parkingBoy.fetch(parkingTicket2);

        //then
        assertSame(car1, fetchedCar1);
        assertSame(car2, fetchedCar2);
    }

    @Test
    void should_return_no_car_when_fetching_a_car_given_a_wrong_ticket() throws Exception {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        parkingBoy.park(car);

        //when
        Car fetchedCar = parkingBoy.fetch(new ParkingTicket());

        //then
        assertSame(null, fetchedCar);
    }

    @Test
    void should_return_no_car_when_fetching_a_car_given_no_ticket() throws Exception {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));

        //when
        parkingBoy.park(car);

        //then
        assertThrows(ProvideParkingTicketException.class, () -> {parkingBoy.fetch(null);});
    }

    @Test
    void should_return_no_car_when_fetching_a_car_given_a_parking_ticket_been_used() throws Exception {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //when
        parkingTicket.setUsed(true);

        //then
        assertThrows(UnrecognizedParkingTicketException.class, () -> {parkingBoy.fetch(parkingTicket);});
    }

    @Test
    void should_return_park_car_failed_and_no_ticket_returned_when_parking_a_car_given_a_parking_lot_capacity_1() throws Exception {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));

        //when
        parkingBoy.park(car1);
        ParkingTicket parkingTicket = parkingBoy.park(car2);

        //then
        assertNull(parkingTicket);
    }


}
