package ro.info.uaic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School implements Comparable<School>{
    private String nume;
    private int capacity;
    /**
     * Mapa ce reprezinta preferintele scolilor fata de studenti
     */
    Map<School , List<Student>> listaCandidatiAlocati;

    School(){
        this.nume = null;
        this.capacity = 0;
        listaCandidatiAlocati = new HashMap<School , List<Student>>();
    }
    School(String nume){
        this.nume = nume;
        this.capacity = 0;
        listaCandidatiAlocati = new HashMap<School , List<Student>>();
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

    public void printMap(){
        for(Map.Entry<School, List<Student>>  map : listaCandidatiAlocati.entrySet()){
            System.out.print("\n" + map.getKey().getNume() + " ");
            for(int i = 0; i < map.getValue().size(); ++i){
                System.out.print(map.getValue().get(i).getNume() + " ");
            }
        }
    }

    public int compareTo(School school){
        if(capacity == school.capacity) return 0;
        if(capacity > school.capacity) return 1;
        if(nume.compareTo(school.getNume()) == 0) return 0;
        if(nume.compareTo(school.getNume()) > 0) return 1;
        return -1;
    }

}
