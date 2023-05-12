/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerardo.pruebatecnicajava.ejb;

import com.gerardo.pruebatecnicajava.entities.Readers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gerardo.calderon
 */
@Stateless
public class ReadersFacade extends AbstractFacade<Readers> implements ReadersFacadeLocal {

    @PersistenceContext(unitName = "com.gerardo_PruebaTecnicaJava_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReadersFacade() {
        super(Readers.class);
    }
    
}
