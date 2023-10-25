package seminars.fourth.message;


import org.junit.jupiter.api.Test;
import seminars.fourth.hotel.BookingService;
import seminars.fourth.hotel.HotelService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @Test
    void bookingTestNegative() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(1)).thenReturn(false);

        boolean check = bookingService.bookRoom(1);

        verify(hotelService, times(1)).isRoomAvailable(1);
        assertThat(check).isEqualTo(false);
    }
}