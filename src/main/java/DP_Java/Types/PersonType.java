package DP_Java.Types;

public class PersonType {
    private int id;
    private String firstName = null;
    private String nickName = null;
    private String lastName = null;

    private PhoneNumber homePhone = null;
    private PhoneNumber mobilePhone = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PhoneNumber getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(PhoneNumber homePhone) {
        this.homePhone = homePhone;
    }

    public PhoneNumber getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(PhoneNumber mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
