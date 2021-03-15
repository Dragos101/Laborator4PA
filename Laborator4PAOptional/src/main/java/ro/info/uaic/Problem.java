package ro.info.uaic;

import com.sun.source.tree.Tree;

import java.util.*;

public class Problem {
    List<Student> listaStudenti;
    TreeSet<School> listaScoli;
    Map<Student, School> listaFinala;

    Problem() {
        listaStudenti = new LinkedList<>();
        listaScoli = new TreeSet<>();
        listaFinala = new HashMap<>();
    }

    /**
     * getter pentru listaStudenti
     * @return
     */
    public List<Student> getListaStudenti(){
        return listaStudenti;
    }
    /**
     * setter pentru listaStudenti
     * @param lista
     */
    public void setListaStudenti(List<Student> lista){
        this.listaStudenti = lista;
    }
    /**
     * getter pentru listaScoli
     * @return
     */
    public TreeSet<School> getListaScoli(){
        return listaScoli;
    }
    /**
     * setter pentru listaScoli
     * @param lista
     */
    public void setListaScoli(TreeSet<School> lista){
        this.listaScoli = lista;
    }
    /**
     * printeaza solutie pentru un set de date ex: listaScoli, listaStudenti
     */
    public void solution(){
        Solution solution = new Solution();
        System.out.println();
        solution.solutionExample(listaStudenti, listaScoli);
    }

}
