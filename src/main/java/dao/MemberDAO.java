package dao;

import entity.Member;

import java.util.List;

public interface MemberDAO {
    Member getMember(String email) throws Exception;
    List<Member> getMembers() throws Exception;
    boolean addMember(Member member) throws Exception;
    boolean isMemberExists(String email) throws Exception;
}
