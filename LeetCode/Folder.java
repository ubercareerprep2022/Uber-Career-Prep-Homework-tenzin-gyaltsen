package LeetCode;
import java.util.*;

/**
  Ex: 
  list = [Folder(0, [7, 3], “abc”), Folder(0, [], “xyz”), Folder(8, [], “def”), Folder(7, [9], “ijk), Folder(9, [], “lmn”)]
 
  printPath(9) = “abc” -> “ijk” -> “lmn” printPath(8) = ""
 */

public class Folder {
    int id;
    List<Folder> subfolders;
    String name;

    public Folder (int id, String name) {
        this.id = id;
        this.name = name;
        subfolders = new ArrayList<>();
    }

    public void addSubfolders (Folder newFolder) {
        subfolders.add(newFolder);
    }



    public static void main(String[] args) {
        Folder folder = new Folder(1959, "Tibet");
    }
}
 
 
