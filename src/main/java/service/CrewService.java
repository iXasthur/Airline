package service;

import dao.sql.CrewDAOSQL;
import dao.sql.MemberDAOSQL;
import entity.Crew;
import entity.Member;

import java.util.List;

public class CrewService {
    public static List<Crew> getAll() {
        try {
            return new CrewDAOSQL().getCrews();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Crew byID(int id) {
        List<Crew> crews = getAll();
        crews.removeIf(crew -> crew.id != id);
        return crews.get(0);
    }
}
