package Assignment2;

import java.util.*;

public class PhoneTree implements PhoneBook{

    BSPhoneTree binaryPhoneTree;

    public PhoneTree (String name, long phoneNumber) {
        binaryPhoneTree = new BSPhoneTree(name);
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public void insert(String name, long phoneNumber) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long find(String name) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
