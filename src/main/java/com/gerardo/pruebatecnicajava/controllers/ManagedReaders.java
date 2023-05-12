/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerardo.pruebatecnicajava.controllers;

import com.gerardo.pruebatecnicajava.ejb.ReadersFacadeLocal;
import com.gerardo.pruebatecnicajava.entities.Readers;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gerardo.calderon
 */
@Named
@ViewScoped
public class ManagedReaders implements Serializable {
    
    @EJB
    private ReadersFacadeLocal readersFL;
    private List<Readers> readersList;
    private Readers reader;

    
    
    public List<Readers> getReadersList() {
        this.readersList = this.readersFL.findAll();
        return readersList;
    }

    public void setReadersList(List<Readers> readersList) {
        this.readersList = readersList;
    }

    public Readers getReader() {
        return reader;
    }

    public void setReader(Readers reader) {
        this.reader = reader;
    }
    
    
    
    
    @PostConstruct
    public void init() {
        clean();
    }
    
    public void edit(Readers reader) {
        this.reader = reader;
    }
    
    public void save() {
        if(reader.getId() != null){
            readersFL.edit(reader);
        } else {
            readersFL.create(reader);
        }
        reader = new Readers();
    }
    
    public void clean() {
        reader = new Readers();
    }
    
    public void delete() {
        readersFL.remove(reader);
        clean();
    }
    
    
}
