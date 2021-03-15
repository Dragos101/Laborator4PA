package ro.info.uaic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class School implements Comparable<School>{
    private String nume;
    private int capacity, alocat;
    /**
     * Mapa ce reprezinta preferintele scolilor fata de studenti
     */
    private Map<School , List<Student>> listaCandidatiAlocati;

    School(){
        this.nume = null;
        this.capacity = 0;
        listaCandidatiAlocati = new HashMap<School , List<Student>>();
    }
    School(String nume){
        this.nume = nume;
        this.capacity = 0;
        this.alocat = 0;
        this.listaCandidatiAlocati = new HashMap<School , List<Student>>();
    }

    /**
     * Pentru scoala 'school' adaugam 'student' ca fiind acceptat la scoala respectiva
     */
    public void setMap(School school, List<Student> list){
        listaCandidatiAlocati.put(school, list);
    }
    /**
     * Setam capacitatea unei scoli
     * @param capacity
     */
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    /**
     * Preluam capacitatea unei scoli
     * @return
     */
    public int getCapacity(){
        return capacity;
    }
    /**
     * Se seteaza numele scolii
     * @param nume
     */
    public void setNume(String nume){
        this.nume = nume;
    }
    /**
     * Preluam numele scolii
     * @return
     */
    public String getNume(){
        return nume;
    }
    /**
     * printeaza lista cu legatura intre scoala si studenti
     */
    public void printMap(){
        for(Map.Entry<School, List<Student>>  map : listaCandidatiAlocati.entrySet()){
            System.out.print("\n Pentru scoala " + map.getKey().getNume() + " lista de preferinte este ");
            for(int i = 0; i < map.getValue().size(); ++i){
                System.out.print(map.getValue().get(i).getNume() + ", ");
            }
        }
    }
    /**
     * verifica daca studentul s se afla in lista de preferinte a liceului
     * @param s
     * @return
     */
    public int isInList(Student s){
        for(Map.Entry<School , List<Student>> map : listaCandidatiAlocati.entrySet())
            for(int i = 0; i < map.getValue().size(); ++i){
                if(map.getValue().get(i).getNume().compareTo(s.getNume()) == 0) return 1;
            }
        return 0;
    }
    public List<Student> getValuesFromMap(){
        List<Student> students = new LinkedList<>();
        for(Map.Entry<School, List<Student>> map : listaCandidatiAlocati.entrySet())
            return map.getValue();
        return students;
    }

    public int compareTo(School school){
        if(nume.compareTo(school.getNume()) == 0) return 0;
        if(nume.compareTo(school.getNume()) > 0) return 1;
        return -1;
    }

}
