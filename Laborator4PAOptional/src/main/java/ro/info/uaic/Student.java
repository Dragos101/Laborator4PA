package ro.info.uaic;

import java.util.*;

public class Student implements Comparable<Student>{
    private String nume;
    /**
     * Structura de date care imi permite sa stochez preferintele studentului
     */
    private Map<Student, List<School>> listaPreferinte;
    private int nota, alocat;

    Student(){
        this.nota = 0;
        this.nume = null;
        this.listaPreferinte = new TreeMap<Student, List<School>>();
        this.alocat = 0;
    }
    Student(String nume){
        this.nota = 0;
        this.nume = nume;
        this.listaPreferinte = new TreeMap<Student, List<School>>();
        this.alocat = 0;
    }

    /**
     * setter pentru alocat
     * @param alocat
     */
    public void setAlocat(int alocat){
        this.alocat = alocat;
    }
    /**
     * getter pentru alocat
     * @return
     */
    public int getAlocat(){
        return alocat;
    }
    /**
     * getter pentru nota
     * @return
     */
    public int getNota(){
        return nota;
    }
    /**
     * Setter pentru nota student
     * @param nota
     */
    public void setNota(int nota){
        this.nota = nota;
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
    /**
     * verifica daca scoala s se afla in lista de preferinte a studentului
     * @param s
     * @return
     */
    public int isInList(School s){
        for(Map.Entry<Student, List<School>> map : listaPreferinte.entrySet())
            for(int i = 0; i < map.getValue().size(); ++i){
                if(map.getValue().get(i).getNume().compareTo(s.getNume()) == 0) return 1;
            }
        return 0;
    }
    public List<School> getValuesFromMap(){
        List<School> students = new LinkedList<>();
        for(Map.Entry<Student, List<School>> map : listaPreferinte.entrySet())
            return map.getValue();
        return students;
    }


    public int compareTo(Student s){
        if(nume.compareTo(s.getNume()) == 0) return 0;
        else if(nume.compareTo(s.getNume()) > 0) return 1;
        return -1;
    }

}
