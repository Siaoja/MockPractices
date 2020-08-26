package parking;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class InOrderParkingStrategyTest {

	@Test
    public void testCreateReceipt_givenACarAndAParkingLog_thenGiveAReceiptWithCarNameAndParkingLotName() {

	    /* Exercise 1, Write a test case on InOrderParkingStrategy.createReceipt()
	    * With using Mockito to mock the input parameter */
        //given
        ParkingLot mockParkingLot = mock(ParkingLot.class);
        Car mockCar = mock(Car.class);
        when(mockParkingLot.getName()).thenReturn("a");
        when(mockCar.getName()).thenReturn("Car");
        InOrderParkingStrategy inOrderParkingStrategy=new InOrderParkingStrategy();
        //when
        Receipt receipt=inOrderParkingStrategy.createReceipt(mockParkingLot,mockCar);
        //then
        assertEquals("a",receipt.getParkingLotName());
        assertEquals("Car",receipt.getCarName());
    }

    @Test
    public void testCreateNoSpaceReceipt_givenACar_thenGiveANoSpaceReceipt() {

        /* Exercise 1, Write a test case on InOrderParkingStrategy.createNoSpaceReceipt()
         * With using Mockito to mock the input parameter */
        //given
        Car mockCar = mock(Car.class);
        when(mockCar.getName()).thenReturn("Car");
        InOrderParkingStrategy inOrderParkingStrategy=new InOrderParkingStrategy();
        //when
        Receipt receipt=inOrderParkingStrategy.createNoSpaceReceipt(mockCar);
        //then
        assertEquals("Car",receipt.getCarName());
    }

    @Test
    public void testPark_givenNoAvailableParkingLot_thenCreateNoSpaceReceipt(){

	    /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for no available parking lot */
        //given
        Car mockCar = mock(Car.class);
        when(mockCar.getName()).thenReturn("Car");
        InOrderParkingStrategy mockedInOrderParkingStrategy = spy(new InOrderParkingStrategy());
        //when
        mockedInOrderParkingStrategy.park(null,mockCar);
        //then
        verify(mockedInOrderParkingStrategy,times(1)).createNoSpaceReceipt(mockCar);
    }

    @Test
    public void testPark_givenThereIsOneParkingLotWithSpace_thenCreateReceipt(){

        /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot */

    }

    @Test
    public void testPark_givenThereIsOneFullParkingLot_thenCreateReceipt(){

        /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot but it is full */

    }

    @Test
    public void testPark_givenThereIsMultipleParkingLotAndFirstOneIsFull_thenCreateReceiptWithUnfullParkingLot(){

        /* Exercise 3: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for multiple parking lot situation */

    }


}
