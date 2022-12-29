package ru.netology;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String departure;
    private String arrivals;
    private int travelTime;

    public Ticket(int id, int price, String departure, String arrivals, int travelTime) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrivals = arrivals;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrivals() {
        return arrivals;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
