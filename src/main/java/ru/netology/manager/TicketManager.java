package ru.netology.manager;


import ru.netology.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket item) {
        repository.save(item);
    }


    public Ticket[] findAll(String to, String from) {
        Ticket[] result = new Ticket[0];
        for (Ticket item : repository.findAll()) {
            if (item.getDeparture().contains(to) && item.getArrivals().contains(from)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
