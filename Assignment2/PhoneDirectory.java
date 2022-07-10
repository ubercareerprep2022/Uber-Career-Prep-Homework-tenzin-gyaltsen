package Assignment2;

import java.util.*;

public class PhoneDirectory implements PhoneBook {
    private List<phoneNumber> phoneList = new ArrayList<>();

    @Override
    public int size() {
        return phoneList.size();
    }

    @Override
    public void insert(String name, long phoneNumber) {
        phoneList.add(new phoneNumber(name, phoneNumber));
    }

    @Override
    public long find(String name) {
        for (phoneNumber phone : phoneList){
            if(phone.getName() == name) {
                return phone.getPhoneNumber();
            }
        }
        return -1;
    }
    
}
