package ro.info.uaic;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        School sh1 = new School();
        School sh2 = new School();
        School sh3 = new School();

        /**
         * Am declarat cateva obiecte din clasa Student si le-am pus in lista. Dupa ce am adaugat toate elementele am sortat lista
         */
        s1.setNume("Dragos");
        s2.setNume("Cezar");
        s3.setNume("Rares");

        List<Student> listaStudenti = new LinkedList<Student>();
        listaStudenti.add(s1);
        listaStudenti.add(s2);
        listaStudenti.add(s3);

        Collections.sort(listaStudenti, new Compare());
        for(Student e:listaStudenti)
            System.out.println(e.getNume());


        sh1.setNume("Gimnaziala");
        sh2.setNume("Racovita");
        sh3.setNume("LMK");

        TreeSet<School> listaScoala = new TreeSet<School>();
        listaScoala.add(sh1);
        listaScoala.add(sh2);
        listaScoala.add(sh3);

        for(School s:listaScoala)
            System.out.println(s.getNume());
    }
}
