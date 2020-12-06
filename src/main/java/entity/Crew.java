package entity;

import java.util.ArrayList;

public class Crew {
    public final int id;
    public final ArrayList<Member> members;

    public Crew(int id, ArrayList<Member> members) {
        this.id = id;
        this.members = members;
    }
}
