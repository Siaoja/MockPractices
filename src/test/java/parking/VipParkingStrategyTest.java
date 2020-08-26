package parking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class VipParkingStrategyTest {

    @Mock
    Car car;

	@Test
    public void testPark_givenAVipCarAndAFullParkingLog_thenGiveAReceiptWithCarNameAndParkingLotName() {

	    /* Exercise 4, Write a test case on VipParkingStrategy.park()
	    * With using Mockito spy, verify and doReturn */
        //given
        VipParkingStrategy mockedVipParkingStrategy = spy(new VipParkingStrategy());
        Car mockCar = mock(Car.class);
        when(mockCar.getName()).thenReturn("Car");
        ParkingLot mockParkingLot = mock(ParkingLot.class);
        when(mockParkingLot.getName()).thenReturn("parkinglot");
        when(mockParkingLot.isFull()).thenReturn(true);
        doReturn(true).when(mockedVipParkingStrategy).isAllowOverPark(mockCar);
        //when
        mockedVipParkingStrategy.park(Arrays.asList(mockParkingLot),mockCar);
        //then
        verify(mockedVipParkingStrategy,times(1)).createReceipt(mockParkingLot,mockCar);
    }

    @Test
    public void testPark_givenCarIsNotVipAndAFullParkingLog_thenGiveNoSpaceReceipt() {

        /* Exercise 4, Write a test case on VipParkingStrategy.park()
         * With using Mockito spy, verify and doReturn */
        //given
        VipParkingStrategy mockedVipParkingStrategy = spy(new VipParkingStrategy());
        Car mockCar = mock(Car.class);
        when(mockCar.getName()).thenReturn("Car");
        ParkingLot mockParkingLot = mock(ParkingLot.class);
        when(mockParkingLot.isFull()).thenReturn(true);
        doReturn(false).when(mockedVipParkingStrategy).isAllowOverPark(mockCar);
        //when
        mockedVipParkingStrategy.park(Arrays.asList(mockParkingLot),mockCar);
        //then
        verify(mockedVipParkingStrategy,times(1)).createNoSpaceReceipt(mockCar);
    }

    @Test
    public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsVipCar_thenReturnTrue(){

        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
         */
        //given
        VipParkingStrategy vipParkingStrategy = spy(new VipParkingStrategy());

        when(car.getName()).thenReturn("Avip");

        boolean isVip = vipParkingStrategy.isAllowOverPark(car);

        assertTrue(isVip);
    }

    @Test
    public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsVipCar_thenReturnFalse(){

        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
         */
        VipParkingStrategy vipParkingStrategy = spy(new VipParkingStrategy());

        when(car.getName()).thenReturn("Bvip");

        boolean isVip = vipParkingStrategy.isAllowOverPark(car);

        assertFalse(isVip);
    }

    @Test
    public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsNotVipCar_thenReturnFalse(){
        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
         */
        VipParkingStrategy vipParkingStrategy = spy(new VipParkingStrategy());

        when(car.getName()).thenReturn("Avi");

        boolean isVip = vipParkingStrategy.isAllowOverPark(car);

        assertFalse(isVip);
    }

    @Test
    public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsNotVipCar_thenReturnFalse() {
        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not PowerMock) and @InjectMocks
         */
    }

    private Car createMockCar(String carName) {
        Car car = mock(Car.class);
        when(car.getName()).thenReturn(carName);
        return car;
    }
}
