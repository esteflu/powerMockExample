package com.lundberg;

import com.lundberg.model.Car;
import com.lundberg.model.Truck;

public class VehicleMapper {

    public Truck mapFrom(Car car) {
        Truck truck = new Truck();
        truck.setColor(car.getColor());
        truck.setBrand(car.getBrand());
        truck.setVin(getCarVin(car));
        return truck;
    }

    private String getCarVin(Car car) {
        //pretend expensive db operation...sort of
        return "xtu938";
    }
}
