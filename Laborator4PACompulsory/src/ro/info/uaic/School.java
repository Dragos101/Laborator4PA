package ro.info.uaic;

public class School implements Comparable<School>{
    private String nume;

    School(){
        nume = null;
    }

    public void setNume(String nume){
        this.nume = nume;
    }
    public String getNume(){
        return nume;
    }

    public int compareTo(School school){
        if(nume.compareTo(school.getNume()) == 0) return 0;
        else if(nume.compareTo(school.getNume()) > 0) return 1;
        return -1;
    }

}
