package entity;

public class Ticket {
    private int id;
    private Member member;
    private Flight flight;

    public Ticket(int id, Member member, Flight flight) {
        this.id = id;
        this.member = member;
        this.flight = flight;
    }
}
