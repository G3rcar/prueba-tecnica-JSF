/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerardo.pruebatecnicajava.ejb;

import com.gerardo.pruebatecnicajava.entities.Readers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gerardo.calderon
 */
@Local
public interface ReadersFacadeLocal {

    void create(Readers readers);

    void edit(Readers readers);

    void remove(Readers readers);

    Readers find(Object id);

    List<Readers> findAll();

    List<Readers> findRange(int[] range);

    int count();
    
}
