package Assignment2;

public class phoneNumber {
    private String name;
    private long number;

    public phoneNumber(String name, long number) {
        this.name = name;
        this.number = number;
    }

    public long getPhoneNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
