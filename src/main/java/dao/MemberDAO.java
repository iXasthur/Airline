package dao;

import entity.Member;

public interface MemberDAO {
    Member getMember(String email) throws Exception;
    boolean addMember(Member member) throws Exception;
    boolean isMemberExists(String email) throws Exception;
}
