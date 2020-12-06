package service;

import dao.sql.MemberDAOSQL;
import entity.Member;
import utils.Hasher;

public class UserService {
    public static void register(String firstName, String middleName, String lastName, String email, String password) {
        if (!firstName.isEmpty() && !middleName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            try {
                if (!(new MemberDAOSQL().isMemberExists(email))) {
                    Member member = new Member(firstName, middleName, lastName, email, Hasher.SHA256(password));
                    new MemberDAOSQL().addMember(member);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Member auth(String email, String password) {
        try {
            Member member = new MemberDAOSQL().getMember(email);
            if (member.passwordHash.equals(Hasher.SHA256(password))) {
                return member;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
