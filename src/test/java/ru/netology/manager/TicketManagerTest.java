package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket ticket1 = new Ticket(1, 16000, "SVO", "KGD", 150);
    private Ticket ticket2 = new Ticket(2, 20000, "DME", "BER", 180);
    private Ticket ticket3 = new Ticket(3, 22000, "VKO", "CDG", 200);
    private Ticket ticket4 = new Ticket(4, 15000, "SVO", "KGD", 150);

    @BeforeEach
    public void setUp() {
        manager = new TicketManager(repository);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
    }

    @Test
    public void shouldFindByArrivalAndDeparture() {
        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.findAll("DME", "BER");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsWithSameArrivalAndDeparture() {
        Ticket[] expected = {ticket4, ticket1};
        Ticket[] actual = manager.findAll("SVO", "KGD");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindIfFalseData() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("ZIA", "ORD");
        Assertions.assertArrayEquals(expected, actual);
    }
}

