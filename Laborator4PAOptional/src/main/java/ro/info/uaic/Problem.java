package ro.info.uaic;

import com.sun.source.tree.Tree;

import java.util.*;

public class Problem {
    private List<Student> listaStudenti;
    private TreeSet<School> listaScoli;
    private int[] note;

    Problem() {
        listaStudenti = new LinkedList<>();
        listaScoli = new TreeSet<>();
    }

    /**
     * note este vectorul de note astfel pe pozitia 0 se afla nota pentru studentul de la pozitia 0 din lista listaStudenti
     * @param note
     */
    public void setNote(int[] note){
        this.note = note;
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
        solution.solutionInGeneral(listaStudenti, listaScoli);
    }

}
