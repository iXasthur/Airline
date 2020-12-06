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

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String passwordHash;
    private Role role;
}
