package ro.info.uaic;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {

        Student[] studenti = IntStream.range(0, 4).mapToObj(i -> new Student("s" + i)).toArray(Student[]::new);
        School[] scoli = IntStream.range(0, 3).mapToObj(i -> new School("sh" + i)).toArray(School[]::new);

        Faker faker = new Faker();
        /**
         * Dau nume random studentilor
         */
        studenti[0].setNume(faker.name().firstName());
        studenti[1].setNume(faker.name().firstName());
        studenti[2].setNume(faker.name().firstName());
        studenti[3].setNume(faker.name().firstName());
        /**
         * Dau nume random scolilor
         */
        scoli[0].setNume(faker.name().bloodGroup());
        scoli[1].setNume(faker.name().bloodGroup());
        scoli[2].setNume(faker.name().bloodGroup());


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
        if (true) {
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
        for (School s : scoli) {
            if (s.getNume().compareTo("sh0") == 0) s.setCapacity(3);
            else s.setCapacity(2);
        }
        /**
         * Setez lista de preferinte pentru fiecare scoala
         */
        if (true) {
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
        TreeSet<School> listaScoala = new TreeSet<School>(Arrays.asList(scoli));


        /**
         * Afisare listaPreferinte pentru studenti
         */
        listaStudenti.forEach(element -> element.printMap());
        /**
         * Afisare listaCandidatiAlocati pentru scoli
         */
        System.out.println();
        listaScoala.forEach(element -> element.printMap());

        Problem rezolvare = new Problem();
        rezolvare.setListaScoli(listaScoala);
        rezolvare.setListaStudenti(listaStudenti);
        rezolvare.solution();

    }
}

