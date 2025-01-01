package nightclubmanagement;

public class Guest {
    private String name;
    private int id;
    private int age;
    private String gender;
    private boolean isVIP;

    public Guest(String name) {
        this.name = name;
    }

    public Guest(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public Guest(String name, int id, int age, String gender, boolean isVIP) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.isVIP = isVIP;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public boolean isVIP() {
        return isVIP;
    }
}