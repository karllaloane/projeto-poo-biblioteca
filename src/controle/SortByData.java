/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import biblioteca.Emprestimo;
import java.time.LocalDate;
import java.util.Comparator;

/**
 *
 * @author Karlla
 */
public class SortByData implements Comparator<Emprestimo> {

    @Override
    public int compare(Emprestimo o1, Emprestimo o2) {
        return o1.getDataEmprestimo().compareTo(o2.getDataEmprestimo());
    }
    
}
