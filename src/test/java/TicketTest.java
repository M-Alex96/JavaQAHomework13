import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Ticket;

import java.util.Arrays;

public class TicketTest {
    private Ticket ticket1 = new Ticket(1, 15000, "SVO", "KGD", 150);
    private Ticket ticket2 = new Ticket(2, 20000, "DME", "BER", 180);
    private Ticket ticket3 = new Ticket(3, 22000, "VKO", "CDG", 200);
    private Ticket ticket4 = new Ticket(4, 16000, "SVO", "KGD", 150);

    @Test
    public void shouldSortByPrice() {
        Ticket[] expected = {ticket1, ticket4, ticket2, ticket3};
        Ticket[] actual = {ticket1, ticket4, ticket2, ticket3};

        Arrays.sort(actual);

        Assertions.assertArrayEquals(expected, actual);
    }
}
