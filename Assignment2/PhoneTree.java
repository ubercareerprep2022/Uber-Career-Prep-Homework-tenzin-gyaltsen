package Assignment2;

import java.util.*;

import Assignment2.BSPhoneTree.Node;

public class PhoneTree implements PhoneBook{

    BSPhoneTree binaryPhoneTree;

    public PhoneTree (String name, long number) {
        binaryPhoneTree = new BSPhoneTree(new phoneNumber(name, number));
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public void insert(String name, long number) {
        // TODO Auto-generated method stub
        binaryPhoneTree.insert(binaryPhoneTree.getRoot(), new phoneNumber(name, number));
    }

    @Override
    public long find(String name) {
        // TODO Auto-generated method stub
        return binaryPhoneTree.find(binaryPhoneTree.getRoot(), new phoneNumber(name, 0000));
    }

    public void printInorder(){
        binaryPhoneTree.printInorder(binaryPhoneTree.getRoot());
    }


    public static void main(String[] args) {
        PhoneTree phoneDir = new PhoneTree("Tenzin", 505419348);
        phoneDir.insert("Dhondup", 889416372);
        phoneDir.printInorder();
    }
    
}
