package com.lundberg;

import com.lundberg.model.Car;
import com.lundberg.model.Truck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

@RunWith(PowerMockRunner.class)
@PrepareForTest(VehicleMapper.class)
public class VehicleMapperTest {

    private static final String MOCKED_VIN = "a vin";

    @Test
    public void map_car_to_truck() throws Exception {
        //Given
        VehicleMapper vehicleMapper = spy(new VehicleMapper());

        //When
        doReturn(MOCKED_VIN).when(vehicleMapper, "getCarVin", anyObject());

        Truck truck = vehicleMapper.mapFrom(getCar());

        // Then
        assertEquals(MOCKED_VIN, truck.getVin());
        verifyPrivate(vehicleMapper).invoke("getCarVin", anyObject());
    }

    private Car getCar() {
        Car car = new Car();
        car.setVin("vin");
        car.setBrand("volvo");
        car.setColor("black");
        return car;
    }

}