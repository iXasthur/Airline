package entity;

public class Member {

    public enum Role {
        ADMIN,
        SUPERVISOR,
        PILOT,
        NAVIGATOR,
        RADIOMAN,
        STEWARDESS,
        CUSTOMER
    }

    public final Integer id;
    public final String firstName;
    public final String middleName;
    public final String lastName;
    public final Role role;
    public final String email;
    public final String passwordHash;

    public Member(Integer id, String firstName, String middleName, String lastName, Role role, String email, String passwordHash) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public Member(String firstName, String middleName, String lastName, String email, String passwordHash) {
        this.id = null;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = Role.CUSTOMER;
    }
}
