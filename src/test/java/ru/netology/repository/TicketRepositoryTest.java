package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Ticket;

public class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private Ticket ticket1 = new Ticket(1, 15000, "SVO", "KGD", 150);
    private Ticket ticket2 = new Ticket(2, 20000, "DME", "BER", 180);
    private Ticket ticket3 = new Ticket(3, 22000, "VKO", "CDG", 200);
    private Ticket ticket4 = new Ticket(4, 16000, "SVO", "KGD", 150);

    @BeforeEach
    public void setUp() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
    }

    @Test
    public void shouldFindById() {
        int id = 1;
        Ticket expected = ticket1;
        Ticket actual = repository.findById(id);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfFalse() {
        int id = 5;
        Ticket expected = null;
        Ticket actual = repository.findById(id);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int id = 1;
        repository.removeById(id);
        Ticket[] expected = new Ticket[]{ticket2, ticket3, ticket4};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
