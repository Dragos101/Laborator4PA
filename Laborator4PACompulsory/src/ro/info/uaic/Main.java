package ro.info.uaic;

import javax.lang.model.type.ArrayType;
import java.util.*;
import java.util.stream.IntStream;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {

        Student[] studenti = IntStream.range(0,4).mapToObj(i-> new Student("s" + i)).toArray(Student[] :: new);
        School[] scoli = IntStream.range(0,3).mapToObj(i -> new School("sh" + i)).toArray(School[] :: new);

        /**
         * Am adaugat cei 3 studenti in listaStudenti
         */
        List<Student> listaStudenti = new LinkedList<>(Arrays.asList(studenti));
        /**
         * Sortez lista de studenti cu ajutorul metodei din clasa Compare
         */
        Collections.sort(listaStudenti, new Compare());
        /**
         * Setez lista de preferinte pentru fiecare student
         */
        if(true) {
            List<School> lista = new ArrayList<>();
            lista.add(scoli[0]);
            lista.add(scoli[1]);
            lista.add(scoli[2]);
            listaStudenti.get(0).putInListaPreferinte(listaStudenti.get(0), lista);
            listaStudenti.get(1).putInListaPreferinte(listaStudenti.get(1), lista);

            lista = new ArrayList<>();
            lista.add(scoli[0]);
            lista.add(scoli[1]);
            listaStudenti.get(2).putInListaPreferinte(listaStudenti.get(2), lista);

            lista = new ArrayList<>();
            lista.add(scoli[0]);
            lista.add(scoli[2]);
            listaStudenti.get(3).putInListaPreferinte(listaStudenti.get(3), lista);
        }

        /**
         * Am setat capacitatile pentru fiecare scoala
         */
        for(School s: scoli){
            if(s.getNume().compareTo("sh0") == 0) s.setCapacity(3);
            else s.setCapacity(2);
        }
        /**
         * Setez lista de preferinte pentru fiecare scoala
         */
        if(true){
            List<Student> list = new ArrayList<>();
            list.add(studenti[3]);
            list.add(studenti[0]);
            list.add(studenti[1]);
            list.add(studenti[2]);
            scoli[0].setMap(scoli[0], list);

            list = new ArrayList<>();
            list.add(studenti[0]);
            list.add(studenti[2]);
            list.add(studenti[1]);
            scoli[1].setMap(scoli[1], list);

            list = new ArrayList<>();
            list.add(studenti[0]);
            list.add(studenti[1]);
            list.add(studenti[3]);
            scoli[2].setMap(scoli[2], list);
        }
        /**
         * Am setat listaScoala ca fiind o lista unde sunt stocate toate scolile
         */
        TreeSet<School> listaScoala = new TreeSet<>(Arrays.asList(scoli));


        /**
         * Afisare listaPreferinte pentru studenti
         */
        for(Student student: listaStudenti)
            student.printMap();
        /**
         * Afisare listaCandidatiAlocati pentru scoli
         */
        for (School school : scoli)
            school.printMap();

    }
}
