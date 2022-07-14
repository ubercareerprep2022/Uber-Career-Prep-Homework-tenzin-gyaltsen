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

    public int getListSize(){
        return phoneList.size();
    }

    public void printAll () {
        System.out.println(" name: " + phoneList.get(0).getName() + "  number: " + phoneList.get(0).getPhoneNumber());
    }


    public static void main(String[] args) {
        PhoneDirectory phone = new PhoneDirectory();
        phone.insert("Bhusang", 505419348);
        phone.insert("Tashi DHondup", 351945821);
        phone.printAll();
    }
    
}
