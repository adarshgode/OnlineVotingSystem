package entity;

public class Voter {
    private int voterId;
    private String adharNo;
    private String name;
    private String password;
    private String role;
    private int age;
    private boolean status;

    public Voter() {
    }

    public Voter(int voterId, String adharNo, String name, String password, String role, int age, boolean status) {
        this.voterId = voterId;
        this.adharNo = adharNo;
        this.name = name;
        this.password = password;
        this.role = role;
        this.age = age;
        this.status = status;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public String getAdharNo() {
        return adharNo;
    }

    public void setAdharNo(String adharNo) {
        this.adharNo = adharNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "voterId=" + voterId +
                ", adharNo='" + adharNo + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}

