package ro.info.uaic;

import com.sun.source.tree.Scope;
import com.sun.source.tree.Tree;

import java.util.*;

public class Solution {
    private Map<Student, School> listaSolutii;

    Solution(){
        listaSolutii = new HashMap<>();
    }

    /**
     * setter pentru listaSolutii
     * @param lista
     */
    public void setListaSolutii(Map<Student, School> lista){
        this.listaSolutii = lista;
    }
    /**
     * getter pentru listaSolutii
     * @return
     */
    public Map<Student, School> getListaSolutii(){
        return listaSolutii;
    }
    /**
     * printeaza lista cu solutiile finale
     */
    public void printMap(){
        for(Map.Entry<Student, School>  map : listaSolutii.entrySet()){
            System.out.print("\n Studentul " + map.getKey().getNume() + " a fost alocat scolii: " + map.getValue().getNume());
        }
    }
    /**
     * selecteaza din listaStudenti de pe pozitia index
     * @param listaStudenti
     * @param index
     * @return
     */
    public Student getStudentByIndex(List<Student> listaStudenti, int index){
        int i;
        for(i = 0; i < listaStudenti.size() && i < index; ++i);
        return listaStudenti.get(i);
    }
    /**
     * selecteaza din listaScoala de pe pozitia index
     * @param listaScoala
     * @param index
     * @return
     */
    public School getSchooldByIndex(TreeSet<School> listaScoala, int index){
        int stop = 0;
        School s2 = new School();
        for(School s: listaScoala){
            if(stop == index) return s;
            stop++;
        }
        return s2;
    }
    /**
     * solutie pentru exemplu de pe site
     * @param listaStudenti
     * @param listaScoala
     */
    public void solutionExample(List<Student> listaStudenti, TreeSet<School> listaScoala){
        listaSolutii.put(getStudentByIndex(listaStudenti, 0), getSchooldByIndex(listaScoala, 1));
        listaSolutii.put(getStudentByIndex(listaStudenti, 1), getSchooldByIndex(listaScoala, 2));
        listaSolutii.put(getStudentByIndex(listaStudenti, 2), getSchooldByIndex(listaScoala, 1));
        listaSolutii.put(getStudentByIndex(listaStudenti, 3), getSchooldByIndex(listaScoala, 0));
        printMap();
    }
    /**
     * Pune in listaSolutii legatura dintre student si school
     * @param student
     * @param school
     */
    public void putInList(Student student, School school){
        this.listaSolutii.put(student, school);
    }

    /**
     * Este o metoda ce prezinta algoritmul pentru rezolvarea problemei.
     * O scoala trece prin lista studentilor, acestia fiind prdonati crescator,
     * si face cateva verificari:
     * 1. verifica daca in lista de preferinte a scolii respectiv a studentului acestia se regasesc
     * 2. verifica daca studentul nu a mai fost alocat si daca numarul studentilor alocati unei scoli nu trece de capacitatea acesteia
     * @param listaStudenti
     * @param listaScoala
     */
    public void solutionInGeneral(List<Student> listaStudenti, TreeSet<School> listaScoala){
        int cap, indexStudent;
        for(School school: listaScoala){
            cap = 0;
            for(indexStudent = 0; indexStudent < listaStudenti.size(); ++indexStudent)
                if(listaStudenti.get(indexStudent).isInList(school) == 1 && school.isInList(listaStudenti.get(indexStudent)) == 1)
                    if(school.getCapacity() >= cap && listaStudenti.get(indexStudent).getAlocat() == 0) {
                        putInList(listaStudenti.get(indexStudent), school);
                        cap++;
                        listaStudenti.get(indexStudent).setAlocat(1);
                    }
        }
        printMap();
    }
}
