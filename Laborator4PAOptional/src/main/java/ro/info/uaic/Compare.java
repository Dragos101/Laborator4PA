package ro.info.uaic;

import java.util.Comparator;

public class Compare implements Comparator<Student> {

    /**
     * Metoda prin care compar studentul s1 cu studentul s2
     * @param s1
     * @param s2
     * @return
     */
    @Override
    public int compare(Student s1, Student s2){
        if(s1.getNota() > s2.getNota()) return 1;
        return -1;
    }
}
