package entity;

import java.util.ArrayList;

public class Crew {
    private int id;
    private ArrayList<Member> members;

    public Crew(int id, ArrayList<Member> members) {
        this.id = id;
        this.members = members;
    }
}
