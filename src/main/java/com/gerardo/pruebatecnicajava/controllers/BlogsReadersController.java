/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerardo.pruebatecnicajava.controllers;

import com.gerardo.pruebatecnicajava.ejb.BlogsFacadeLocal;
import com.gerardo.pruebatecnicajava.ejb.BlogsReadersFacadeLocal;
import com.gerardo.pruebatecnicajava.ejb.ReadersFacadeLocal;
import com.gerardo.pruebatecnicajava.entities.Blogs;
import com.gerardo.pruebatecnicajava.entities.BlogsReaders;
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
public class BlogsReadersController implements Serializable {
    
    @EJB
    private BlogsReadersFacadeLocal blogsReadersFL;
    @EJB
    private BlogsFacadeLocal blogsFL;
    @EJB
    private ReadersFacadeLocal readersFL;

    private List<BlogsReaders> blogsReadersList;
    private BlogsReaders blogsReaders;
    private Blogs blog = new Blogs();
    private Readers reader = new Readers();

    
    
    public List<BlogsReaders> getBlogsReadersList() {
        this.blogsReadersList = this.blogsReadersFL.findAll();
        return blogsReadersList;
    }

    public void setBlogsReadersList(List<BlogsReaders> blogsReadersList) {
        this.blogsReadersList = blogsReadersList;
    }

    public BlogsReaders getBlogsReaders() {
        return blogsReaders;
    }

    public void setBlogsReaders(BlogsReaders blogsReaders) {
        this.blogsReaders = blogsReaders;
    }
    
    public Blogs getBlog() {
        return blog;
    }

    public void setBlog(Blogs blog) {
        this.blog = blog;
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
    
    public void edit(BlogsReaders reader) {
        this.blogsReaders = reader;
        this.blog = reader.getBId();
        this.reader = reader.getRId();
    }
    
    public void save() {
        this.blogsReaders.setBId(blogsFL.find(this.blog.getId()));
        this.blogsReaders.setRId(readersFL.find(this.reader.getId()));
        
        if(blogsReaders.getId() != null){
            blogsReadersFL.edit(blogsReaders);
        } else {
            blogsReadersFL.create(blogsReaders);
        }
        blogsReaders = new BlogsReaders();
    }
    
    public void clean() {
        blogsReaders = new BlogsReaders();
        reader = new Readers();
        blog = new Blogs();
    }
    
    public void delete() {
        blogsReadersFL.remove(blogsReaders);
        clean();
    }
    
    
}
