package ro.info.uaic;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Student implements Comparable<Student>{
    private String nume;
    /**
     * Structura de date care imi permite sa stochez preferintele studentului
     */
    Map<Student, List<School>> listaPreferinte;

    Student(){
        nume = null;
        listaPreferinte = new TreeMap<Student, List<School>>();
    }
    Student(String nume){
        this.nume = nume;
        this.listaPreferinte = new TreeMap<Student, List<School>>();
    }

    /**
     * Getter pentru listaPreferinta
     * @return
     */
    public Map<Student, List<School>> getListaPreferinte(){
        return listaPreferinte;
    }
    /**
     * Pentru un 'student' inregistrez preferintele
     */
    public void putInListaPreferinte(Student student, List<School> lista){
        this.listaPreferinte.put(student, lista);
    }
    /**
     * Setez numele unui student
     * @param nume
     */
    public void setNume(String nume){
        this.nume = nume;
    }
    /**
     * Preluam numele studentului
     * @return
     */
    public String getNume(){
        return  nume;
    }
    /**
     * printeaza legatura intre student si lista de scoli
     */
    public void printMap(){
        for(Map.Entry<Student, List<School>>  map : listaPreferinte.entrySet()){
            System.out.print("\nPentru studentul " + map.getKey().getNume() + " lista de preferinte este: ");
            for(int i = 0; i < map.getValue().size(); ++i){
                System.out.print(map.getValue().get(i).getNume() + ", ");
            }
        }
    }

    public int compareTo(Student s){
        if(nume.compareTo(s.getNume()) == 0) return 0;
        else if(nume.compareTo(s.getNume()) > 0) return 1;
        return -1;
    }

}
