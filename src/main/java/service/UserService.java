package service;

import dao.sql.MemberDAOSQL;
import entity.Member;
import utils.Hasher;

public class UserService {
    public static Member register(String firstName, String middleName, String lastName, String email, String phash) {
        if (!firstName.isEmpty() && !middleName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !phash.isEmpty()) {
            try {
                if (!(new MemberDAOSQL().isMemberExists(email))) {
                    Member member = new Member(firstName, middleName, lastName, email, phash);
                    if (new MemberDAOSQL().addMember(member)) {
                        return member;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Member auth(String email, String phash) {
        try {
            Member member = new MemberDAOSQL().getMember(email);
            if (member != null && member.passwordHash.equals(phash)) {
                return member;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
