package dao.sql;

import dao.CrewDAO;
import entity.Crew;
import entity.Member;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrewDAOSQL implements CrewDAO {
    @Override
    public List<Crew> getCrews() throws Exception {
        Connection connection = DBConnection.connect();

        try {
            List<Crew> crews = new ArrayList<>();

            PreparedStatement query = connection.prepareStatement("SELECT * FROM crew");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                int _id = result.getInt(1);
                ArrayList<Member> crewMembers = new ArrayList<>();

                PreparedStatement queryM = connection.prepareStatement("SELECT * FROM crew_member WHERE crew_id LIKE ?");
                queryM.setString(1, Integer.toString(_id));

                ResultSet resultM = queryM.executeQuery();
                while (resultM.next()) {
                    int _idM = resultM.getInt(2);
                    crewMembers.add(new MemberDAOSQL().getMemberByID(_idM));
                }

                crews.add(new Crew(_id, crewMembers));
            }

            return crews;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addCrew(Crew crew) throws Exception {
        Connection connection = DBConnection.connect();

        try {
            PreparedStatement addCrewQuery = connection.prepareStatement("INSERT INTO crew (id) VALUES (null)");
            addCrewQuery.execute();

            PreparedStatement maxIdQuery = connection.prepareStatement("SELECT MAX(id) FROM crew");
            ResultSet result = maxIdQuery.executeQuery();
            result.next();
            int newID = result.getInt(1);

            for (Member member : crew.members) {
                PreparedStatement addCrewMemberQuery = connection.prepareStatement("INSERT INTO crew_member (crew_id, member_id) VALUES (?, ?)");
                addCrewMemberQuery.setString(1, Integer.toString(newID));
                addCrewMemberQuery.setString(2, Integer.toString(member.id));
                addCrewMemberQuery.execute();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
