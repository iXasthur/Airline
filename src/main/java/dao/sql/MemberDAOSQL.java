package dao.sql;

import dao.MemberDAO;
import entity.Member;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAOSQL implements MemberDAO {

    @Override
    public Member getMember(String email) throws Exception {
        Connection connection = DBConnection.connect();

        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM member WHERE email LIKE ?");
            query.setString(1, email);

            ResultSet result = query.executeQuery();
            if (result.next()) {
                int _id = result.getInt(1);
                String _firstName = result.getString(2);
                String _middleName = result.getString(3);
                String _lastName = result.getString(4);
                Member.Role _role = Member.Role.valueOf(result.getString(5).toUpperCase());
                String _email = result.getString(6);
                String _passwordHash = result.getString(7);
                return new Member(_id, _firstName, _middleName, _lastName, _role, _email, _passwordHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addMember(Member member) throws Exception {
        Connection connection = DBConnection.connect();

        try {
            PreparedStatement addUserQuery = connection.prepareStatement("INSERT INTO member (first_name, middle_name, last_name, role, email, password_hash) VALUES (?, ?, ?, ?, ?, ?)");
            addUserQuery.setString(1, member.firstName);
            addUserQuery.setString(2, member.middleName);
            addUserQuery.setString(3, member.lastName);
            addUserQuery.setString(4, member.role.name().toLowerCase());
            addUserQuery.setString(5, member.email);
            addUserQuery.setString(6, member.passwordHash);

            return addUserQuery.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public boolean isMemberExists(String email) throws Exception {
        return getMember(email) != null;
    }
}
