package dao;

import entity.Crew;
import entity.Member;

import java.util.List;

public interface CrewDAO {
    List<Crew> getCrews() throws Exception;
    boolean addCrew(Crew crew) throws Exception;
}
