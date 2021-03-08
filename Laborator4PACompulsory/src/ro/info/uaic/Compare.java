package ro.info.uaic;

import java.util.Comparator;

public class Compare implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2){
        if(s1.getNume().compareTo(s2.getNume()) > 0) return 1;
        return -1;
    }
}
